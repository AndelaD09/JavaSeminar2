package com.application.utils;


import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public class Mappers {
    private static final ModelMapper mapper = new ModelMapper();

    public static <S, T> T mapperMap(S source, Class<T> destinationType) {
        return mapper.map(source, destinationType);
    }
}
