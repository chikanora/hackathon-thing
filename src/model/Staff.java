package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Staff
{
    private String id;
    private String role;
    private Set<String> availableShifts;

    public Staff(String id, String role, Set<String> availableShifts)
    {
        this.id = id;
        this.role = role;
        this.availableShifts = new HashSet<>(Objects.requireNonNull(availableShifts));
    }

    public String getId()
    {
        return id;
    }

    public String getRole()
    {
        return role;
    }

    public Set<String> getAvailableShifts()
    {
        return availableShifts;
    }

    public boolean isAvailable(Shift shift)
    {
        // temp placeholder
        return availableShifts.contains(shift.getName());
    }

    public boolean matchesRole(Shift shift)
    {
        // temp placeholder
        return getRole().equals(shift.getRequiredRole());
    }

    public boolean canWork(Shift shift)
    {
        // temp placeholder
        return matchesRole(shift) && isAvailable(shift);
    }
}
