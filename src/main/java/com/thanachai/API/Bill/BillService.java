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
    public List<DataBill> getBills(){

        return billRepository.findAll();
    }

//    public void addNewBill(Bill bIll){
//        Optional<Bill> billByName = billRepository
//                .findBillByName(bIll.getName());
//        if (billOptional.isPresent()){
//            return new AddOrderReponse("0","เพิ่มรายการไม่สำเร็จ");
//        }
//        billRepository.save(bill)
//        return new AddOrderReponse("1","เพิ่มรายการสำเร็จ  ! success");
//    }
    public AddOrderReponse addNewBill(DataBill dataBill) {
        Optional<DataBill> billOptional = billRepository
                .findBillByName(dataBill.getName());
        if (billOptional.isPresent()){
            return new AddOrderReponse("0","เพิ่มรายการไม่สำเร็จ ! ");
        }

        billRepository.save(dataBill);
        return new AddOrderReponse("1","เพิ่มรายการสำเร็จ  ! success");
    }

//    public void deleteBill(Long order_id){
//        billRepository.findById(order_id);
//        boolean exists = billRepository.existsById(order_id);
//               }
//    }

    public AddOrderReponse deleteBill(Long order_id) {
        billRepository.findById(order_id);
        boolean exists = billRepository.existsById(order_id);
        if (!exists){
            return new AddOrderReponse("0","bill with order_id" + order_id +" does not exists ");
        }
        billRepository.deleteById(order_id);
        return new AddOrderReponse("1","ลบรายการสำเร็จ  ! order deleted ");
    }
    @Transactional
    public  AddOrderReponse updateBill(DataBill putDataBill) {
        DataBill dataBill = billRepository.findById(putDataBill.getOrder_id()).orElseThrow(() -> new IllegalStateException(
                "bill with order_id" + putDataBill.getOrder_id() + "does not exist"));
        if (putDataBill.getName() != null &&
                putDataBill.getName().length() > 0 &&
                !Objects.equals(dataBill.getName(), putDataBill.getName())) {
            dataBill.setName(putDataBill.getName());
        }
        if (putDataBill.getTel() != null &&
                putDataBill.getTel().length() > 0 &&
                !Objects.equals(dataBill.getTel(), putDataBill.getTel())) {
            Optional<DataBill> billOptional = billRepository.findBillByName(putDataBill.getName());
            if (billOptional.isPresent()) {
                return new AddOrderReponse("0","เบอร์ไม่ถูกต้อง");
            }
            dataBill.setTel(putDataBill.getTel());
        }
        if (putDataBill.getAddress() != null &&
                putDataBill.getAddress().length() > 0 &&
                !Objects.equals(dataBill.getAddress(), putDataBill.getAddress())) {
            Optional<DataBill> billOptional = billRepository.findBillByName(putDataBill.getName());
            if (billOptional.isPresent()) {
                return new AddOrderReponse("0","ที่อยู่ไม่ถูกต้อง");
            }
            dataBill.setAddress(putDataBill.getAddress());
        }
        if (putDataBill.getService_id() != null &&
                putDataBill.getService_id().length() > 0 &&
                !Objects.equals(dataBill.getService_id(), putDataBill.getService_id())) {
            Optional<DataBill> billOptional = billRepository.findBillByName(putDataBill.getName());
            if (billOptional.isPresent()) {
                return new AddOrderReponse("0","เลขบัญชีไม่ถูกต้อง");
            }
            dataBill.setService_id(putDataBill.getService_id());
        }
        if (putDataBill.getMoney_card() != null &&
                putDataBill.getMoney_card().length() > 0 &&
                !Objects.equals(dataBill.getMoney_card(), putDataBill.getMoney_card())) {
            Optional<DataBill> billOptional = billRepository.findBillByName(putDataBill.getName());
            if (billOptional.isPresent()) {
                return new AddOrderReponse("0","ธนาคารไม่ถูกต้อง");
            }
            dataBill.setMoney_card(putDataBill.getMoney_card());
        }
        if (putDataBill.getAmount() != null &&
                putDataBill.getAmount().intValue() > 0 &&
                !Objects.equals(dataBill.getAmount(), putDataBill.getAmount())) {
            Optional<DataBill> billOptional = billRepository.findBillByName(putDataBill.getName());
            if (billOptional.isPresent()) {
                return new AddOrderReponse("0","จำนวนเงินไม่ถูกต้อง");
            }
            dataBill.setAmount(putDataBill.getAmount());
        }
        if (putDataBill.getFee() != null &&
                putDataBill.getFee().intValue() > 0 &&
                !Objects.equals(dataBill.getFee(), putDataBill.getFee())) {
            Optional<DataBill> billOptional = billRepository.findBillByName(putDataBill.getName());
            if (billOptional.isPresent()) {
                return new AddOrderReponse("0","ค่าธรรมเนียมไม่ถูกต้อง");
            }
            dataBill.setFee(putDataBill.getFee());
        }


        return new AddOrderReponse("1","แก้ไขสำเร็จ");
    }


}
