package View;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import Connect.dbconnect;
import Connect.instroctor;
import Connect.member;
import controller.Instroctor;
import controller.Member;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;
public class home extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField contact;
	private JTextField adress;
	private JTextField email;
	private JTable table;
	Connection conn=null;
	PreparedStatement prepared = null;
	ResultSet rs=null;
	private JTextField textField;
	DefaultTableModel model;
	private JTextField id;
	private JTextField txtname;
	private JTextField txtadress;
	private JTextField txtcontact;
	private JTextField txtemail;
    java.util.Date Date;
    java.sql.Date sqlDate;
    java.util.Date Date1;
    java.sql.Date sqlDate1;
    java.util.Date Date2;
    java.sql.Date sqlDate2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setTitle("Home Page");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21658\\OneDrive - Ministere de l'Enseignement Superieur et de la Recherche Scientifique\\Bureau\\javaProject\\kissclipart-bodybuilding-icon-clipart-computer-icons-fitness-c-f6b571b0ded1a9e5.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1318, 844);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1263, 210);
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Sportx");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 84));
		lblNewLabel.setForeground(new Color(148, 0, 211));
		lblNewLabel.setBounds(81, 46, 1026, 112);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Managment System");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 36));
		lblNewLabel_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(638, 138, 391, 42);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\21658\\Downloads\\download.png"));
		lblNewLabel_2.setBounds(1039, 0, 224, 225);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		    	   int a = JOptionPane.showConfirmDialog(btnNewButton_1, "Are you sure?");
	                // JOptionPane.setRootFrame(null);
	                if (a == JOptionPane.YES_OPTION) {
	                    dispose();
	                    Login l= new Login();
	                    l.setTitle("Login");
	                    l.setVisible(true);
	                }
	                dispose();
	                Login l= new Login();

	                l.setTitle("Login");
	                l.setVisible(true);

	            
			
	}});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(917, 10, 112, 37);
		panel.add(btnNewButton_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(10, 243, 1263, 552);
		tabbedPane.setBackground(new Color(230, 230, 250));
		tabbedPane.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		tabbedPane.setForeground(new Color(186, 85, 211));
		contentPane.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Registration", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Member Registration");
		lblNewLabel_5.setBounds(396, 25, 322, 37);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_5.setForeground(new Color(148, 0, 211));
		panel_2.add(lblNewLabel_5);
		
		JLabel MemberName = new JLabel("Full Name");
		MemberName.setFont(new Font("Tahoma", Font.BOLD, 25));
		MemberName.setForeground(new Color(147, 112, 219));
		MemberName.setBounds(71, 130, 191, 44);
		panel_2.add(MemberName);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setForeground(new Color(147, 112, 219));
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdress.setBounds(71, 184, 191, 44);
		panel_2.add(lblAdress);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setForeground(new Color(147, 112, 219));
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblContact.setBounds(71, 238, 191, 44);
		panel_2.add(lblContact);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(147, 112, 219));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEmail.setBounds(71, 289, 191, 44);
		panel_2.add(lblEmail);
		
		JLabel lblAge = new JLabel("Birth Date");
		lblAge.setForeground(new Color(147, 112, 219));
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAge.setBounds(71, 343, 191, 44);
		panel_2.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(147, 112, 219));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblGender.setBounds(71, 397, 191, 44);
		panel_2.add(lblGender);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "female", "Male"}));
		comboBox.setBounds(227, 397, 185, 37);
		panel_2.add(comboBox);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtname.setBounds(227, 130, 272, 38);
		panel_2.add(txtname);
		txtname.setColumns(10);
		
		txtadress = new JTextField();
		txtadress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtadress.setColumns(10);
		txtadress.setBounds(227, 190, 272, 38);
		panel_2.add(txtadress);
		
		txtcontact = new JTextField();
		txtcontact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtcontact.setColumns(10);
		txtcontact.setBounds(227, 238, 272, 38);
		panel_2.add(txtcontact);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtemail.setColumns(10);
		txtemail.setBounds(227, 295, 272, 38);
		panel_2.add(txtemail);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(227, 343, 272, 40);
		panel_2.add(dateChooser);
		
		JLabel lblJoiningDate = new JLabel("Joining Date");
		lblJoiningDate.setForeground(new Color(147, 112, 219));
		lblJoiningDate.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblJoiningDate.setBounds(571, 130, 191, 44);
		panel_2.add(lblJoiningDate);
		
		JLabel lblMembershipType = new JLabel("MemberShip Type");
		lblMembershipType.setForeground(new Color(147, 112, 219));
		lblMembershipType.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMembershipType.setBounds(571, 184, 243, 44);
		panel_2.add(lblMembershipType);
		
		JLabel lblMembershipEndDate = new JLabel("MemberShip end ");
		lblMembershipEndDate.setForeground(new Color(147, 112, 219));
		lblMembershipEndDate.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMembershipEndDate.setBounds(571, 238, 266, 44);
		panel_2.add(lblMembershipEndDate);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(750, 130, 272, 40);
		panel_2.add(dateChooser_1);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(808, 242, 272, 40);
		panel_2.add(dateChooser_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Choose a type", "Pay as you Go", "Open Memberships", "Term Memberships", "Class Packages"}));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		comboBox_1.setBounds(837, 190, 243, 37);
		panel_2.add(comboBox_1);
		
		JLabel lblPayInAdvance = new JLabel("*Pay in Advance (Optional):");
		lblPayInAdvance.setForeground(new Color(147, 112, 219));
		lblPayInAdvance.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPayInAdvance.setBounds(571, 289, 431, 44);
		panel_2.add(lblPayInAdvance);
		
		JButton add_1 = new JButton("Add");
		add_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=null;
				String n=txtname.getText();
				String c=txtadress.getText();
				String a=txtcontact.getText();
				String E=txtemail.getText();
				Date=dateChooser.getDate();
				sqlDate= new java.sql.Date(Date.getTime());
				String g=comboBox.getName();
				Date1=dateChooser_1.getDate();
				sqlDate1= new java.sql.Date(Date1.getTime());
				String TM=comboBox_1.getName();
				Date2=dateChooser_2.getDate();
				sqlDate2= new java.sql.Date(Date2.getTime());
				int membership;
				int gender;
				if(TM=="Pay as you Go") {membership=1;}
				else if(TM=="Open Memberships") {membership=2;}
				else if(TM=="Term Memberships") {membership=3;}
				else {membership=4;}
				if(g=="female") {gender=1;}
				else {gender=0;}
				try{
					if(txtname.getText().equals("")||txtcontact.getText().equals("")||txtadress.getText().equals("")||txtemail.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please fill the Forum");
				}else {
				Member mem=new Member(id,n,c,a,E,sqlDate,gender,sqlDate1,sqlDate2,membership);
				member m=new member();
				m.addMember(mem);
				
				txtname.setText("");
				txtcontact.setText("");
				txtadress.setText("");
				txtemail.setText("");
				
				}
					}catch(Exception e1) {
						e1.printStackTrace();
			}
		}
				
			}
		);
		add_1.setBounds(458, 496, 97, 30);
		panel_2.add(add_1);
		
		JButton add_1_1 = new JButton("Clear");
		add_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtname.setText("");
				txtadress.setText(" ");
				txtcontact.setText(" ");
				txtemail.setText(" ");
				
			}
		});
		add_1_1.setBounds(333, 496, 97, 30);
		panel_2.add(add_1_1);
		
		JButton add_1_1_1 = new JButton("Show List");
		add_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               // dispose();
				MemberList mem= new MemberList();
                mem.setTitle("List");
                mem.setVisible(true);
			}
		});
		add_1_1_1.setBounds(995, 25, 97, 30);
		panel_2.add(add_1_1_1);
		
		JButton add_1_1_2 = new JButton("");
		add_1_1_2.setIcon(new ImageIcon("C:\\Users\\21658\\OneDrive - Ministere de l'Enseignement Superieur et de la Recherche Scientifique\\Bureau\\javaProject\\logo_cbvisa.jpg"));
		add_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				Payment visa= new Payment();
				visa.setTitle("Visa Card");
				visa.setVisible(true);
			}
		});
		add_1_1_2.setBounds(915, 363, 191, 111);
		panel_2.add(add_1_1_2);
		
		JButton add_1_1_2_1 = new JButton("");
		add_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				Payment master= new Payment();
				master.setTitle("Master Card");
				master.setVisible(true);
			}
		});
		add_1_1_2_1.setIcon(new ImageIcon("C:\\Users\\21658\\OneDrive - Ministere de l'Enseignement Superieur et de la Recherche Scientifique\\Bureau\\javaProject\\logo_cbMaster.jpg"));
		add_1_1_2_1.setBounds(645, 363, 191, 122);
		panel_2.add(add_1_1_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Instroctor", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Add Instroctor");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 29));
		lblNewLabel_3.setForeground(new Color(148, 0, 211));
		lblNewLabel_3.setBounds(108, 33, 241, 50);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Full Name");
		lblNewLabel_4.setForeground(new Color(147, 112, 219));
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel_4.setBounds(29, 121, 80, 50);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Contact");
		lblNewLabel_4_1.setForeground(new Color(147, 112, 219));
		lblNewLabel_4_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(29, 174, 80, 50);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Adress");
		lblNewLabel_4_2.setForeground(new Color(147, 112, 219));
		lblNewLabel_4_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel_4_2.setBounds(29, 218, 80, 50);
		panel_1.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Email");
		lblNewLabel_4_3.setForeground(new Color(147, 112, 219));
		lblNewLabel_4_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel_4_3.setBounds(29, 268, 80, 50);
		panel_1.add(lblNewLabel_4_3);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 23));
		name.setBounds(119, 133, 270, 25);
		panel_1.add(name);
		name.setColumns(10);
		
		contact = new JTextField();
		contact.setFont(new Font("Tahoma", Font.PLAIN, 23));
		contact.setColumns(10);
		contact.setBounds(119, 183, 270, 25);
		panel_1.add(contact);
		
		adress = new JTextField();
		adress.setFont(new Font("Tahoma", Font.PLAIN, 23));
		adress.setColumns(10);
		adress.setBounds(119, 236, 270, 25);
		panel_1.add(adress);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 23));
		email.setColumns(10);
		email.setBounds(119, 286, 270, 32);
		panel_1.add(email);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText(" ");
				contact.setText(" ");
				adress.setText(" ");
				email.setText(" ");
			}
			});
		btnNewButton.setBounds(119, 349, 85, 21);
		panel_1.add(btnNewButton);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=null;
				String n=name.getText();
				String c=contact.getText();
				String a=adress.getText();
				String E=email.getText();
				//Connection conn=dbconnect.getConnexion(); 
				try{
					if(name.getText().equals("")||contact.getText().equals("")||adress.getText().equals("")||email.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please fill the Forum");
				}else {
				Instroctor inst=new Instroctor(id,n,c,a,E);
				instroctor i=new instroctor();
				i.addInstroctor(inst);
				/*String sql="INSERT INTO instructor(instructor_name, contact, adress, email) VALUES (?,?,?,?);";
				
				prepared=conn.prepareStatement(sql);
				prepared.setString(1,n);
				prepared.setString(2,c);
				prepared.setString(3,a);
				prepared.setString(4,E);
				prepared.executeUpdate();
			    JOptionPane.showMessageDialog(null,"succed");*/
			    UpdateTable();	
				name.setText("");
				contact.setText("");
				adress.setText("");
				email.setText("");
				
				}
					}catch(Exception e1) {
					//JOptionPane.showMessageDialog(null, "failed");
						e1.printStackTrace();
			}
		}
				
					
				
			
		});
		add.setBounds(214, 349, 85, 21);
		panel_1.add(add);
		//model=new DefaultTableModel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = table.getSelectedRow();
				String Id = table.getModel().getValueAt(ligne, 0).toString();
				String Name = table.getModel().getValueAt(ligne, 1).toString();
				String Contact = table.getModel().getValueAt(ligne, 2).toString();
				String Adress= table.getModel().getValueAt(ligne, 3).toString();
				String Email = table.getModel().getValueAt(ligne, 4).toString();
				
				
				id.setText(Id);
				name.setText(Name);
				contact.setText(Contact);
				adress.setText(Adress);
				email.setText(Email);
				
			}
		});
		scrollPane.setBounds(415, 78, 700, 432);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Full Name", "Contact", "Adress", "Email"
			}
		));
		scrollPane.setViewportView(table);
		
	
		table.setBackground(new Color(230, 230, 250));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Connection conn=dbconnect.getConnexion();
				String i=id.getText();
				String n=name.getText();
				String c=contact.getText();
				String a=adress.getText();
				String E=email.getText();
				//String sql = "DELETE FROM instructor WHERE instructor_id='"+i+"'; ";
				try {
					/*prepared = (PreparedStatement) conn.prepareStatement(sql);
					prepared.execute();
					
					JOptionPane.showMessageDialog(null, "Instroctor Deleted");*/
					Instroctor inst=new Instroctor(i,n,c,a,E);
					instroctor in=new instroctor();
					in.deleteInstroctor(inst);
					id.setText("");
					name.setText("");
				    contact.setText("");
					adress.setText("");
					email.setText("");
					
					
					UpdateTable();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(119, 396, 85, 21);
		panel_1.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Connection conn=dbconnect.getConnexion(); 
				String i=id.getText();
				String n=name.getText();
				String c=contact.getText();
				String a=adress.getText();
				String E=email.getText();
				try{				
					Instroctor inst=new Instroctor(i,n,c,a,E);
					instroctor in=new instroctor();
					in.UpdateInstroctor(inst);
				/*String sql="UPDATE instructor SET  instructor_name='"+n+"',contact='"+c+"',adress='"+a+"',email='"+E+"' WHERE instructor_id='"+i+"';";
				
				prepared=conn.prepareStatement(sql);
				
				prepared.executeUpdate();
			    JOptionPane.showMessageDialog(null,"updated");*/
			    UpdateTable();	
			    id.setText("");
			    name.setText(" ");
				contact.setText(" ");
				adress.setText(" ");
				email.setText(" ");
					}catch(Exception e1) {
					//JOptionPane.showMessageDialog(null, "failed");
						e1.printStackTrace();
			}
				}
				
			}
		);
		btnUpdate.setBounds(214, 396, 85, 21);
		panel_1.add(btnUpdate);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					UpdateTable();}
			}					
		);
		btnRefresh.setBounds(1030, 20, 85, 21);
		panel_1.add(btnRefresh);
		
		id = new JTextField();
		id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String i=id.getText();
				Connection conn=dbconnect.getConnexion();
				
				try {
					String sql = "SELECT instructor_id, instructor_name, contact, adress, email FROM instructor WHERE instructor_id='"+i+"' ;";
					prepared = (PreparedStatement) conn.prepareStatement(sql);
					PreparedStatement pst=conn.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					id.setText("");
				} catch (Exception e3) {
					
					e3.printStackTrace();
				}
			}
		});
		id.setFont(new Font("Tahoma", Font.PLAIN, 23));
		id.setColumns(10);
		id.setBounds(816, 19, 172, 25);
		panel_1.add(id);
		
		JLabel lblNewLabel_4_4 = new JLabel("ID");
		lblNewLabel_4_4.setForeground(new Color(147, 112, 219));
		lblNewLabel_4_4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel_4_4.setBounds(778, 3, 80, 50);
		panel_1.add(lblNewLabel_4_4);
	}
	public void UpdateTable() {
		Connection conn=dbconnect.getConnexion();
		String sql = "SELECT instructor_id, instructor_name, contact, adress, email FROM instructor;";
		
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
