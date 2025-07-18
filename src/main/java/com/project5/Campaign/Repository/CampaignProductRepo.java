package com.project5.Campaign.Repository;

import com.project5.Campaign.Model.CampaignProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CampaignProductRepo extends JpaRepository<CampaignProduct,Integer> {
    @Query(value = "select cp.* from campaign_product cp join campaign c on cp.campaign_id = c.campaignid where c.start_date = ?1",nativeQuery = true)
    List<CampaignProduct> findStartCampaign(LocalDate toDay);

    @Query(value = "select cp.* from campaign_product cp join campaign c on cp.campaign_id = c.campaignid where c.end_date = ?1",nativeQuery = true)
    List<CampaignProduct> findEndCampaign(LocalDate toDay);
}
