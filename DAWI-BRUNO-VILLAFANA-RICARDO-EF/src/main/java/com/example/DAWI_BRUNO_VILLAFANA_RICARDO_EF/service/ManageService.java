package com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.service;

import com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.dto.CarDetailDto;
import com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDto> getCarsById(int id) throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;

}
