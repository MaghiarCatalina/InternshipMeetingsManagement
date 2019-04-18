package entity;

public class Participants {
    private Long userId;
    private Long meetingId;

    public Participants(Long userId, Long meetingId) {
        this.userId = userId;
        this.meetingId = meetingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(long meetingId) {
        this.meetingId = meetingId;
    }
}
