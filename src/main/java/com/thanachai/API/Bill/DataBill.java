package com.thanachai.API.Bill;

import javax.persistence.*;

@Entity
@Table
public class DataBill {

    @Id
    @SequenceGenerator(
            name = "Bill_sequence",
            sequenceName = "bill_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bill_sequence"
    )
    private Long order_id;
    private String time_stamp;
    private String name;
    private String address;
    private String tel;
    private String service_id;
    private String money_card;
    private Integer amount;
    private Integer fee;
    private Integer total;
    private String slip;
    private String status;

    public DataBill(){

    }

    public DataBill(Long order_id, String time_stamp,
                    String name, String address, String tel,
                    String service_id, String money_card,
                    Integer amount, Integer fee, Integer total,
                    String slip, String status) {
        this.order_id = order_id;
        this.time_stamp = time_stamp;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.service_id = service_id;
        this.money_card = money_card;
        this.amount = amount;
        this.fee = fee;
        this.total = total;
        this.slip = slip;
        this.status = status;
    }

    public DataBill(String time_stamp, String name, String address, String tel, String service_id, String money_card,
                    Integer amount, Integer fee, Integer total, String slip, String status) {
        this.time_stamp = time_stamp;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.service_id = service_id;
        this.money_card = money_card;
        this.amount = amount;
        this.fee = fee;
        this.total = total;
        this.slip = slip;
        this.status = status;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getMoney_card() {
        return money_card;
    }

    public void setMoney_card(String money_card) {
        this.money_card = money_card;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getSlip() {
        return slip;
    }

    public void setSlip(String slip) {
        this.slip = slip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "order_id='" + order_id + '\'' +
                ", time_stamp='" + time_stamp + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", service_id='" + service_id + '\'' +
                ", money_card='" + money_card + '\'' +
                ", amount=" + amount +
                ", fee=" + fee +
                ", total=" + total +
                ", slip='" + slip + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
