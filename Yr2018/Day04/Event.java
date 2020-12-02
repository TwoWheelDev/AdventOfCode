package Yr2018.Day04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Event implements Comparable<Event> {
    private LocalDateTime date;
    private String event;

    public Event(String event) {
        Pattern pattern = Pattern.compile("^\\[(\\d+-\\d+-\\d+ \\d+:\\d+)\\] (.+)$");
        Matcher matcher = pattern.matcher(event);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if (matcher.matches()) {
            try {
                this.date = LocalDateTime.parse(matcher.group(1), dtf);
                this.event = matcher.group(2);
            } catch (DateTimeParseException e) {
                e.printStackTrace();
            }

        }
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public int compareTo(Event arg0) {
        return getDate().compareTo(arg0.getDate());
    }
}
