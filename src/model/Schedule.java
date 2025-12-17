package model;

import java.util.*;

public class Schedule
{
    // staff id to shift name
    private final Map<String, String> ASSIGNMENTS = new LinkedHashMap<>();

    public void assign(Shift shift, Staff staff) {
        ASSIGNMENTS.put(staff.getId(), shift.getName());
    }

    public void unassign(Staff staff) {
        ASSIGNMENTS.remove(staff.getId());
    }

    public Boolean isStaffAlreadyAssigned(Staff staff) {
        return ASSIGNMENTS.containsKey(staff.getId());
    }

    public Map<String, String> getASSIGNMENTS() {
        return ASSIGNMENTS;
    }
}
