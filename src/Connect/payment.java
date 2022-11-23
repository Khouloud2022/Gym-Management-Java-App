package Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import controller.ControlPay;


public class payment {
	Connection conn=null;
	PreparedStatement prepared = null;
	ResultSet rs=null;
	  public void addPayment(ControlPay i)
	    {
	    	Connection conn=dbconnect.getConnexion(); 
			
			
			String sql="INSERT INTO payment( member_id, amount)VALUES (?,?);";
			try {
			prepared=conn.prepareStatement(sql);
			prepared.setString(1,i.getMember());
			prepared.setDouble(2,i.getAmount());
			
			prepared.executeUpdate();
		    JOptionPane.showMessageDialog(null,"succed");
		    	
			
	     	}catch(Exception e1) {
				//JOptionPane.showMessageDialog(null, "failed");
					e1.printStackTrace();
		
	    }

	    }
}
