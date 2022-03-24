package com.application.utils.mappers;

import com.application.dto.CashDeviceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.TimeZone;

public class CashDeviceConversion {
    @Autowired
    private static ModelMapper modelMapper;

    public static CashDeviceDTO convertToDTO(CashDevice device){
        var cashDeviceDTO = modelMapper.map(device, CashDeviceDTO.class);
        cashDeviceDTO.setOpeningDate(device.getOpeningDate(), TimeZone.getTimeZone("GMT + 1").getID());
        return cashDeviceDTO;
    }
/*
    public static CashDevice convertToEntity(CashDeviceDTO cashDeviceDTO){

    }

 */
}
