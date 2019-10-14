package trainee.Bot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trainee.Bot.dao.UserDao;
import trainee.Bot.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public Optional<User> findByLogin(String login) {
		return userDao.findByLogin(login);
	}

}
