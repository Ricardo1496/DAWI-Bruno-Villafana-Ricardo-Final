package com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.response;

import com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
