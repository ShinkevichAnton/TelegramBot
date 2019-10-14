package trainee.Bot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import trainee.Bot.model.City;
import trainee.Bot.service.CityService;

@Controller
public class BotController {

	@Autowired
	private CityService cityService;

	@RequestMapping("/")
	public ModelAndView start() {
		
		//при первом запуске убрать коментарий для заполнения базы данных
		/*City city = new City();
		city.setName("Москва");
		city.setInformation("«Не забудьте посетить Красную Площадь. Ну а в ЦУМ можно и не заходить)))»");
		City city2 = new City();
		city2.setName("Минск");
		city2.setInformation("«Не забудьте посетить Парк Челюскенцев. Ну а в ЦУМ можно и не заходить)))»");
		City city3 = new City();
		city3.setName("Варшава");
		city3.setInformation("«Не забудьте посетить Старый город. Ну а набережную Вислы тоже не пропустите)))»");
		cityService.save(city);
		cityService.save(city2);
		cityService.save(city3);*/

		return new ModelAndView("start");
	}

	@RequestMapping("/admin")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("admin");
		modelAndView.addObject("city", cityService.findAll());
		return modelAndView;
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("add");
		return modelAndView;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView add(@RequestParam String name, @RequestParam String information) {
		City city = new City();
		city.setName(name);
		city.setInformation(information);
		cityService.save(city);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin");
		return modelAndView;
	}

	@RequestMapping(path = "/{id}/update", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("edit");
		Optional<City> optional = cityService.findById(id);
		if (optional.isPresent()) {
			modelAndView.addObject("city", optional.get());
		}
		return modelAndView;
	}

	@RequestMapping(path = "/edit", method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute City city, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("start");
		}
		cityService.save(city);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin");
		return modelAndView;
	}

	@RequestMapping("/{id}/delete")
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin");
		cityService.deleteById(id);
		return modelAndView;

	}

}
