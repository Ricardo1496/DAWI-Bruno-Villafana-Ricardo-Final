package com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.response;

import com.example.DAWI_BRUNO_VILLAFANA_RICARDO_EF.dto.CarDetailDto;

public record FindCarsByIdResponse(String code,
                                   String error,
                                   CarDetailDto car) {
}
