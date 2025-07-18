package com.project5.Campaign.Controller;

import com.project5.Campaign.Dtos.CampaignHistoryDto;
import com.project5.Campaign.Dtos.PriceHistoryDto;
import com.project5.Campaign.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("report")
public class ReportController{

    @Autowired private ReportService reportService;

    @GetMapping("price-history")
    public ResponseEntity<List<PriceHistoryDto>> getAllPriceHistory(){
        return new ResponseEntity<>(reportService.getAllPriceHistory(), HttpStatus.OK);
    }

    @GetMapping("campaign-history-info")
    public ResponseEntity<List<CampaignHistoryDto>> campaignHistoryInfo(){
        return new ResponseEntity<>(reportService.campaignHistoryInfo(),HttpStatus.OK);
    }
}
