package com.testapi.openweathermap.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import  lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wind {

    private double speed;
    private int deg;
    private double gust;
}
