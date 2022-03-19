package com.application.services;

import com.application.persistence.entities.CashDevice;
import com.application.persistence.entities.Store;
import com.application.persistence.repositories.CashDeviceRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CashDeviceService {
    @Autowired
    private CashDeviceRepository cashDeviceRepository;

    public CashDevice addNewCashDevice(CashDevice cashDevice){
        return cashDeviceRepository.save(cashDevice);
    }

    public List<CashDevice> getAll(){
        return cashDeviceRepository.findAll();
    }

    public CashDevice findDeviceByStore(Store store){
        return cashDeviceRepository.findCashDeviceByStoreInformation(store);
    }

    public Optional<CashDevice> findDeviceByID(long id){
        return cashDeviceRepository.findById(id);
    }
}
