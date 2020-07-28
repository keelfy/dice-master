package keelfy.dice_master.model;

import lombok.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.persistence.*;

/**
 * @author keelfy
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "time"})
public class Visit {

    private static final DateTimeZone DATE_TIME_ZONE = DateTimeZone.forID("Europe/Moscow");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm:ss dd/MM/yyyy");

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private DateTime time;

    /**
     * @return Visiting time with MSK time zone and correctly formatted into string.
     * */
    public String getFormattedTime() {
        return time.withZone(DATE_TIME_ZONE).toString(DATE_TIME_FORMATTER);
    }

}
