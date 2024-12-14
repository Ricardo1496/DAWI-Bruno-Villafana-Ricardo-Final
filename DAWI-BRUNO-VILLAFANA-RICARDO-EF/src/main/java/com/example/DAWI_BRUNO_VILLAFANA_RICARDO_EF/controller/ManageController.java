package com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.controller;


import com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.dto.CarDto;
import com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService manageService;

    @GetMapping("/start")
    public String start(Model model) {
        try {
            List<CarDto> cars = manageService.getAllCars();
            model.addAttribute("cars", cars);
            model.addAttribute("error", "");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrio un error al obtener los datos");
        }
        return "manage";
    }

}
