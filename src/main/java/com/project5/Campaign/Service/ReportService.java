package com.project5.Campaign.Service;

import com.project5.Campaign.Constant.ErrorCons;
import com.project5.Campaign.Constant.MessageCons;
import com.project5.Campaign.Dtos.CampaignHistoryDto;
import com.project5.Campaign.Dtos.PriceHistoryDto;
import com.project5.Campaign.Model.Campaign;
import com.project5.Campaign.Model.PriceHistory;
import com.project5.Campaign.Repository.CampaignRepo;
import com.project5.Campaign.Repository.PriceHistoryRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

    @Autowired private CampaignRepo campaignRepo;
    @Autowired private PriceHistoryRepo priceHistoryRepo;
    @Autowired private ModelMapper modelMapper;

    public List<PriceHistoryDto> getAllPriceHistory(){
        logger.info(MessageCons.FETCH_HISTORY);
        List<PriceHistory> priceHistoryList = priceHistoryRepo.findAll();
        if(priceHistoryList.isEmpty()) throw new NoSuchElementException(ErrorCons.NOT_EXIST_PRICE_HISTORY);

        return priceHistoryList.stream()
                .map(priceHistory -> modelMapper.map(priceHistory,PriceHistoryDto.class))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CampaignHistoryDto> campaignHistoryInfo(){
        List<Campaign> campaignList = campaignRepo.findAll();

        if (campaignList.isEmpty()) {
            logger.error(ErrorCons.NO_CAMPAIGN_FOUND);
            throw new NoSuchElementException(ErrorCons.NO_CAMPAIGN_FOUND);
        }

        return campaignList.stream()
                .map(campaign -> this.mapCampaignToHistoryDtoWithStatus(campaign))
                .collect(Collectors.toUnmodifiableList());
    }

    private CampaignHistoryDto mapCampaignToHistoryDtoWithStatus(Campaign campaign){
        CampaignHistoryDto campaignHistoryDto = modelMapper.map(campaign,CampaignHistoryDto.class);

        LocalDate toDay = LocalDate.now();
        String status;
        if (toDay.isBefore(campaign.getStartDate())) {
            status = MessageCons.UPCOMING;
        } else if (toDay.isAfter(campaign.getEndDate())) {
            status = MessageCons.PAST;
        } else {
            status = MessageCons.PRESENT;
        }

        campaignHistoryDto.setStatus(status);
        return campaignHistoryDto;
    }
}
