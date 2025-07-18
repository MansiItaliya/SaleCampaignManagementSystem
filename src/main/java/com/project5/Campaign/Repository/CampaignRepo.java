package com.project5.Campaign.Repository;

import com.project5.Campaign.Model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign,Integer> {

}
