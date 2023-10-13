package registration;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 30, 613, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 599, 109);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Course Registration App");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 35));
		lblNewLabel.setBounds(75, 41, 446, 42);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(0, 109, 599, 465);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AllRecords ar = new AllRecords();
				ar.setVisible(true);
			}
		});
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(new Color(32, 178, 170));
		panel_2.setBounds(339, 215, 193, 152);
		panel_1.add(panel_2);
		
		JLabel lblImg4 = new JLabel("");
		lblImg4.setBounds(29, 11, 122, 93);
		panel_2.add(lblImg4);
		ImageIcon icon3 = (new ImageIcon(HomePage.class.getResource("/icon/images/allRec.png")));
		Image img3 = icon3.getImage();
		Image imgScale3 = img3.getScaledInstance(lblImg4.getWidth(), lblImg4.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
		lblImg4.setIcon(scaledIcon3);
		
		JLabel lblViewAllRecords = new JLabel("View All Records");
		lblViewAllRecords.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblViewAllRecords.setBounds(19, 109, 164, 32);
		panel_2.add(lblViewAllRecords);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Courses c = new Courses();
				c.setVisible(true);
			}
		});
		panel_6.setLayout(null);
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBackground(new Color(32, 178, 170));
		panel_6.setBounds(41, 22, 193, 152);
		panel_1.add(panel_6);
		
		JLabel lblCourseDetails = new JLabel("Course Details");
		lblCourseDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCourseDetails.setBounds(20, 109, 146, 32);
		panel_6.add(lblCourseDetails);
		
		JLabel lblImg1 = new JLabel("");
		lblImg1.setBounds(32, 11, 120, 87);
		panel_6.add(lblImg1);
		ImageIcon icon = (new ImageIcon(HomePage.class.getResource("/icon/images/CourseDet.png")));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(lblImg1.getWidth(), lblImg1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		lblImg1.setIcon(scaledIcon);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register r = new Register();
				r.setVisible(true);
			}
		});
		panel_5.setLayout(null);
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBackground(new Color(32, 178, 170));
		panel_5.setBounds(339, 22, 193, 152);
		panel_1.add(panel_5);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegister.setBounds(56, 109, 98, 32);
		panel_5.add(lblRegister);
		
		JLabel lblImg2 = new JLabel("");
		lblImg2.setBounds(36, 11, 122, 99);
		panel_5.add(lblImg2);
		ImageIcon icon1 = (new ImageIcon(HomePage.class.getResource("/icon/images/Reg.png")));
		Image img1 = icon1.getImage();
		Image imgScale1 = img1.getScaledInstance(lblImg2.getWidth(), lblImg2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
		lblImg2.setIcon(scaledIcon1);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DropCourses dr = new DropCourses();
				dr.setVisible(true);
			}
		});
		panel_3.setLayout(null);
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBackground(new Color(32, 178, 170));
		panel_3.setBounds(41, 215, 193, 152);
		panel_1.add(panel_3);
		
		JLabel lblImg3 = new JLabel("");
		lblImg3.setBounds(29, 11, 126, 96);
		panel_3.add(lblImg3);
		ImageIcon icon2 = (new ImageIcon(HomePage.class.getResource("/icon/images/Remove.png")));
		Image img2 = icon2.getImage();
		Image imgScale2 = img2.getScaledInstance(lblImg3.getWidth(), lblImg3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
		lblImg3.setIcon(scaledIcon2);
		
		JLabel lblRemoveCourse = new JLabel("Remove Course");
		lblRemoveCourse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRemoveCourse.setBounds(28, 109, 155, 32);
		panel_3.add(lblRemoveCourse);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(243, 406, 89, 33);
		panel_1.add(btnExit);
	}
}
