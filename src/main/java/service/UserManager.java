package service;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static List<User> userList = new ArrayList<>();

    public static void setUp(){
        userList.add(new User(1111L,"John","Doe"));
        userList.add(new User(2222L,"Jane","White"));
        userList.add(new User(333L,"Jack","Black"));
        userList.add(new User(444L,"Ann","Green"));
        userList.add(new User(555L,"Susan","Blue"));
        userList.add(new User(6766L,"Arya","Stark"));
    }

    static {
        setUp();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public static List<User> getUserList() {
        return userList;
    }
}
