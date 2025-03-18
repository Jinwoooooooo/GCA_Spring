package kr.co.ch07.dto;

import lombok.Data;

@Data
public class ProductAggDTO {
    private int priceSum;
    private double priceAvg;
    private int priceMax;
    private int priceMin;
}