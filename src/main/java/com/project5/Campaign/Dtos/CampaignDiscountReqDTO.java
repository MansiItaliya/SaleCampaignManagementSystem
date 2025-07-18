package com.project5.Campaign.Dtos;

public class CampaignDiscountReqDTO {
    private int productId;
    private int discount;

    public CampaignDiscountReqDTO(){}
    public CampaignDiscountReqDTO(int productId, int discount) {
        this.productId = productId;
        this.discount = discount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
