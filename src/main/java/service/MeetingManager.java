package service;

import entity.Meeting;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MeetingManager {

    private static List<Meeting> meetingList = new ArrayList<>();

    public static void setUp(){
        meetingList.add(new Meeting(1234L,"Java","Arobs",LocalDateTime.now()));
        meetingList.add(new Meeting(4567L,"ImportantMeeting","Arobs",LocalDateTime.now()));
        meetingList.add(new Meeting(3337L,"Interns","Manaslu",LocalDateTime.now()));
        meetingList.add(new Meeting(9876L,"Interview","Alps",LocalDateTime.now()));
        meetingList.add(new Meeting(1233L,"Project","Caucaz",LocalDateTime.now()));

    }

    static {
       setUp();
    }

    public void addMeeting(Meeting meeting){
        meetingList.add(meeting);
    }

    public static List<Meeting> getMeetingList(){return meetingList;}
}
