package controller;

public class ControlPay {
	private String id;
	   private String member;
	   private Double amount;
	   
	   
	
	   public ControlPay() {super();}
	   public ControlPay(String id,String member,Double amount)
	   {
		   super();
		   this.id=id;
		   this.member=member;
		   this.amount=amount;
		  
		  
	   }
	public String getId() {
		return id;
	}
	public String getMember() {
		return member;
	}
	public Double getAmount() {
		return amount;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

}
