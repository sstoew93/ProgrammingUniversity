package com.example.demo.dtos;

public class UserWithOneSoldProductDTO {
    private String firstName;
    private String lastName;
    private ProductSoldDTO soldProducts;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ProductSoldDTO getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductSoldDTO soldProducts) {
        this.soldProducts = soldProducts;
    }
}
