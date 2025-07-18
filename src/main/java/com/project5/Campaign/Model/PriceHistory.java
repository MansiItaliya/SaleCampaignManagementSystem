package com.project5.Campaign.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer currPrice;
    private LocalDate date;
    private String title;
    private Integer productId;

    public PriceHistory(){}
    public PriceHistory(int productId,int currPrice,LocalDate date, String title) {
        this.productId = productId;
        this.currPrice = currPrice;
        this.date = date;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(int currPrice) {
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PriceHistory that = (PriceHistory) o;
        return id == that.id && currPrice == that.currPrice && productId == that.productId && Objects.equals(date, that.date) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currPrice, date, title, productId);
    }
}
