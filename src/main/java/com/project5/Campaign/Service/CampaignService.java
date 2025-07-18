package com.project5.Campaign.Service;

import com.project5.Campaign.Constant.ErrorCons;
import com.project5.Campaign.Constant.MessageCons;
import com.project5.Campaign.Dtos.*;
import com.project5.Campaign.Model.Campaign;
import com.project5.Campaign.Model.CampaignProduct;
import com.project5.Campaign.Model.PriceHistory;
import com.project5.Campaign.Model.Product;
import com.project5.Campaign.Repository.CampaignProductRepo;
import com.project5.Campaign.Repository.CampaignRepo;
import com.project5.Campaign.Repository.PriceHistoryRepo;
import com.project5.Campaign.Repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class CampaignService {

    @Autowired private ModelMapper modelMapper;
    @Autowired private CampaignRepo campaignRepo;
    @Autowired private CampaignProductRepo campaignProductRepo;
    @Autowired private PriceHistoryRepo priceHistoryRepo;
    @Autowired private ProductRepo productRepo;

    Logger logger = LoggerFactory.getLogger(CampaignService.class);

    public void makeCampaigns(CampaignRequestDTO req){
        Campaign campaign = modelMapper.map(req,Campaign.class);
        campaignRepo.save(campaign);
        logger.info(MessageCons.SAVED_CAMPAIGN);

        for (CampaignDiscountReqDTO disDto : req.getCampaignDiscountReqDTOS()) {
            Product product = productRepo.findById(disDto.getProductId()).orElseThrow(() -> new NoSuchElementException(ErrorCons.PRODUCT_NOT_FOUND + disDto.getProductId()));
            CampaignProduct campaignProduct = new CampaignProduct(product,campaign,disDto.getDiscount());

            campaignProductRepo.save(campaignProduct);
        }
        logger.info(MessageCons.CREATED_CAMPAIGN);
    }

    public void saveHistory(Integer productId,Integer currPrice,LocalDate toDay,String title){
        PriceHistory priceHistory = new PriceHistory(productId,currPrice,toDay,title);
        priceHistoryRepo.save(priceHistory);

        logger.info(MessageCons.SAVED_HISTORY);
    }
}
