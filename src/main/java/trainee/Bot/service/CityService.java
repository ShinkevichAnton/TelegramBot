package trainee.Bot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;

import trainee.Bot.model.City;

public interface CityService {

	public City save(City city);

	Optional<City> findById(Long id);

	Iterable<City> findAll();

	void deleteById(Long id);

	public List<City> findByName(Example<City> example);

}
