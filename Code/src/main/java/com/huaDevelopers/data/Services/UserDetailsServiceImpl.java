package com.huaDevelopers.data.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.Interfaces.UserDAO;
import com.huaDevelopers.data.Entities.Role;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO usrDAO;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.huaDevelopers.data.Entities.User user = usrDAO.getUserByUsername(username);
		if (user != null) {
			List<GrantedAuthority> authorities = buildUserAuthority(user.getAssignedRole());
			return buildUserForAuthentication(user, authorities);
		}else{
			throw new UsernameNotFoundException("User not found");
		}
	}

	// Converts com.huaDevelopers.data.Entities.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.huaDevelopers.data.Entities.User user,
			List<GrantedAuthority> authorities) {
		return new User(user.getUserName(), user.getPassword(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Role role) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		List<Role> userRoles = new ArrayList<Role>();
		userRoles.add(role);

		// Build user's authorities
		for (Role userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
