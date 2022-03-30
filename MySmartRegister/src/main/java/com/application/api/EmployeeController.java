package com.application.api;

import com.application.persistence.entities.Receipt;
import com.application.services.CashBalanceService;
import com.application.services.ReceiptService;
import com.application.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private CashBalanceService cashBalanceService;
    @Autowired
    private StockService stockService;
    @Autowired
    private ReceiptService receiptService;
}
