package com.tcrb.shoppingcart.product;
        import lombok.Data;

@Data
public class ResponseProduct {
    private int id;
    private String name;
    private String genderId;
    private int ageId;
    private double price;
    private boolean availability;
    private String brand;

}
