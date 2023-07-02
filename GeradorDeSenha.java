import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GeradorDeSenha extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JLabel lengthLabel;
    private JSpinner lengthSpinner;
    private JButton generateButton;
    private JTextArea passwordField;

    public GeradorDeSenha() {
        setTitle("Gerador de Senha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        lengthLabel = new JLabel("Comprimento:");
        lengthSpinner = new JSpinner(new SpinnerNumberModel(10, 7, 20, 1));
        generateButton = new JButton("Gerar Senha");
        passwordField = new JTextArea();

        generateButton.addActionListener(this);

        Font font = new Font("Arial", Font.PLAIN, 40);
        lengthLabel.setFont(font);
        lengthSpinner.setFont(font);
        generateButton.setFont(font);
        passwordField.setFont(font);

        Dimension buttonSize = new Dimension(400, 80);
        Dimension textFieldSize = new Dimension(600, 160);

        generateButton.setPreferredSize(buttonSize);
        passwordField.setPreferredSize(textFieldSize);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lengthLabel, gbc);

        gbc.gridx = 1;
        add(lengthSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(generateButton, gbc);

        gbc.gridy = 2;
        add(passwordField, gbc);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            int length = (int) lengthSpinner.getValue();
            String password = generatePassword(length);
            passwordField.setText(password);
        }
    }

    private String generatePassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GeradorDeSenha().setVisible(true);
            }
        });
    }
}
