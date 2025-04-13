package hash;

import java.util.ArrayList;

public class mamin {
    private ArrayList<user> users = new ArrayList<>();

    public boolean register(String username, String password) {
        for (user u : users) {
            if (u.getName().equals(username)) return false; // trùng tên
        }
        users.add(new user(username, HashUtil.hashPassword(password)));
        return true;
    }

    public boolean login(String username, String password) {
        String hash = HashUtil.hashPassword(password);
        for (user u : users) {
            if (u.getName().equals(username) && u.getPassword().equals(hash)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<user> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<user> newUsers) {
        users = newUsers;
    }
}
