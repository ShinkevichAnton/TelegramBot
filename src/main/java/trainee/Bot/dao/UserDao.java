package trainee.Bot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import trainee.Bot.model.User;

public interface UserDao extends JpaRepository<User, Long> {
	public Optional<User> findByLogin(String login);

}
