import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetExample {

    enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {

//        EnumSet<Days> days = EnumSet.allOf(Days.class);
//
//        System.out.println("EnumSet: " + days);
//
//        EnumSet<Days> emptyDays = EnumSet.noneOf(Days.class);
//
//        System.out.println("Empty EnumSet: " + emptyDays);
//
//        EnumSet<Days> rangeDays = EnumSet.range(Days.TUESDAY, Days.FRIDAY);
//
//        System.out.println("EnumSet: " + rangeDays);

        EnumSet<Days> days1 = EnumSet.of(Days.SUNDAY);
        System.out.println("EnumSet1: " + days1);

        EnumSet<Days> days2 = EnumSet.of(Days.SATURDAY, Days.SUNDAY);
        System.out.println("EnumSet2: " + days2);

        // Using add method
        days1.add(Days.MONDAY);
        System.out.println("EnumSet Using add(): " + days1);

        // Using addAll() method
        days2.addAll(days1);
        System.out.println("EnumSet Using addAll(): " + days2);
//
//        Iterator<Days> iterate = days.iterator();
//
//        System.out.print("EnumSet: ");
//        while (iterate.hasNext()) {
//            System.out.print(iterate.next());
//            System.out.print(", ");
//        }
//    }
//        // Using remove()
//        boolean value1 = days.remove(Days.FRIDAY);
//        System.out.println("Is FRIDAY removed? " + value1);
//
//        // Using removeAll()
//        boolean value2 = days.removeAll(days);
//        System.out.println("Are all elements removed? " + value2);
//        System.out.println(days);
    }
}
