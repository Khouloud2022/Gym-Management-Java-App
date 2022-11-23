package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Connect.dbconnect;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MemberList extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	Connection conn=null;
	PreparedStatement prepared = null;
	ResultSet rs=null;
	private JButton btnRefresh;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberList frame = new MemberList();
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
	public MemberList() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21658\\OneDrive - Ministere de l'Enseignement Superieur et de la Recherche Scientifique\\Bureau\\javaProject\\kissclipart-bodybuilding-icon-clipart-computer-icons-fitness-c-f6b571b0ded1a9e5.png"));
		setTitle("Members List");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1092, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model); 
			    table.setRowSorter(tr);
			    tr.setRowFilter(RowFilter.regexFilter(textField.getText().trim()));
			}
		});
		textField.setBounds(49, 52, 362, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 107, 982, 547);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Adress", "Contact", "Email", "Birth Date", "\tgender", "Joining date", "Membership Type", "End of membership date"
			}
		));
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnRefresh.setBounds(922, 56, 109, 21);
		contentPane.add(btnRefresh);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home l= new home();
                l.setTitle("home");
                l.setVisible(true);
			}
		});
		btnExit.setBounds(803, 56, 109, 21);
		contentPane.add(btnExit);
	}
	public void UpdateTable() {
		Connection conn=dbconnect.getConnexion();
		String sql = "SELECT id, name, adress, contact, email, Birth_Date, gender, joining_date, end_of_membership_date, id_membership FROM membre;";
		
		try {
			prepared = (PreparedStatement) conn.prepareStatement(sql);
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
