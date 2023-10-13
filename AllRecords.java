package registration;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllRecords extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllRecords frame = new AllRecords();
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
	public AllRecords() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		table = new JTable();
//		table.setBounds(20, 73, 856, 238);
//		contentPane.add(table);
		
		JLabel lblRec = new JLabel("All Records");
		lblRec.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblRec.setBounds(379, 24, 135, 25);
		contentPane.add(lblRec);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 892, 270);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBounds(379, 372, 111, 25);
		contentPane.add(btnBack);
		
		showData();
	}
	public void showData() {
		try {
			Connection con = Database.provideConnection();
			Statement st = con.createStatement();
			String query = "select * from student_data";
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for(int i = 0; i < cols; i++) 
				colName[i] = rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			String id, fName, lName, gender, email, contact, course;
			
			while(rs.next()) {
				id = rs.getString(1);
				fName = rs.getString(2);
				lName = rs.getString(3);
				gender = rs.getString(4);
				email = rs.getString(5);
				contact = rs.getString(6);
				course = rs.getString(7);
				String[] row = {id, fName, lName, gender, email, contact, course};
				model.addRow(row);
			}
			st.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
