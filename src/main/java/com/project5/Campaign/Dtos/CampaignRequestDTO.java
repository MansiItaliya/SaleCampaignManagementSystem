package com.project5.Campaign.Dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;

public class CampaignRequestDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate endDate;
    @NotNull
    private String title;
    private Set<CampaignDiscountReqDTO> campaignDiscountReqDTOS;

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

    public Set<CampaignDiscountReqDTO> getCampaignDiscountReqDTOS() {
        return campaignDiscountReqDTOS;
    }

    public void setCampaignDiscountReqDTOS(Set<CampaignDiscountReqDTO> campaignDiscountReqDTOS) {
        this.campaignDiscountReqDTOS = campaignDiscountReqDTOS;
    }
}
