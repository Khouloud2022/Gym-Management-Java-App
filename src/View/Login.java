package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import Connect.dbconnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usertxt;
	private JPasswordField pswdtxt;
	Connection conn;
	Statement stm;
	ResultSet re;
	String user;
    String pswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("LogIn");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21658\\OneDrive - Ministere de l'Enseignement Superieur et de la Recherche Scientifique\\Bureau\\Untitled-1.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 758, 615);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\21658\\OneDrive - Ministere de l'Enseignement Superieur et de la Recherche Scientifique\\Bureau\\Untitled-1.png"));
		lblNewLabel.setBounds(351, 10, 427, 250);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SportX");
		lblNewLabel_1.setFont(new Font("ROG Fonts", Font.BOLD, 75));
		lblNewLabel_1.setForeground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(10, 10, 549, 81);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Login ");
		lblNewLabel_2.setFont(new Font("ROG Fonts", Font.BOLD, 70));
		lblNewLabel_2.setForeground(new Color(0, 191, 255));
		lblNewLabel_2.setBounds(143, 87, 315, 81);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("User");
		lblNewLabel_3.setForeground(new Color(148, 0, 211));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(67, 286, 122, 48);
		contentPane.add(lblNewLabel_3);
		
		usertxt = new JTextField();
		usertxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usertxt.setBounds(168, 297, 259, 30);
		contentPane.add(usertxt);
		usertxt.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setForeground(new Color(148, 0, 211));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3_1.setBounds(67, 368, 190, 48);
		contentPane.add(lblNewLabel_3_1);
		
		pswdtxt = new JPasswordField();
		pswdtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pswdtxt.setBounds(201, 377, 293, 30);
		contentPane.add(pswdtxt);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try
				{conn =(Connection)dbconnect.getConnexion();
				
				user=usertxt.getText().toString();
				pswd=pswdtxt.getText().toString();
				
				
		
			String sql="Select * from user where username='"+user+"' && password='"+pswd+"'";
			   
			PreparedStatement ps=conn.prepareStatement(sql);
					
					
					 re=ps.executeQuery(sql);
			    if(re.next())
			    {
			    	
			    	home h= new home();
			    	h.setVisible(true);
			    }else {
			    	JOptionPane.showMessageDialog(null,"Check your user name and passwprd !!!!");
			    }
			}
			catch(Exception a) {
				JOptionPane.showMessageDialog(null, a.getMessage());
			}
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 33));
		btnNewButton.setForeground(new Color(65, 105, 225));
		btnNewButton.setBounds(78, 480, 210, 63);
		contentPane.add(btnNewButton);
	}
}
