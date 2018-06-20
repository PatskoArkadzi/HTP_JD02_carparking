package by.htp.carparking.web.controller;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

	@Autowired
	private CarService carService;

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView cars() throws ParseException {
//		System.out.println("in cars");
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://www.metaweather.com/api/location/834463/2018/6/20/";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		JSONArray jsonAarray = (JSONArray) new JSONParser().parse(response.getBody());

		return new ModelAndView("carlist", new HashMap<String, Object>() {
			{
				put(REQUEST_PARAM_CAR_LIST, carService.getCarList());
				put("jsonWheather", jsonAarray.get(0));
			}
		});
	}
	@RequestMapping(method = RequestMethod.POST)
	public HttpStatus addCar(@RequestBody Car car) {
//		System.out.println("in addCar car=" + car);
		HttpStatus status;
		if (car != null) {
			carService.createCar(car);
			status = HttpStatus.OK;
		}
		status = HttpStatus.NOT_FOUND;
		return status;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public HttpStatus deleteCar(@RequestBody Car car) {
//		System.out.println("in deleteCar car=" + car);
		HttpStatus status;
		if (car != null) {
			carService.deleteCar(car);
			status = HttpStatus.OK;
		}
		status = HttpStatus.NOT_FOUND;
		return status;
	}
}
