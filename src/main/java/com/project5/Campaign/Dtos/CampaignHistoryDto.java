package com.project5.Campaign.Dtos;

import java.time.LocalDate;

public class CampaignHistoryDto {
    private int campaignID;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private String status;

    public CampaignHistoryDto(){}
    public CampaignHistoryDto(int campaignID, LocalDate startDate, LocalDate endDate, String title, String status) {
        this.campaignID = campaignID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.status = status;
    }

    public int getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(int campaignID) {
        this.campaignID = campaignID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
