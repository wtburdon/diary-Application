import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        if(usernameField1.getText().equals("admin") && passwordField1.getText().equals("admin")){
            System.out.println("Login Successful");
        }
    }

}
