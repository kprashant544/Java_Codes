package com.jframe;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.model.Student;
import com.service.StudentService;
import com.service.StudentServiceImpl;

public class StudentDataTable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDataTable frame = new StudentDataTable();
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
	public StudentDataTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] colNames = { "ID", "FirstName", "LastName", "Contact", "Address", "Gender" };

		table = new JTable();
		table.setBounds(10, 11, 490, 282);
		contentPane.add(table);

		DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);
		table.setModel(tableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(11, 61, 582, 172);
		contentPane.add(scrollPane);

		lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(88, 30, 67, 20);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setBounds(161, 33, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		loadDataInTable();
	}

	public void loadDataInTable() {
		StudentService studentService = new StudentServiceImpl();
		ArrayList<Student> studentList = studentService.getStudentList();

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);

		for (Student student : studentList) {
			tableModel.addRow(new Object[] { student.getId(), student.getFirstName(), student.getLastName(),
					student.getContactNumber(), student.getAddress(), student.getGender() });
		}
	}
}
