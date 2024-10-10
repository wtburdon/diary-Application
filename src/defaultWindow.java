import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class defaultWindow extends JFrame {
    private JPanel contentPane;
    private JButton loginButton;
    private JPasswordField passwordField1;
    private JTextField usernameField1;
    private JLabel passwordLabel;
    private JLabel usernameLabel;

    public defaultWindow() {

        initialize();

        this.setTitle("Login Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 200, 300);
        this.setVisible(true);

        //Allows for login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAttempt();
            }
        });
    }

    private void initialize(){
        this.setContentPane(contentPane);
    }


    private void loginAttempt(){
        ArrayList<User> existingUsers = User.getUserList();
        String username = usernameField1.getText();
        String password = new String(passwordField1.getPassword());


        for(User u : existingUsers){
            if(u.getUsername().equals(username)){
                if(u.checkPassword(password)){
                    System.out.println("login successful");
                    GUI.displayEntryList();
                    dispose();
                }
            }
        }

    usernameLabel.setText("Username: (Login Failed)");
    }

}
