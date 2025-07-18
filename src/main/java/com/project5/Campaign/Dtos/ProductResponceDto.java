package com.project5.Campaign.Dtos;

import java.util.List;

public class ProductResponceDto {
    private int page;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private boolean lastPage;
    private List<products> productsList;

    public ProductResponceDto(){}
    public ProductResponceDto(int page, int pageSize, int totalPages, long totalElements,boolean lastPage,List<products> productsList) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.lastPage = lastPage;
        this.productsList = productsList;
    }

    public static class products{
        private int id;
        private int MRP;
        private int currPrice;
        private int inventory;

        public products(){}
        public products(int id, int MRP, int currPrice, int inventory) {
            this.id = id;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public List<products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<products> productsList) {
        this.productsList = productsList;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }
}
