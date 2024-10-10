import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createAccountWindow extends JFrame {
    private JPasswordField passwordField1;
    private JPanel contentPanel;
    private JTextField usernameField1;
    private JButton createAccountButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    public createAccountWindow() {

        this.setContentPane(contentPanel);
        this.setTitle("Create Account");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 200, 300);
        this.setVisible(true);

        //Allows for login
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
    }

    public void createAccount() {
        String username = usernameField1.getText();
        String password = new String(passwordField1.getPassword());

        User.uploadNewUser(username, password);

        dispose();
    }

}
