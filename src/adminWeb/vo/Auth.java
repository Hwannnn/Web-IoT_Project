package adminWeb.vo;

public class Auth {
	protected int 		auth_no;
	protected String	auth_id;
	protected String 	password;
	protected String	resident_num;
	protected String 	name;
	protected String 	phone;
	protected String	email;

	public int getAuth_no() {
		return auth_no;
	}
	public Auth setAuth_no(int auth_no) {
		this.auth_no = auth_no;
		return this;
	}
	public String getAuth_id() {
		return auth_id;
	}
	public Auth setAuth_id(String Auth_id) {
		this.auth_id = Auth_id;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Auth setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getResident_num() {
		return resident_num;
	}
	public Auth setResident_num(String resident_num) {
		this.resident_num = resident_num;
		return this;
	}
	public String getName() {
		return name;
	}
	public Auth setName(String name) {
		this.name = name;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public Auth setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Auth setEmail(String email) {
		this.email = email;
		return this;
	}
}
