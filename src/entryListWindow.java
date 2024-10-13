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

    public entryListWindow() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(contentPane);
        this.setBounds(100, 100, 450, 300);

        this.setVisible(true);


        entryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    System.out.println(entryList.getSelectedValue());
                }
            }
        });
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(entryList.getSelectedValue() != null){
                    System.out.println(entryList.getSelectedValue());
                }
            }
        });
    }
}
