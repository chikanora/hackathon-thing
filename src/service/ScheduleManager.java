package service;

import exception.InvalidScheduleException;
import exception.ScheduleConflictException;
import exception.StaffShortageException;
import model.*;
import validation.ScheduleValidation;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScheduleManager
{
    private ScheduleValidation validator = new ScheduleValidation();

    public Schedule generate(List<Staff> staff, List<Shift> shifts)
            throws InvalidScheduleException, StaffShortageException, ScheduleConflictException
    {
        validator.validate(staff, shifts);
        Schedule schedule = new Schedule();
        Map<String, Integer> assignmentCounts = new HashMap<>();
        staff.forEach(s -> assignmentCounts.put(s.getId(), 0));

        for (Shift shift : shifts)
        {
            List<Staff> eligible = staff.stream()
                    .filter(s -> s.canWork(shift))
                    .collect(Collectors.toList());

            if (eligible.isEmpty())
            {
                throw new StaffShortageException(
                        "Shortage: no staff available for shift '" + shift.getName() +
                                "' requiring '" + shift.getRequiredRole() + "'.");
            }

            Staff chosen = eligible.stream()
                    .sorted(Comparator
                            .comparingInt((Staff s) -> assignmentCounts.getOrDefault(s.getId(), 0))
                            .thenComparing(Staff::getId))
                    .findFirst()
                    .orElseThrow();

            schedule.assign(shift, chosen);
            assignmentCounts.put(chosen.getId(), assignmentCounts.get(chosen.getId()) + 1);
        }

        return schedule;
    }
}
