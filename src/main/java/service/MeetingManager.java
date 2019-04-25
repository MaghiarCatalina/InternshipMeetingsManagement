package service;

import connection.DataSource;
import entity.Meeting;

import java.sql.*;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class MeetingManager {
    Connection con = null;

    public void addMeeting(Meeting meeting) {
        String SQL_QUERY = "INSERT INTO meeting(id,title,location,time_date)" + "VALUES(?,?,?,?)";
        PreparedStatement pst = null;
        try {
            con = DataSource.getConnection();
            pst = con.prepareStatement(SQL_QUERY);
            pst.setLong(1, meeting.getId());
            pst.setString(2, meeting.getTitle());
            pst.setString(3, meeting.getLocation());
            pst.setTimestamp(4, Timestamp.from(meeting.getTime().toInstant(ZoneOffset.ofHours(0))));
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeMeeting(Meeting meeting) {
        String SQL_QUERY = "DELETE FROM client WHERE id= ?";
        PreparedStatement pst = null;
        try {
            con = DataSource.getConnection();
            pst = con.prepareStatement(SQL_QUERY);
            pst.setLong(1, meeting.getId());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Meeting> getMeetingList() {
        String SQL_QUERY = "select * from meeting";
        List<Meeting> meetingList = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pst = con.prepareStatement(SQL_QUERY);
            rs = pst.executeQuery();

            meetingList = new ArrayList<>();
            Meeting meeting;
            while (rs.next()) {
                meeting = new Meeting();
                meeting.setId(rs.getLong("id"));
                meeting.setTitle(rs.getString("title"));
                meeting.setLocation(rs.getString("location"));
                meeting.setTime(rs.getTimestamp("time_date").toLocalDateTime());
                meetingList.add(meeting);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return meetingList;
    }
}
