package com.hospital.service;

import com.hospital.models.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    public List<Bill> getAllBills(){

        try{
            System.out.println("into service layer");
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id){
        try{
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }

    public Bill createBill(Bill bill){
        try{
            return null;
        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }

    public void deleteBill(Long id){
        try{

        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
        }
    }

    public Bill updateBill(Long id){
        try{
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }
}
