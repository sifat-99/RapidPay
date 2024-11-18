package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends JFrame {

    private JTextField nameField, emailField, passwordField, confirmPasswordField;
    private JCheckBox termsAndConditions;
    private JButton registerButton;
    private JLabel errorMessage;

    public Registration() {
        setTitle("RapidPay Registration");
        setSize(800, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getSize().width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getSize().height / 2);

        // Custom panel with gradient background
        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color color1 = new Color(135, 206, 250); // Light Sky Blue
                Color color2 = new Color(70, 130, 180); // Steel Blue
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };

        contentPanel.setLayout(null);
        setContentPane(contentPanel);

        // Create labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("serif", Font.BOLD, 20));
        nameLabel.setBounds(180, 10, 100, 30);
        contentPanel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(260, 10, 400, 30);
        contentPanel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("serif", Font.BOLD, 20));
        emailLabel.setBounds(180, 50, 100, 30);
        contentPanel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(260, 50, 400, 30);
        contentPanel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("serif", Font.BOLD, 20));
        passwordLabel.setBounds(150, 90, 100, 30);
        contentPanel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(260, 90, 400, 30);
        contentPanel.add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(new Font("serif", Font.BOLD, 20));
        confirmPasswordLabel.setBounds(70, 130, 180, 30); // Adjust width for longer text
        contentPanel.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setBounds(260, 130, 400, 30);
        contentPanel.add(confirmPasswordField);

        // Add terms and conditions checkbox
        termsAndConditions = new JCheckBox("I agree to the Terms and Conditions");
        termsAndConditions.setBounds(150, 170, 400, 20); // Adjust width for longer text
        contentPanel.add(termsAndConditions);

        // Add error message label
        errorMessage = new JLabel("");
        errorMessage.setForeground(Color.RED);
        errorMessage.setBounds(150, 200, 400, 20); // Adjust width for longer text
        contentPanel.add(errorMessage);

        // Create register button
        registerButton = new JButton("Register");
        registerButton.setBounds(300, 240, 200, 50); // Centered button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate input
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(String.valueOf(passwordField.getCursor()));
                String confirmPassword = new String(String.valueOf(confirmPasswordField.getCursor()));

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    errorMessage.setText("Please fill in all fields.");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    errorMessage.setText("Passwords do not match.");
                    return;
                }

                if (!termsAndConditions.isSelected()) {
                    errorMessage.setText("Please agree to the terms and conditions.");
                    return;
                }

                // Implement registration logic here (e.g., send email verification, store data in database)
                // This is a simplified example, replace with actual implementation
                System.out.println("Registration successful for: " + name + " (" + email + ")");

                // Clear fields and show success message
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                termsAndConditions.setSelected(false);
                errorMessage.setText("Registration successful!");
            }
        });
        contentPanel.add(registerButton);

        JButton LoginButton = new JButton("Login");
        LoginButton.setBounds(300, 300, 200, 50); // Centered button
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                // Open login window
                new Login().setVisible(true);
                dispose(); // Close registration window
            }
        });

        contentPanel.add(LoginButton);

        setVisible(true);
    }
}