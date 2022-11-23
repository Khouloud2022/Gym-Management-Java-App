package Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import controller.Instroctor;

public class instroctor {
Connection conn=null;
PreparedStatement prepared = null;
ResultSet rs=null;	
    public void addInstroctor(Instroctor i)
    {
    	Connection conn=dbconnect.getConnexion(); 
		
		
		String sql="INSERT INTO instructor(instructor_name, contact, adress, email) VALUES (?,?,?,?);";
		try {
		prepared=conn.prepareStatement(sql);
		prepared.setString(1,i.getName());
		prepared.setString(2,i.getContact());
		prepared.setString(3,i.getAdress());
		prepared.setString(4,i.getEmail());
		prepared.executeUpdate();
	    JOptionPane.showMessageDialog(null,"succed");
	    	
		
     	}catch(Exception e1) {
			//JOptionPane.showMessageDialog(null, "failed");
				e1.printStackTrace();
	
    }
}
    public void deleteInstroctor(Instroctor i) {
    	Connection conn=dbconnect.getConnexion();
    	String sql = "DELETE FROM instructor WHERE instructor_id='"+i.getId()+"'; ";
    	try {
			prepared = (PreparedStatement) conn.prepareStatement(sql);
			prepared.execute();
			
			JOptionPane.showMessageDialog(null, "Instroctor Deleted");
    } catch (Exception e1) {
		
		e1.printStackTrace();
	}
    }
    public void UpdateInstroctor(Instroctor i) {
    	Connection conn=dbconnect.getConnexion();
    	String sql="UPDATE instructor SET  instructor_name='"+i.getName()+"',contact='"+i.getContact()+"',adress='"+i.getAdress()+"',email='"+i.getEmail()+"' WHERE instructor_id='"+i.getId()+"';";
    	try {
    		prepared=conn.prepareStatement(sql);
			
			prepared.executeUpdate();
		    JOptionPane.showMessageDialog(null,"updated");
    } catch (Exception e1) {
		
		e1.printStackTrace();
	}
    }
   
}
