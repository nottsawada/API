package com.thanachai.API.Bill;

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
    public List<DataBill> getBills() {
//         throw new ApiRequestException("Cannot get all bill");
            return billService.getBills();
    }

//    @PostMapping
//    public void addNewBill(@RequestBody Bill bill){
//        billService.addNewBill(bill);
//
//    }



    @RequestMapping(value = "/addorder", method = RequestMethod.POST)
    public ResponseEntity<?> registerNewBill(@RequestBody DataBill dataBill){

        return  ResponseEntity.ok( billService.addNewBill(dataBill)) ;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteBill(@RequestParam String orderid){

        return  ResponseEntity.ok( billService.deleteBill(Long.valueOf(orderid))) ;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResponseEntity<?> updateBill(@RequestBody DataBill dataBill){

        return ResponseEntity.ok( billService.updateBill(dataBill) );
    }

}
