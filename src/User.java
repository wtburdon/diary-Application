import java.util.ArrayList;

public class User {
    private String password;
    private String username;
    private ArrayList<Entry> entries = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean checkUsername(String username) {
        return this.username.equals(username);
    }

    public Entry getEntry(int index) {
        Entry entry;
        try{
            entry = entries.get(index-1);
        }catch(IndexOutOfBoundsException e){
            entry = null;
        }

        return entry;
    }

    public static void uploadNewUser(String username, String password) {

    }

    public static ArrayList<User> getUserList(){
        ArrayList<User> users = new ArrayList<>();

        return users;
    }

}
