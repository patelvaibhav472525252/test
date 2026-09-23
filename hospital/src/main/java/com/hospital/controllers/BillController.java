package com.hospital.controllers;

import com.hospital.models.Bill;
import com.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping
    public List<Bill> getAllBills() {
        System.out.println("Fetching the Bills");
        return billService.getAllBills();
    }

    @PostMapping
    public Bill createBills(@RequestBody Bill bill){
        System.out.println("creating Bills");
        return billService.createBill(bill);
    }

    @GetMapping("/{id}")
    public Bill getBillsById(@PathVariable Long id){
        System.out.println("Fetching the Bills by id");
        return billService.getBillById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBills(@PathVariable Long id){
        billService.deleteBill(id);
    }

    @PutMapping("/{id}")
    public void updateBills(@PathVariable Long id){
        billService.updateBill(id);
    }
}
