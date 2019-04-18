package service;

import entity.Participants;

import java.util.ArrayList;
import java.util.List;

public class ParticipantsManager {

    private static List<Participants> participantsList= new ArrayList<>();

    public static void setUp() {
        participantsList.add(new Participants(1111L,1234L));
        participantsList.add(new Participants(2222L,1234L));
        participantsList.add(new Participants(333L,1234L));
        participantsList.add(new Participants(1111L,9876L));
        participantsList.add(new Participants(6766L,9876L));
    }

    static {
        setUp();
    }

    public void addParticipant(Participants participants){participantsList.add(participants);}

    public static List<Participants> getParticipantsList(){return participantsList;}
}
