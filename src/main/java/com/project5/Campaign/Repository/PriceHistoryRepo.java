package com.project5.Campaign.Repository;

import com.project5.Campaign.Model.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceHistoryRepo extends JpaRepository<PriceHistory,Integer> {
}
