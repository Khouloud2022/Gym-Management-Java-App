package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connect.dbconnect;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class voiture extends JFrame {
	Connection conn=null;
	PreparedStatement prepared = null;
	ResultSet rs=null;

	private JPanel contentPane;
	private JTable table;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					voiture frame = new voiture();
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
	public voiture() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = table.getSelectedRow();
				String Id = table.getModel().getValueAt(ligne, 0).toString();
				id.setText(Id);
			}
		});
		scrollPane.setBounds(87, 63, 723, 441);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("supprimer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn=dbconnect.getConnexion();
				String i=id.getText();
				
				String sql = "DELETE FROM voiture WHERE idVoiture='"+i+"'; ";
				try {
					prepared = (PreparedStatement) conn.prepareStatement(sql);
					prepared.execute();
					
					JOptionPane.showMessageDialog(null, "Deleted");
                    UpdateTable();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(737, 519, 104, 21);
		contentPane.add(btnNewButton);
		
		JButton btnReftesh = new JButton("reload");
		btnReftesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnReftesh.setBounds(737, 10, 104, 21);
		contentPane.add(btnReftesh);
		
		id = new JTextField();
		id.setBounds(631, 520, 96, 19);
		contentPane.add(id);
		id.setColumns(10);
	}
	public void UpdateTable() {
		Connection conn=dbconnect.getConnexion();
		String sql = "SELECT idVoiture, marque, couleur, prix FROM voiture;";
		
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
