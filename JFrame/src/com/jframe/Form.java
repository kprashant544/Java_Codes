package com.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.studentform.databaseconnection.DatabaseConnection;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField addressTextField;
	private JTextField contactTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(55, 59, 89, 13);
		contentPane.add(lblNewLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		firstNameTextField.setBounds(154, 60, 112, 22);
		contentPane.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(55, 92, 117, 24);
		contentPane.add(lblNewLabel_1);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(154, 97, 115, 22);
		contentPane.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(55, 191, 81, 19);
		contentPane.add(lblNewLabel_2);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(150, 192, 116, 23);
		contentPane.add(addressTextField);
		addressTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(55, 149, 86, 13);
		contentPane.add(lblNewLabel_3);
		
		JComboBox genderComboBox = new JComboBox();
		genderComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		genderComboBox.setBounds(154, 140, 99, 30);
		contentPane.add(genderComboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Contact");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(55, 250, 77, 13);
		contentPane.add(lblNewLabel_4);
		
		contactTextField = new JTextField();
		contactTextField.setBounds(154, 247, 103, 25);
		contentPane.add(contactTextField);
		contactTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				String address = addressTextField.getText();
				long contact = Long.parseLong(contactTextField.getText());
				String gender = (String) genderComboBox.getSelectedItem();
				
				PreparedStatement ps = null;
				String sql = "Insert into students(first_name,last_name,address,gender,contact)values(?,?,?,?,?)";
				
				try {
					ps = DatabaseConnection.getConnection().prepareStatement(sql);
					ps.setString(1,name);
					ps.setString(2, lastName);
					ps.setString(3,address);
					ps.setString(4, gender);
					ps.setLong(5, contact);
					ps.executeUpdate();
					
				}catch(Exception err) {
					System.out.println(err);
				}
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(157, 304, 95, 33);
		contentPane.add(btnNewButton);
	}
		
	}

