import javax.swing.*;

public class GUI {
    static JFrame frame;

    public static void start(){


    }

    public static void displayEntryList(){

    }

    public static void displayDefaultWindow(){
        frame = new defaultWindow();
    }

    public static void displayCreateAccountWindow(){
        frame = new createAccountWindow();
    }

    public static void displayEntry(Entry e){
        frame = new entryDisplay(e);
    }
}
