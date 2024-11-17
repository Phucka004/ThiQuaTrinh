package iostar.model;

import java.util.Date;



public class User {
	 	private int id;
	 	private String email;
	    private String fullname;
	    private String phone;
	    private String passwd;
	    private Date signup_date;
	    private Date last_login;
	    private Boolean is_admin;
		public User() {
		}
		
		
		public User(int id, String email, String fullname, String phone, String passwd, Date signup_date,
				Date last_login, Boolean is_admin) {
			this.id = id;
			this.email = email;
			this.fullname = fullname;
			this.phone = phone;
			this.passwd = passwd;
			this.signup_date = signup_date;
			this.last_login = last_login;
			this.is_admin = is_admin;
		}


		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFullname() {
			return fullname;
		}
		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getPasswd() {
			return passwd;
		}
		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}
		public Date getSignup_date() {
			return signup_date;
		}
		public void setSignup_date(Date signup_date) {
			this.signup_date = signup_date;
		}
		public Date getLast_login() {
			return last_login;
		}
		public void setLast_login(Date last_login) {
			this.last_login = last_login;
		}
		public Boolean getIs_admin() {
			return is_admin;
		}
		public void setIs_admin(Boolean is_admin) {
			this.is_admin = is_admin;
		}
	    
    

} 