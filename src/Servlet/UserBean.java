package servlet;

public class UserBean {
	private String username;
	private String password;
	private String name;
	public boolean valid;

	public String getName() {
		return name;
	}

    public void setName(String newName) {
       name = newName;
	}

    public String getPassword() {
         return password;
	}

    public void setPassword(String newPassword) {
        password = newPassword;
	}
     
    public String getUsername() {
        return username;
	}

    public void setUserName(String newUsername) {
    	username = newUsername;
    }

 				
    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean newValid) {
        valid = newValid;
    }	
}
