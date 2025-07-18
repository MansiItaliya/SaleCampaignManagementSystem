package com.project5.Campaign.Controller;

import com.project5.Campaign.Constant.MessageCons;
import com.project5.Campaign.Dtos.CampaignRequestDTO;
import com.project5.Campaign.Service.CampaignService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("campaignSys")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @PostMapping("campaigns")
    public ResponseEntity<String> campaigns(@Valid @RequestBody CampaignRequestDTO request) {
        campaignService.makeCampaigns(request);
        return new ResponseEntity<>(MessageCons.CREATED_CAMPAIGN, HttpStatus.CREATED);
    }

//    @GetMapping("start-campaign")
//    public ResponseEntity<String> startCampaign(){
//        applySchedular.startCampaign();
//        return new ResponseEntity<>(MessageCons.START,HttpStatus.OK);
//    }
//
//    @GetMapping("end-campaign")
//    public ResponseEntity<String> endCampaign(){
//        applySchedular.endCampaign();
//        return new ResponseEntity<>(MessageCons.END,HttpStatus.OK);
//    }
}
