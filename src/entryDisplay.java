import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class entryDisplay extends JFrame {
    private JPanel contentPane;
    private JTextField titleField;
    private JTextArea entryArea1;
    private JScrollBar scrollBar1;
    private Entry entry;

    public entryDisplay(Entry entry){
        this.entry = entry;
        initialize();
        setTitle("Entry Display");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setVisible(true);

        // Saves Entry before closing the display

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                closeEntry();
                dispose();
            }
        });
    }

    private void initialize(){
        this.setContentPane(contentPane);
        titleField.setText(this.entry.getTitle());
        entryArea1.setText(entry.getBody());
    }


    private void closeEntry(){
        entry.setTitle(titleField.getText());
        entry.setBody(entryArea1.getText());
        entry.saveEntry();
    }

}
