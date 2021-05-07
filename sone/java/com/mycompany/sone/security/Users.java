package com.mycompany.sone.security;

public class Users {
    int id;
    String email;
    String password;
    String authority;
    Boolean enabled;
    
    //게터, 세터, toString
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", password=" + password + ", authority=" + authority
				+ ", enabled=" + enabled + "]";
	}

	
}
