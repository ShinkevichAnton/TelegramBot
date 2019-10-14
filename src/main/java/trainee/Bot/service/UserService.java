package trainee.Bot.service;

import java.util.Optional;

import trainee.Bot.model.User;

public interface UserService {

	public Optional<User> findByLogin(String login);

	public void save(User user);

}
