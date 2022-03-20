package com.application.dto;

import com.application.persistence.entities.Address;
import lombok.Data;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Data
public class ReceiptDTO {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private Long id;
    private String storeName;
    private String date;
    private Address address;
    private List<ReceiptPerProductDTO> productList;

    public Date DateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(date);
    }

    public void setDate(Date date1, String timezone){
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        date = dateFormat.format(date1);
    }

}
