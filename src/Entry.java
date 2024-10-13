import org.json.simple.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Entry {
    private String fileName;
    private String title;
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void saveEntry(){
        Path p = Paths.get("data").resolve(this.title);
        File file = p.toFile();

        file.delete();
        try {
            file.createNewFile();
            Files.write(file.toPath(), body.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    
    // FILE NAME SHOULD BE SET TO TITLE NAME
    public static Entry loadEntry(String filename){
        Path p = Paths.get("data").resolve(filename);
        String entryData;
        try {
            entryData = Files.readString(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Entry entry = new Entry();
        entry.setBody(entryData);
        entry.setTitle(filename);


        return entry;
    }
}
