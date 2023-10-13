package registration;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DropCourses extends JFrame {

private JPanel contentPane;
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	private JTextField textFname;
	private JTextField textLname;
	private JTextField textEmail;
	private JTextField textContact;
	private JTextField textId;
	private JTextField textGender;
	private JTextField textCourse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DropCourses frame = new DropCourses();
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
	public DropCourses() {
		
		conn = Database.provideConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 10, 833, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudName = new JLabel("Search for your details and drop from the course ");
		lblStudName.setForeground(new Color(255, 255, 0));
		lblStudName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblStudName.setBounds(102, 21, 556, 35);
		contentPane.add(lblStudName);
		
		JLabel lblName = new JLabel("Student Name");
		lblName.setForeground(new Color(255, 250, 205));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(48, 169, 147, 22);
		contentPane.add(lblName);
		
		textFname = new JTextField();
		textFname.setForeground(new Color(0, 0, 139));
		textFname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFname.setColumns(10);
		textFname.setBounds(264, 167, 216, 35);
		contentPane.add(textFname);
		
		textLname = new JTextField();
		textLname.setForeground(new Color(0, 0, 139));
		textLname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textLname.setColumns(10);
		textLname.setBounds(515, 167, 216, 35);
		contentPane.add(textLname);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(255, 250, 205));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(48, 249, 84, 22);
		contentPane.add(lblGender);
		
		JLabel lblEmail = new JLabel("Student E - mail");
		lblEmail.setForeground(new Color(255, 250, 205));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(48, 324, 147, 22);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setForeground(new Color(0, 0, 139));
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(264, 322, 216, 35);
		contentPane.add(textEmail);
		
		JLabel lblContact = new JLabel("Contact Number");
		lblContact.setForeground(new Color(255, 250, 205));
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContact.setBounds(48, 400, 147, 22);
		contentPane.add(lblContact);
		
		textContact = new JTextField();
		textContact.setForeground(new Color(0, 0, 139));
		textContact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textContact.setColumns(10);
		textContact.setBounds(264, 398, 216, 35);
		contentPane.add(textContact);
		
		JLabel lblCourse = new JLabel("Courses");
		lblCourse.setForeground(new Color(255, 250, 205));
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCourse.setBounds(48, 477, 98, 22);
		contentPane.add(lblCourse);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(0, 0, 0));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					
					int stdId = Integer.parseInt(textId.getText());
					
					String sql = "select * from student_data where Stud_Id = '"+stdId+"' ";
					
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						textFname.setText(rs.getString("First_Name"));
						textLname.setText(rs.getString("Last_Name"));
						textGender.setText(rs.getString("Gender"));
						textEmail.setText(rs.getString("Email"));
						textContact.setText(rs.getString("Contact"));
						textCourse.setText(rs.getString("Course"));
					}else {
						JOptionPane.showMessageDialog(null, "Record Not Found");
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnSearch.setBounds(490, 99, 124, 29);
		contentPane.add(btnSearch);
		
		textId = new JTextField();
		textId.setForeground(new Color(0, 0, 0));
		textId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textId.setColumns(10);
		textId.setBounds(264, 96, 216, 35);
		contentPane.add(textId);
		
		JLabel lblId = new JLabel("Id");
		lblId.setForeground(new Color(255, 250, 205));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(48, 91, 48, 25);
		contentPane.add(lblId);
		
		JButton btnDrop = new JButton("DROP");
		btnDrop.setBackground(new Color(0, 0, 0));
		btnDrop.setForeground(new Color(255, 255, 255));
		btnDrop.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					stmt = conn.createStatement();
					
					int stdId = Integer.parseInt(textId.getText());
					String course = "Dropped";
					
					int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to drop the course?", "Confirm", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(response == JOptionPane.YES_OPTION) {
						
						String sql = "update student_data set Course = '"+course+"' where Stud_Id= '"+stdId+"' ";
						
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "You have successfully dropped from the course.");
						textCourse.setText(course);
				
					}else if(response == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Dropping Failed!!");
					}
					
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnDrop.setBounds(502, 477, 89, 37);
		contentPane.add(btnDrop);
		
		textGender = new JTextField();
		textGender.setForeground(new Color(0, 0, 139));
		textGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textGender.setColumns(10);
		textGender.setBounds(264, 247, 216, 35);
		contentPane.add(textGender);
		
		textCourse = new JTextField();
		textCourse.setForeground(new Color(0, 0, 139));
		textCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCourse.setColumns(10);
		textCourse.setBounds(264, 475, 216, 35);
		contentPane.add(textCourse);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(312, 547, 89, 37);
		contentPane.add(btnBack);
	}
}
