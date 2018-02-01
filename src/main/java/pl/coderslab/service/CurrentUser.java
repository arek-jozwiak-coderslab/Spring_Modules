package pl.coderslab.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

	private final long userID;

	public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			long userID) {
		super(username, password, authorities);
		this.userID = userID;
	}

	public long getUserID() {
		return userID;
	}
	
}
