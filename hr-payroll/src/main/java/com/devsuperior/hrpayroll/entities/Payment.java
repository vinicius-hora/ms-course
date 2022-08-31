package com.devsuperior.hrpayroll.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class Payment implements Serializable {

    private static final long SerialVersionUID = 1L;

    private String name;
    private Double dailyIncome;
    private Integer days;


    public Payment() {
    }

    public Payment(String name, Double dailyIncome, Integer days) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
    }

    public double getTotal(){
        return days * dailyIncome;

    }
}
