package model;

public class Shift {
    private String name;
    private String requiredRole;

    public Shift(String name, String requiredRole) {
        this.name = name;
        this.requiredRole = requiredRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequiredRole() {
        return requiredRole;
    }

    public void setRequiredRole(String requiredRole) {
        this.requiredRole = requiredRole;
    }
}
