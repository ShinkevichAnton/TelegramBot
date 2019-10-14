package trainee.Bot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import trainee.Bot.model.City;

public interface CityDao extends JpaRepository<City, Long> {

	public List<City> findByName(String name);

}
