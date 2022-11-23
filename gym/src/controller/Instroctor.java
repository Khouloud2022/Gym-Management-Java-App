package controller;

public class Instroctor {
   private String id;
   private String name;
   private String contact;
   private String adress;
   private String email;
   public Instroctor() {super();}
   public Instroctor(String id,String name,String contact, String adress, String email)
   {
	   super();
	   this.id=id;
	   this.name=name;
	   this.contact=contact;
	   this.adress=adress;
	   this.email=email;
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
public void setId(String id) {
	this.id = id;
}
public String getId() {
	return id;
}
}
