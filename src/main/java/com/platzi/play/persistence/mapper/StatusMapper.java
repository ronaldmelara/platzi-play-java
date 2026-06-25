package com.platzi.play.persistence.mapper;

import org.mapstruct.Named;

public class StatusMapper {

    @Named("stringToBoolean")
    public static Boolean stringToBoolean(String estado){
        if(estado== null) return null;

        return "D".equalsIgnoreCase(estado) ? true : ("N".equalsIgnoreCase(estado) ? false : null);
    }

    @Named("booleanToString")
    public static String booleanToString(Boolean estado){
        if(estado== null) return null;

        return (estado  ? "D" : "N");
    }
}
