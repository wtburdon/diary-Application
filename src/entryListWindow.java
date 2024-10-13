import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class entryListWindow extends JFrame {


    private JPanel contentPane;
    private JList entryList;
    private JLabel userLabel;
    private JButton openButton;
    private DefaultListModel listModel;
    private User user;

    public entryListWindow(User user) {
        this.user = user;
        initialize();

        this.setTitle("Entry List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(contentPane);
        this.setBounds(100, 100, 450, 300);

        this.setVisible(true);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(entryList.getSelectedValue() != null){
                    String title = entryList.getSelectedValue().toString();
                    Entry entry = new Entry();
                    entry.setTitle(title);
                    entry.setBody("HELLLO MY NAME IS YADADADA");
                    entry.saveEntry();
                    //Entry entrySelected = user.getEntry(title);
                    //entrySelected.saveEntry();
                    //GUI.displayEntry(entrySelected);
                    GUI.displayEntry(entry);
                }
            }
        });
    }

    private void initialize(){
        entryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listModel = (DefaultListModel) entryList.getModel();
        listModel.addAll(user.getEntries());
        //entryList.setModel(listModel);
    }
}
