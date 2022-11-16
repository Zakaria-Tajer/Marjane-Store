package Marj.Controller;

import Marj.Model.Promotions.Promotions;
import entity.PromotionsEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class PromotionsController {

    Promotions promotions = new Promotions();

    public List<PromotionsEntity> getAllPromotions() {
        return promotions.getPromotions();
    }

    public void generateAPromotions(int reduction, int centerId, int stock, int category, String unique_id, String status, LocalDate expirationDate) {
        promotions.makeAPromotions(reduction, centerId, stock, category, unique_id, status,expirationDate);
    }

    public String updatePromotionsByManager(int promotionId, String status){
        return promotions.updatePromotionsById(promotionId, status);
    }

    public List<PromotionsEntity> getAllPromotionsByStatus(){
        return promotions.getPromotionsWithStatusWait();
    }


}
