package com.thanachai.API.Bill;

import exception.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddOrderReponse<เพิ่มรายการสำเร็จ, success> {
    private String status;
    private String description;

    public AddOrderReponse(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    {

    }

    @Override
    public String toString() {
        return "AddOrderReponse{" +
                "status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    }

