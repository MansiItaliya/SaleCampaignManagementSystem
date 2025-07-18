package com.project5.Campaign.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer campaignID;

    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;
    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private Set<CampaignProduct> campaignProductSet;

    public Campaign(){}
    public Campaign(LocalDate startDate, LocalDate endDate, String title) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
    }

    public Integer getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Integer campaignID) {
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

    public Set<CampaignProduct> getCampaignProductSet() {
        return campaignProductSet;
    }

    public void setCampaignProductSet(Set<CampaignProduct> campaignProductSet) {
        this.campaignProductSet = campaignProductSet;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(campaignID, campaign.campaignID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(campaignID);
    }
}
