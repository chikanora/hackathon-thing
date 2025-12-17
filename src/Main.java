import model.Staff;
import model.Schedule;
import model.Shift;
import model.Staff;
import service.ScheduleManager;

import java.util.List;
import java.util.Set;

public class Main
{
    public static void main(String[] args)

    {
        List<Staff> staff = List.of(
                new Staff("D1", "Doctor", Set.of("morning", "evening", "night")),
                new Staff("N1", "Nurse", Set.of("morning", "evening", "night")),
                new Staff("H1", "Helper for both D,N", Set.of("morning", "evening", "night")),
                new Staff("IT1", "IT Service Provider", Set.of("morning", "evening", "night")),
                new Staff("FD1", "Front Desk", Set.of("morning", "evening", "night")),
                new Staff("J1", "Janitor", Set.of("morning", "evening", "night"))
        );

        List<Shift> shifts = List.of(
                new Shift("morning", "Doctor"),
                new Shift("evening", "Doctor"),
                new Shift("night", "Doctor"),
                new Shift("morning", "Nurse"),
                new Shift("evening", "Nurse"),
                new Shift("night", "Nurse"),
                new Shift("morning", "Helper for both D,N"),
                new Shift("evening", "Helper for both D,N"),
                new Shift("night", "Helper for both D,N"),
                new Shift("morning", "IT Service Provider"),
                new Shift("evening", "IT Service Provider"),
                new Shift("night", "IT Service Provider"),
                new Shift("morning", "Front Desk"),
                new Shift("evening", "Front Desk"),
                new Shift("night", "Front Desk"),
                new Shift("morning", "Janitor"),
                new Shift("evening", "Janitor"),
                new Shift("night", "Janitor")
        );

        ScheduleManager manager = new ScheduleManager();

        try {
            Schedule schedule = manager.generate(staff, shifts);
            System.out.println("Generated Schedule:");
            schedule.getASSIGNMENTS().forEach((shiftName, staffId) ->
                    System.out.println(" " + shiftName + "->" + staffId));
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}