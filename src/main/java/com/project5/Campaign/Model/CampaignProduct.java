package com.project5.Campaign.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CampaignProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "campaign_id",nullable = false)
    private Campaign campaign;

    private Integer discount;

    public CampaignProduct(){}
    public CampaignProduct(Product product, Campaign campaign, Integer discount) {
        this.product = product;
        this.campaign = campaign;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CampaignProduct that = (CampaignProduct) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
