package com.cloudstory.spring.security.demo.component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cloudstory.spring.security.demo.entity.User;

public class MyUserDeatils implements UserDetails {
	
	private String userName;
	private boolean active;
	private String password;
	private List<GrantedAuthority> authorities;

	public MyUserDeatils(User user	) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.active = user.getActive();
		this.authorities = Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		
	}
	
	public MyUserDeatils() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.authorities;
	}

	@Override
	public String getPassword() {
		
		return this.password;
	}

	@Override
	public String getUsername() {
		
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return this.active;
	}

}
