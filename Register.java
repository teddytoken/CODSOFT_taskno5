package registration;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textFname;
	private JTextField textLname;
	private JTextField textEmail;
	private JTextField textContact;
	JComboBox comboBox_1, comboBox;
	private JTextField textId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 10, 872, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblForm = new JLabel("Registration Form");
		lblForm.setForeground(new Color(0, 0, 128));
		lblForm.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblForm.setBounds(294, 11, 216, 35);
		contentPane.add(lblForm);
		
		JLabel lblFormtxt = new JLabel("Fill out the form carefully for registration");
		lblFormtxt.setForeground(new Color(0, 0, 128));
		lblFormtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFormtxt.setBounds(252, 46, 333, 22);
		contentPane.add(lblFormtxt);
		
		JLabel lblName = new JLabel("Student Name");
		lblName.setForeground(new Color(47, 79, 79));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(36, 127, 147, 22);
		contentPane.add(lblName);
		
		textFname = new JTextField();
		textFname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFname.setBounds(236, 125, 216, 35);
		contentPane.add(textFname);
		textFname.setColumns(10);
		
		textLname = new JTextField();
		textLname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textLname.setColumns(10);
		textLname.setBounds(508, 125, 216, 35);
		contentPane.add(textLname);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(new Color(47, 79, 79));
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFirstName.setBounds(246, 171, 117, 22);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(47, 79, 79));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLastName.setBounds(518, 171, 98, 22);
		contentPane.add(lblLastName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(47, 79, 79));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(36, 231, 84, 22);
		contentPane.add(lblGender);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "N/A"}));
		comboBox.setBounds(236, 226, 107, 35);
		contentPane.add(comboBox);
		
		JLabel lblStudentE = new JLabel("Student E - mail");
		lblStudentE.setForeground(new Color(47, 79, 79));
		lblStudentE.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudentE.setBounds(36, 304, 161, 22);
		contentPane.add(lblStudentE);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(236, 302, 216, 35);
		contentPane.add(textEmail);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setForeground(new Color(47, 79, 79));
		lblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblContactNumber.setBounds(36, 376, 179, 22);
		contentPane.add(lblContactNumber);
		
		textContact = new JTextField();
		textContact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textContact.setColumns(10);
		textContact.setBounds(236, 371, 216, 35);
		contentPane.add(textContact);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(new Color(255, 240, 245));
		btnSubmit.setForeground(new Color(0, 0, 128));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validation() == true) {
					JOptionPane.showMessageDialog(null, "Validation Successfull");
					
					String result =  insertData();
					if(result.equals("success")) {
						JOptionPane.showMessageDialog(null, "record inserted successfully");
						
					}else {
						JOptionPane.showMessageDialog(null, "record insertion failed");
					}
				}
			}
			public boolean validation() {
				// TODO Auto-generated method stub
				if(textFname.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "please enter your first name");
					return false;
				}
				
				if(textLname.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "please enter your last name");
					return false;
				}
				
				if(textEmail.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "please enter student email id");
					return false;
				}
				
				if(textContact.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "please enter contact number");
					return false;
				}
				return true;
			}
		});
//		btnSubmit.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Details d = new Details();
//				d.setTitle("Welcome");
//				d.setVisible(true);
//				dispose();
//			}
//		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSubmit.setBounds(329, 571, 123, 35);
		contentPane.add(btnSubmit);
		
		JLabel lblTime1 = new JLabel("8 AM - 10 AM");
		lblTime1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime1.setBounds(236, 505, 147, 22);
		contentPane.add(lblTime1);
		
		JLabel lblTime2 = new JLabel("10 AM - 12 PM");
		lblTime2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime2.setBounds(236, 505, 147, 22);
		contentPane.add(lblTime2);
		
		JLabel lblTime3 = new JLabel("2 PM - 4 PM");
		lblTime3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime3.setBounds(236, 505, 147, 22);
		contentPane.add(lblTime3);
		
		JLabel lblTime4 = new JLabel("4 PM - 6 PM");
		lblTime4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime4.setBounds(236, 505, 147, 22);
		contentPane.add(lblTime4);
		
		JLabel lblCourse = new JLabel("Courses");
		lblCourse.setForeground(new Color(47, 79, 79));
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCourse.setBounds(36, 443, 98, 22);
		contentPane.add(lblCourse);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_1.getSelectedIndex() == 0) {
					lblTime1.setVisible(true);
					lblTime2.setVisible(false);
					lblTime3.setVisible(false);
					lblTime4.setVisible(false);
				}
				if(comboBox_1.getSelectedIndex() == 1) {
					lblTime1.setVisible(false);
					lblTime2.setVisible(true);
					lblTime3.setVisible(false);
					lblTime4.setVisible(false);
				}
				if(comboBox_1.getSelectedIndex() == 2) {
					lblTime1.setVisible(false);
					lblTime2.setVisible(false);
					lblTime3.setVisible(true);
					lblTime4.setVisible(false);
				}
				if(comboBox_1.getSelectedIndex() == 3) {
					lblTime1.setVisible(false);
					lblTime2.setVisible(false);
					lblTime3.setVisible(false);
					lblTime4.setVisible(true);
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Python Programming", "Java Programming", "C++ Programming", "Data Structures"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBounds(237, 430, 215, 35);
		contentPane.add(comboBox_1);
		
		JLabel lblSchedule = new JLabel("Schedule");
		lblSchedule.setForeground(new Color(47, 79, 79));
		lblSchedule.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSchedule.setBounds(36, 505, 147, 22);
		contentPane.add(lblSchedule);
		
		JLabel lblId = new JLabel("Id : ");
		lblId.setForeground(new Color(47, 79, 79));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblId.setBounds(703, 18, 42, 22);
		contentPane.add(lblId);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(755, 16, 34, 35);
		contentPane.add(textId);
		int idNo = getId();
		textId.setText(Integer.toString(idNo));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnExit.setForeground(new Color(0, 0, 128));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBackground(new Color(255, 240, 245));
		btnExit.setBounds(570, 571, 123, 35);
		contentPane.add(btnExit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(new Color(0, 0, 128));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(255, 240, 245));
		btnBack.setBounds(75, 571, 123, 35);
		contentPane.add(btnBack);
	}
	
	public int getId() {
		// TODO Auto-generated method stub
		int id = 0;
		try {
			Connection con = Database.provideConnection();
			PreparedStatement pst = con.prepareStatement("select max(Stud_Id) from student_data");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next() == true) {
				id = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
//		return Integer.toString(receiptNo);
		return id + 1;
	}
	
	public String insertData() {
		String status = "";
		
		int id = Integer.parseInt(textId.getText());
		String fname = textFname.getText();
		String lname = textLname.getText();
		String gender = comboBox.getSelectedItem().toString();
		String email = textEmail.getText();
		long contact = Long.parseLong(textContact.getText());
		String course = comboBox_1.getSelectedItem().toString();
		
		try {
			Connection con = Database.provideConnection();
			PreparedStatement pst = con.prepareStatement("insert into student_data value (?,?,?,?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, fname);
			pst.setString(3, lname);
			pst.setString(4, gender);
			pst.setString(5, email);
			pst.setLong(6, contact);
			pst.setString(7, course);
			
			int rowCount = pst.executeUpdate();
			if(rowCount == 1) {
				status = "success";
			}else {
				status = "failed";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}