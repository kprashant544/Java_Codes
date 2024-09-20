package com.form;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SimpleForm {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("Simple Form");
        frame.setLayout(null);
       
        
        // Create and add the Name label and text field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 30, 100, 30);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(130, 30, 200, 30);
        frame.add(nameField);
        
        // Create and add the Email label and text field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 80, 100, 30);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(130, 80, 200, 30);
        frame.add(emailField);
        
        // Create and add the Phone Number label and text field
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(20, 130, 100, 30);
        frame.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(130, 130, 200, 30);
        frame.add(phoneField);
        
        // Create and add the Address label and text field
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(20, 180, 100, 30);
        frame.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(130, 180, 200, 30);
        frame.add(addressField);
        
        // Create and add the Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 250, 100, 40);
        frame.add(submitButton);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}
