package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connect.member;
import Connect.payment;
import controller.ControlPay;
import controller.Member;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JSpinner;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 833, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 799, 448);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMembershipType = new JLabel("MemberShip Type");
		lblMembershipType.setBounds(68, 114, 224, 31);
		lblMembershipType.setForeground(new Color(147, 112, 219));
		lblMembershipType.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblMembershipType);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Choose a type", "Pay as you Go", "Open Memberships", "Term Memberships", "Class Packages"}));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		comboBox_1.setBounds(333, 113, 243, 37);
		panel.add(comboBox_1);
		
		JLabel lblWhoManyMonths = new JLabel("Who Many Months");
		lblWhoManyMonths.setForeground(new Color(147, 112, 219));
		lblWhoManyMonths.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblWhoManyMonths.setBounds(68, 160, 255, 44);
		panel.add(lblWhoManyMonths);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinner.setBounds(328, 173, 76, 26);
		panel.add(spinner);
		
		JButton add_1 = new JButton("Pay");
		add_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        String i=null;
	                	String id=textField.getText();
	                	String membership=comboBox_1.getSelectedItem().toString();
	                	int nbre;
						int value =(int) spinner.getValue();
						double amount=0;
						//System.out.println(membership);
						if(membership=="Choose a type")
						{
							JOptionPane.showMessageDialog(null,"Please choose a type");
						}
						else if(membership=="Pay as you Go")
						{
							nbre=1;
							amount=10*value+2;
						}
						else if(membership=="Open Memberships")
						{
							nbre=2;
							amount=7*value+2;
						}
						else if(membership=="Term Memberships")
						{ nbre=3;
						amount=6*value+2;
							
						}
						else {
							nbre=4;
							amount=7*value+1;
						}
						//System.out.println(amount);
	                    
	                
			   int a = JOptionPane.showConfirmDialog(add_1, "The amount is "+amount+"TND Do you want to pay?");
               
               if (a == JOptionPane.YES_OPTION) { 
            	   try {
              ControlPay pay=new ControlPay(i,id,amount);
   				payment p=new payment();
   				p.addPayment(pay);
   			    JOptionPane.showMessageDialog(null,"succesful payment");
   				}
            	   catch(Exception a1) {
            		   a1.printStackTrace();	
   				
            	   }}
			}});
		add_1.setBounds(577, 390, 112, 31);
		panel.add(add_1);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setForeground(new Color(147, 112, 219));
		lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCardNumber.setBounds(68, 235, 255, 44);
		panel.add(lblCardNumber);
		
		JLabel lblSecretNumberdigital = new JLabel("Secret number(8Digital)");
		lblSecretNumberdigital.setForeground(new Color(147, 112, 219));
		lblSecretNumberdigital.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSecretNumberdigital.setBounds(68, 303, 311, 44);
		panel.add(lblSecretNumberdigital);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(318, 235, 323, 44);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(398, 310, 243, 44);
		panel.add(textField_3);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setForeground(new Color(148, 0, 211));
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPayment.setBounds(318, 10, 311, 44);
		panel.add(lblPayment);
		
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(147, 112, 219));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblId.setBounds(68, 64, 51, 44);
		panel.add(lblId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(129, 77, 192, 31);
		panel.add(textField);
		
		JButton add_1_2 = new JButton("Exit");
		add_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int a = JOptionPane.showConfirmDialog(add_1, "Are you sure?");
	                // JOptionPane.setRootFrame(null);
	                if (a == JOptionPane.YES_OPTION) {
				home l= new home();
                l.setTitle("home");
                l.setVisible(true);
	                }
	                dispose();
	                home l= new home();

	                l.setTitle("home");
	                l.setVisible(true);
			}
			
		});
		add_1_2.setBounds(455, 390, 112, 31);
		panel.add(add_1_2);
		
	
	}
}
