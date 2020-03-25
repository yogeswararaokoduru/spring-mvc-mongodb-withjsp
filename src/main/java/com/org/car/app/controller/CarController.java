package com.org.car.app.controller;

import com.org.car.app.model.Car;
import com.org.car.app.repository.CarMangoRepository;
import com.org.car.app.repository.CarSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @Autowired
    private CarMangoRepository carRepository;

    @Autowired
    private CarSearchRepository carSearchRepository;

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("carList", carRepository.findAll());
        return "home";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String addCar(@ModelAttribute Car car) {
        carRepository.save(car);


        return "redirect:home";
    }


    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam String search) {
        model.addAttribute("carList", carSearchRepository.searchCars(search));
        model.addAttribute("search", search);
        return "home";
    }
    @RequestMapping(value = "/delete_car", method = RequestMethod.GET)
    public String deletebyid(@RequestParam(name="id")String id) {
        carRepository.deleteById(id);
        return "redirect:/home";
    }
}

