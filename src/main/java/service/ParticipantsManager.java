package service;

import connection.DataSource;
import entity.Participants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantsManager {

    Connection con = null;

    public void addParticipant(Participants participants) {
        String SQL_QUERY = "INSERT INTO participants(id_user,id_meeting)" + "VALUES(?,?)";
        PreparedStatement pst = null;
        try {
            con = DataSource.getConnection();
            pst = con.prepareStatement(SQL_QUERY);
            pst.setLong(1, participants.getUserId());
            pst.setLong(2,participants.getMeetingId());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteParticipant(Participants participants) {
        String SQL_QUERY = "DELETE FROM participants WHERE id_user= ?";
        PreparedStatement pst = null;
        try {
            con = DataSource.getConnection();
            pst = con.prepareStatement(SQL_QUERY);
            pst.setLong(1, participants.getUserId());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Participants> getParticipantsList() {
        String SQL_QUERY = "select * from participants";
        List<Participants> participantsList = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pst = con.prepareStatement(SQL_QUERY);
            rs = pst.executeQuery();

            participantsList = new ArrayList<>();
            Participants participant;
            while (rs.next()) {
                participant = new Participants();
                participant.setUserId(rs.getLong("id_user"));
                participant.setMeetingId(rs.getLong("id_meeting"));
                participantsList.add(participant);
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
        return participantsList;
    }
}
