import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

class dateTime5 {
    public static void main(String[] args) {

        ZonedDateTime now = ZonedDateTime.now();
        // System.out.println(now);

        Set<String> availableZones = ZoneId.getAvailableZoneIds();
        availableZones.forEach(System.out::println);

    }
}