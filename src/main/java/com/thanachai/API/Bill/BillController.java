package com.thanachai.API.Bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/api/v1/bill")
public class BillController {
    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
   public List<Bill> getBills(){

        return billService.getBills();
    }
    @PostMapping
    public void registerNewBill(@RequestBody Bill bill){
        billService.addNewBill(bill);
    }
    @DeleteMapping(path = "{order_id}")
    public void deleteBill(
            @PathVariable("order_id") Long order_id){
        billService.deleteBill(order_id);
    }
    @PutMapping(path = "{order_id}")
    public void updateBill(
            @PathVariable("order_id") Long order_id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String tel){
        billService.updateBill(order_id,name,tel);
    }

}
