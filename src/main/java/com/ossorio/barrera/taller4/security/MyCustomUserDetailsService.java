package com.ossorio.barrera.taller4.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ossorio.barrera.taller4.model.Userr;
import com.ossorio.barrera.taller4.repository.UserrRepository;

@Service
public class MyCustomUserDetailsService implements UserDetailsService {

	private final PasswordEncoder passwordEncoder;
	private final UserrRepository userrRepository;

	public MyCustomUserDetailsService(UserrRepository userrRepository, PasswordEncoder passwordEncoder) {
		this.userrRepository = userrRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Userr user = userrRepository.findByUserName(username);
		if (user != null) {
			System.out.println("User found");
			System.out.println(user.getPerson().getPersonRoles().size());
			final User.UserBuilder builder = User.withUsername(username)
					.password(passwordEncoder.encode(user.getUserPassword())).roles("");
			// user.getPerson().getPersonRoles().get(0).getRolee().getRoleName()
			return builder.build();
		} else {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found.");
		}
	}
}