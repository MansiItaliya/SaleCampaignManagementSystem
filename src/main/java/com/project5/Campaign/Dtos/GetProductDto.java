package com.project5.Campaign.Dtos;

public class GetProductDto {
    private int id;
    private String name;
    private int MRP;
    private int currPrice;
    private int inventory;

    public GetProductDto(){}
    public GetProductDto(int id, String name, int MRP, int currPrice, int inventory) {
        this.id = id;
        this.name = name;
        this.MRP = MRP;
        this.currPrice = currPrice;
        this.inventory = inventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMRP() {
        return MRP;
    }

    public void setMRP(int MRP) {
        this.MRP = MRP;
    }

    public int getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(int currPrice) {
        this.currPrice = currPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
