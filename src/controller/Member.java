package controller;

import java.sql.Date;

public class Member {
	 private String id;
	   private String name;
	   private String contact;
	   private String adress;
	   private String email;
	   private Date birth;
	   private int gender;
	   private Date JoiningDate;
	   private Date EndMemberShip;
	   private int Membership;
	   public Member() {super();}
	   public Member(String id,String name,String contact, String adress, String email,Date birth,int gender,Date JoiningDate, Date EndMemberShip, int Membership)
	   {
		   super();
		   this.id=id;
		   this.name=name;
		   this.contact=contact;
		   this.adress=adress;
		   this.email=email;
		   this.birth=birth;
		   this.gender=gender;
		   this.JoiningDate=JoiningDate;
		   this.EndMemberShip=EndMemberShip;
		   this.Membership=Membership;
	   }
	   
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public void setJoiningDate(Date joiningDate) {
		JoiningDate = joiningDate;
	}
	public void setEndMemberShip(Date endMemberShip) {
		EndMemberShip = endMemberShip;
	}
	public void setMembership(int membership) {
		Membership = membership;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getContact() {
		return contact;
	}
	public String getAdress() {
		return adress;
	}
	public String getEmail() {
		return email;
	}
	public Date getBirth() {
		return birth;
	}
	public int getGender() {
		return gender;
	}
	public Date getJoiningDate() {
		return JoiningDate;
	}
	public Date getEndMemberShip() {
		return EndMemberShip;
	}
	public int getMembership() {
		return Membership;
	}
}
