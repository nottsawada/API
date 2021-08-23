package com.thanachai.API.Bill;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BillConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            BillRepository repository){
        return args -> {
            DataBill ohm = new DataBill(
                    "27",
                    "ohm",
                    "43/3",
                    "0964035316",
                    "4531424553",
                    "krungsri",
                                300,
                                25,
                            325,
                    "slip",
                    "1"
            );
            DataBill eye = new DataBill(
                    "25",
                    "eye",
                    "57/1",
                    "0897456123",
                    "123456789",
                    "krungthai",
                    300,
                    25,
                    325,
                    "slip",
                    "1"
            );

            repository.saveAll(
                    List.of(ohm, eye)
            );
        };
    }
}
