package com.project5.Campaign.SchedularTasks;

import com.project5.Campaign.Constant.ErrorCons;
import com.project5.Campaign.Constant.MessageCons;
import com.project5.Campaign.Model.CampaignProduct;
import com.project5.Campaign.Model.Product;
import com.project5.Campaign.Repository.CampaignProductRepo;
import com.project5.Campaign.Repository.ProductRepo;
import com.project5.Campaign.Service.CampaignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@EnableScheduling
@Component
public class ApplySchedular {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired private ProductRepo productRepo;
    @Autowired private CampaignProductRepo campaignProductRepo;
    @Autowired private CampaignService campaignService;

    @Scheduled(cron = "0 0 0 * * *")
    public void startCampaign(){
        logger.info(MessageCons.START);
        LocalDate toDay = LocalDate.now();
        List<CampaignProduct> campaignProducts = campaignProductRepo.findStartCampaign(toDay);

        if (campaignProducts.isEmpty()) {
            logger.info(ErrorCons.NO_CAMPAIGN_FOUND, toDay);
            throw new NoSuchElementException(ErrorCons.NO_CAMPAIGN_FOR_TODAY);
        }

        for (CampaignProduct campaignProduct : campaignProducts) {
            Product product = campaignProduct.getProduct();
            int currPrice = product.getCurrPrice();
            int discount = campaignProduct.getDiscount();
            int changePrice = currPrice - (currPrice * discount / 100);

            product.setCurrPrice(changePrice);
            productRepo.save(product);
            //save the price History
            campaignService.saveHistory(product.getId(), product.getCurrPrice(), toDay, campaignProduct.getCampaign().getTitle());
        }
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void endCampaign(){
        logger.info(MessageCons.END);

        LocalDate toDay = LocalDate.now();
        List<CampaignProduct> campaignProducts = campaignProductRepo.findEndCampaign(toDay);

        if (campaignProducts.isEmpty()) {
            logger.info(ErrorCons.NO_CAMPAIGN_FOUND, toDay);
            throw new NoSuchElementException(ErrorCons.NO_CAMPAIGN_FOR_TODAY);
        }

        for (CampaignProduct campaignProduct : campaignProducts) {
            Product product = campaignProduct.getProduct();
            int currPrice = product.getCurrPrice();
            int discount = campaignProduct.getDiscount();
            int changePrice = currPrice + (currPrice * discount / 100);

            product.setCurrPrice(changePrice);
            productRepo.save(product);

            //save the price History
            campaignService.saveHistory(product.getId(), product.getCurrPrice(), toDay, campaignProduct.getCampaign().getTitle());
        }
    }
}
