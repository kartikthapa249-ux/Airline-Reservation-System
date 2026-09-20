package Entitites;

public class Passenger_entites {
	
	private int id;
	private String name;
	private int contact;
	private String email_id;
	private String password;
	public Passenger_entites() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passenger_entites(String name, int contact, String email_id, String password) {
		super();
		this.name = name;
		this.contact = contact;
		this.email_id = email_id;
		this.password = password;
	}
	public Passenger_entites(int id, String name, int contact, String email_id, String password) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email_id = email_id;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Passenger_entites [id=" + id + ", name=" + name + ", contact=" + contact + ", email_id=" + email_id
				+ ", password=" + password + "]";
	}
	

}
