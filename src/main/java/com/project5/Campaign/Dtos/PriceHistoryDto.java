package com.project5.Campaign.Dtos;

import java.time.LocalDate;

public class PriceHistoryDto {
    private Integer id;
    private Integer currPrice;
    private LocalDate date;
    private String title;
    private Integer productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(Integer currPrice) {
        this.currPrice = currPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
