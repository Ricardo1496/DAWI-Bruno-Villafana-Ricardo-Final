package com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.api;

import com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.dto.CarDetailDto;
import com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.dto.CarDto;
import com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.response.*;
import com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponse findCars() {
        try {
            List<CarDto> cars = manageService.getAllCars();
            return new FindCarsResponse("01", "", cars);
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "No se encontro servicio", null);

        }
    }

    @GetMapping("/detail")
    public FindCarsByIdResponse findCarById(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CarDetailDto> optional = manageService.getCarById(Integer.parseInt(id));
                if (optional.isPresent()) {
                    CarDetailDto carDetailDto = optional.get();
                    return new FindCarsByIdResponse("01", "", carDetailDto);
                } else {
                    return new FindCarsByIdResponse("02", "No se encontro el carro", null);
                }
            } else
                return new FindCarsByIdResponse("03", "No se encontro el parametro", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsByIdResponse("99", "No se encontro servicio", null);

        }
    }

    @PostMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDto carDto) {

        try {

            if (manageService.updateCar(carDto)) {
                return new UpdateCarResponse("01", "");
            } else {
                return new UpdateCarResponse("02", "No se encontró el carro");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "No se encontró servicio");

        }


    }

    @PostMapping("/delete")
    public DeleteCarByIdResponse deleteCarById(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if (Integer.parseInt(id) > 0) {

                boolean isDeleted = manageService.deleteCarById(Integer.parseInt(id));

                if (isDeleted) {
                    return new DeleteCarByIdResponse("01", "");
                } else {
                    return new DeleteCarByIdResponse("02", "No se encontró el carro para eliminar");
                }
            } else {
                return new DeleteCarByIdResponse("03", "No se encontró el parametro");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarByIdResponse("99", "Error al intentar eliminar el carro");
        }
    }

    @PostMapping("/create")
    public CreateCarResponse addCar(@RequestBody CarDetailDto carDetailDto) {


        try {

            boolean isCreated = manageService.addCar(carDetailDto);

            if (isCreated) {
                return new CreateCarResponse("01", "Carro creado con éxito");
            } else {
                return new CreateCarResponse("02", "No se pudo crear el carro");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "Error al intentar crear el carro");
        }
    }
}


