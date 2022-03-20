package com.application.dto;

import com.application.persistence.entities.UserType;
import lombok.Data;
import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Data
public class CashDeviceDTO {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private Long id;
    private String DeviceName;
    private List<UserType> userType;
    private StoreDTO store;
    private String openingDate;
    private String closingDate;

    public Date getOpeningDateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(openingDate);
    }

    public void setOpeningDate(Date date, String timezone){
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        openingDate = dateFormat.format(date);
    }

    public Date getClosingDateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(closingDate);
    }

    public void setClosingDate(Date date, String timezone){
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        closingDate = dateFormat.format(date);
    }

}
