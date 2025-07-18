package com.project5.Campaign.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @Column(name = "mrp")
    @JsonProperty("MRP")
    @NotBlank(message = "MRP is required")
    private Integer MRP;
    @NotBlank(message = "currPrice is required")
    private Integer currPrice;
    @NotBlank(message = "inventory is required")
    private Integer inventory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<CampaignProduct> campaignProductSet;

    public Product(){}

    public Product(Integer id, String name, Integer MRP, Integer currPrice, Integer inventory, Set<CampaignProduct> campaignProductSet) {
        this.id = id;
        this.name = name;
        this.MRP = MRP;
        this.currPrice = currPrice;
        this.inventory = inventory;
        this.campaignProductSet = campaignProductSet;
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

    public Set<CampaignProduct> getCampaignProductSet() {
        return campaignProductSet;
    }

    public void setCampaignProductSet(Set<CampaignProduct> campaignProductSet) {
        this.campaignProductSet = campaignProductSet;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && MRP == product.MRP && currPrice == product.currPrice && inventory == product.inventory && Objects.equals(name, product.name) && Objects.equals(campaignProductSet, product.campaignProductSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, MRP, currPrice, inventory, campaignProductSet);
    }
}
