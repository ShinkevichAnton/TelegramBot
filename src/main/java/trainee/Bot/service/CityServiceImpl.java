package trainee.Bot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import trainee.Bot.dao.CityDao;
import trainee.Bot.model.City;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;

	@Override
	public City save(City city) {
		return cityDao.save(city);
	}

	@Override
	public Optional<City> findById(Long id) {
		return cityDao.findById(id);
	}

	@Override
	public Iterable<City> findAll() {
		return cityDao.findAll();
	}

	@Override
	public void deleteById(Long id) {
		cityDao.deleteById(id);

	}

	@Override
	public List<City> findByName(Example<City> example) {
		return cityDao.findAll(example);
	}

}
