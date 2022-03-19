package com.application.persistence.repositories;

import com.application.persistence.entities.CashDevice;
import com.application.persistence.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashDeviceRepository extends JpaRepository<CashDevice, Long> {
    public CashDevice findCashDeviceByDeviceName(String name);

    public CashDevice findCashDeviceByStoreInformation(Store store);
}