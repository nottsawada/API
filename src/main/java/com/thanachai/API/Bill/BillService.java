package com.thanachai.API.Bill;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {

        this.billRepository = billRepository;
    }
    public List<Bill> getBills(){
        return billRepository.findAll();
    }

    public void addNewBill(Bill bill) {
        Optional<Bill> billOptional = billRepository
        .findBillByName(bill.getName());
        if (billOptional.isPresent()){
            throw new IllegalStateException("Name Taken");
        }
        billRepository.save(bill);
    }

    public void deleteBill(Long order_id) {
        billRepository.findById(order_id);
        boolean exists = billRepository.existsById(order_id);
        if (!exists){
            throw new IllegalStateException(
                    "bill with order_id" + order_id+"does not exists");
        }
        billRepository.deleteById(order_id);
    }
    @Transactional
    public  void updateBill(Long order_id,
                            String name,
                            String tel){
        Bill bill = billRepository.findById(order_id).orElseThrow(() -> new IllegalStateException(
                "bill with order_id" + order_id + "does not exist"));
                if(name != null &&
                        name.length()> 0 &&
                !Objects.equals(bill.getName(), name)){
                    bill.setName(name);
        }
                if (tel != null &&
                        tel.length() > 0 &&
                !Objects.equals(bill.getTel(), tel)){
                    Optional<Bill> billOptional = billRepository.findBillByName(name);
                    if (billOptional.isPresent()){
                        throw new IllegalStateException("name taken");
                    }
                    bill.setName(name);
                }
    }
}
