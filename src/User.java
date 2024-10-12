import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class User {
    private String password;
    private String hashedPassword;
    private String username;
    private ArrayList<String> entries = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        //return BCrypt; //(password, this.hashedPassword);
        return this.password.equals(password);
    }

    //FOR FUNCTIONALITY TEST ONLY
    //WILL BE REMOVED AFTER IMPLEMENTING HASHING
    public String getPassword() {
        return password;
    }

    // TO BE REMOVED
    public void setPassword(String password) {
        this.password = password;
    }

    public void setEntries(ArrayList<String> entries) {
        this.entries = entries;
    }

    public Entry getEntry(int index) {
        String entryFile;
        Entry entry;
        try{
            entryFile = entries.get(index-1);
            entry = Entry.loadEntry(entryFile);
        } catch(Exception e){
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

    public Path getDefualtPath(String fileName){
        String home = "data";

        return Paths.get(home).resolve(fileName);
    }

    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("username", username);
        jsonObject.put("password", password);
        jsonObject.put("entries", entries);

        return jsonObject;
    }

    public User fromJSONObject(JSONObject json){
        String username = (String) json.get("username");
        String password = (String) json.get("password");
        ArrayList<String> entries = (ArrayList<String>) json.get("entries");

        User u = new User(username, password);
        u.setEntries(entries);

        return u;
    }

    public void importData(User u){
        this.username = u.getUsername();
        this.password = u.getPassword();
        this.entries = u.entries;
    }

    public void save(String fileName){
        Path p = getDefualtPath(fileName);
        String jsonText = this.toJSONObject().toJSONString();
        try{
            Files.write(p, jsonText.getBytes(), StandardOpenOption.CREATE);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public void load(String fileName){
        Path p = getDefualtPath(fileName);
        String jsonText = null;

        try{
            jsonText = new String(Files.readAllBytes(p));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JSONParser jsonParser = new JSONParser();

        try{
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonText);
            User u = fromJSONObject(jsonObject);
            this.importData(u);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
