package com.thanachai.API.Bill;

//import exception.ApiRequestException;
import exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
      // throw new ApiRequestException("Cannot get all bill");
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
            @RequestParam(required = false) String tel,
            @RequestParam(required = false) String address,
            @RequestParam(required = false)String service_id,
            @RequestParam(required = false)String money_card,
            @RequestParam(required = false)Integer amount,
            @RequestParam(required = false)Integer fee,
            @RequestParam(required = false)Integer total,
            @RequestParam(required = false)String slip,
            @RequestParam(required = false)String status){
        billService.updateBill(order_id,name,tel,address,service_id,
                money_card,amount,fee,total,slip,status);

    }

}
