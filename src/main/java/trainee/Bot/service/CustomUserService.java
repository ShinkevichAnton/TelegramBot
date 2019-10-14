package trainee.Bot.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import trainee.Bot.model.User;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder encoder;

	@PostConstruct
	public void init() {
		if (!userService.findByLogin("user").isPresent()) {
			User user = new User();
			user.setLogin("user");
			user.setPassword(encoder.encode("password"));
			user.setRole("ADMIN");

			userService.save(user);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userService.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("User not Founded"));
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		org.springframework.security.core.userdetails.User man = new org.springframework.security.core.userdetails.User(
				user.getLogin(), user.getPassword(), true, true, true, true, authorities);
		return man;
	}

}
