package entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Meeting {

    private Long id;
    private String title;
    private String location;
    private LocalDateTime time;

    public Meeting(Long id, String title, String location, LocalDateTime time) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.time = time;
    }

    public Meeting() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
