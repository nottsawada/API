package com.thanachai.API.Bill;



import exception.ApiRequestException;
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
            throw new IllegalStateException("Cannot Insert Bill");
        }

        billRepository.save(bill);
        throw new ApiRequestException("Insert Bill Success");
    }

    public void deleteBill(Long order_id) {
       // billRepository.findById(order_id);
        boolean exists = billRepository.existsById(order_id);
        if (!exists){
            throw new IllegalStateException(
                    "bill with order_id" + order_id +" does not exists ");
        }
        billRepository.deleteById(order_id);
        throw new ApiRequestException("Delete Success");
    }
    @Transactional
    public  void updateBill(Long order_id,
                            String name,
                            String tel,
                            String address,
                            String service_id,
                            String money_card,
                            Integer amount,
                            Integer fee,
                            Integer total,
                            String slip,
                            String status) {
        Bill bill = billRepository.findById(order_id).orElseThrow(() -> new IllegalStateException(
                "bill with order_id" + order_id + "does not exist"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(bill.getName(), name)) {
            bill.setName(name);
        }
        if (tel != null &&
                tel.length() > 0 &&
                !Objects.equals(bill.getTel(), tel)) {
            Optional<Bill> billOptional = billRepository.findBillByName(name);
            if (billOptional.isPresent()) {
                throw new IllegalStateException("tel taken");
            }
            bill.setTel(tel);
        }
        if (address != null &&
                address.length() > 0 &&
                !Objects.equals(bill.getAddress(), address)) {
            Optional<Bill> billOptional = billRepository.findBillByName(name);
            if (billOptional.isPresent()) {
                throw new IllegalStateException("Address taken");
            }
            bill.setAddress(address);
        }
        if (service_id != null &&
                service_id.length() > 0 &&
                !Objects.equals(bill.getService_id(), service_id)) {
            Optional<Bill> billOptional = billRepository.findBillByName(name);
            if (billOptional.isPresent()) {
                throw new IllegalStateException("Service_id taken");
            }
            bill.setService_id(service_id);
        }
        if (money_card != null &&
                money_card.length() > 0 &&
                !Objects.equals(bill.getMoney_card(), money_card)) {
            Optional<Bill> billOptional = billRepository.findBillByName(name);
            if (billOptional.isPresent()) {
                throw new IllegalStateException("money_card taken");
            }
            bill.setMoney_card(money_card);
        }
        if (amount != null &&
                amount.intValue() > 0 &&
                !Objects.equals(bill.getAmount(), amount)) {
            Optional<Bill> billOptional = billRepository.findBillByName(name);
            if (billOptional.isPresent()) {
                throw new IllegalStateException("amount taken");
            }
            bill.setAmount(amount);
        }
        if (fee != null &&
                fee.intValue() > 0 &&
                !Objects.equals(bill.getFee(), fee)) {
            Optional<Bill> billOptional = billRepository.findBillByName(name);
            if (billOptional.isPresent()) {
                throw new IllegalStateException("fee taken");
            }
            bill.setFee(fee);
        }
    }
}
