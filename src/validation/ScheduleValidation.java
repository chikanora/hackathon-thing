package validation;

import exception.InvalidScheduleException;
import exception.StaffShortageException;
import model.Shift;
import model.Staff;

import java.util.*;
import java.util.stream.Collectors;

public class ScheduleValidation {

    public void validate(List<Staff> staff, List<Shift> shifts) throws InvalidScheduleException
    {
        validateBasic(staff, shifts);
        validateAvailabilityInParallel(staff, shifts);
    }

    //validate that the data is usable and valid
    private void validateBasic(List<Staff> staff, List<Shift> shifts) throws InvalidScheduleException {
        if (staff == null || staff.isEmpty()) {
            //throw new StaffShortageException("Staff is null or empty");
            throw new InvalidScheduleException("Staff list is null or empty");
        }

        if (shifts == null || shifts.isEmpty()) {
            throw new InvalidScheduleException("Shifts is null or empty");
        }
    }

    private void validateAvailabilityInParallel(List<Staff> staff, List<Shift> shifts) throws InvalidScheduleException {
        HashSet<String> validShiftNames = new HashSet<>();
        List<String> errors = Collections.synchronizedList(new ArrayList<>());

        // add shift names to list
        for (Shift shift : shifts) {
            validShiftNames.add(shift.getName());
        }

        staff.parallelStream().forEach(s -> {
            for (String avail: s.getAvailableShifts()) {
                if (!validShiftNames.contains(avail)) {
                    errors.add("Staff" + s.getId() + " has unknown available shift: " + avail);
                }
            }
        });

        if (!errors.isEmpty()) {
            throw new InvalidScheduleException("Schedule had " + errors.size() + " errors");
        }
    }
}



