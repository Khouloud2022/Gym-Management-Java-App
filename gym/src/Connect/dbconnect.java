package Connect;
import java.sql.*;

import javax.swing.JOptionPane;

public class dbconnect {
	final static String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	final static String DB_URL="jdbc:mysql://localhost:3307/sportx?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	final static String USER="root";
	final static String PWD="";
	private static Connection connexion ;	
	 public dbconnect() {
		 try	{		
				Class.forName(JDBC_DRIVER);	
				//System.out.print("driver");
				connexion=DriverManager.getConnection(DB_URL,USER,PWD);	
					 		// JOptionPane.showMessageDialog(null,"Connexion	Ètablie	avec succés","Connexion",JOptionPane.INFORMATION_MESSAGE);	
				}
				catch	(Exception	e)	
				{
					JOptionPane.showMessageDialog(null,e.getMessage(),"Erreur de Connexion",JOptionPane.ERROR_MESSAGE);	
				}
	 }
	 public	static Connection getConnexion()	
	 {	
	       if (connexion==null)	new	dbconnect();	
	 	 return	connexion;	
	 	 }	
}
