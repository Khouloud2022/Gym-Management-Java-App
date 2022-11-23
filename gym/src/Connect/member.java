package Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import controller.Member;

public class member {
	Connection conn=null;
	PreparedStatement prepared = null;
	ResultSet rs=null;
	
	public void addMember(Member i)
    {
    	Connection conn=dbconnect.getConnexion(); 
		
		
		String sql="INSERT INTO membre( name, adress, contact, email, Birth_Date, gender, joining_date, end_of_membership_date, id_membership) VALUES (?,?,?,?,?,?,?,?,?);";
		try {
		prepared=conn.prepareStatement(sql);
		prepared.setString(1,i.getName());
		prepared.setString(2,i.getContact());
		prepared.setString(3,i.getAdress());
		prepared.setString(4,i.getEmail());
		prepared.setDate(5,i.getBirth());
		prepared.setInt(6,i.getGender());
		prepared.setDate(7,i.getJoiningDate());
		prepared.setDate(8,i.getEndMemberShip());
		prepared.setInt(9,i.getMembership());
		prepared.executeUpdate();
	    JOptionPane.showMessageDialog(null,"succed");
	    	
		
     	}catch(Exception e1) {
			//JOptionPane.showMessageDialog(null, "failed");
				e1.printStackTrace();
	
    }
}
    public void deleteMember(Member i) {
    	Connection conn=dbconnect.getConnexion();
    	String sql = "DELETE FROM membre WHERE id='"+i.getId()+"'; ";
    	try {
			prepared = (PreparedStatement) conn.prepareStatement(sql);
			prepared.execute();
			
			JOptionPane.showMessageDialog(null, "Member Deleted");
    } catch (Exception e1) {
		
		e1.printStackTrace();
	}
    }
    public void UpdateMember(Member i) {
    	Connection conn=dbconnect.getConnexion();
    	String sql="UPDATE member SET name='"+i.getName()+"',adress='"+i.getAdress()+"',contact='"+i.getContact()+"',email='"+i.getEmail()+"',Birth_Date='"+i.getBirth()+"', gender='"+i.getGender()+"', joining_date='"+i.getJoiningDate()+"', end_of_membership_date='"+i.getEndMemberShip()+"', id_membership='"+i.getEndMemberShip()+"' WHERE instructor_id='"+i.getId()+"';";
    	try {
    		prepared=conn.prepareStatement(sql);
			
			prepared.executeUpdate();
		    JOptionPane.showMessageDialog(null,"updated");
    } catch (Exception e1) {
		
		e1.printStackTrace();
	}
    }
}
