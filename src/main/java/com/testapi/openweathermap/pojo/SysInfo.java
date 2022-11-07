package com.testapi.openweathermap.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import  lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysInfo {
    private String country;
    private int sunrise;
    private int sunset;
    private int type;
    private int id;
}