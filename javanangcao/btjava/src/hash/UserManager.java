package hash;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users = new ArrayList<>();

    public boolean register(String username, String password) {
        for (User u : users) {
            if (u.getName().equals(username)) return false; // trùng tên
        }
        users.add(new User(username, HashUtil.hashPassword(password)));
        return true;
    }

    public boolean login(String username, String password) {
        String hash = HashUtil.hashPassword(password);
        for (User u : users) {
            if (u.getName().equals(username) && u.getPassword().equals(hash)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> newUsers) {
        users = newUsers;
    }
}