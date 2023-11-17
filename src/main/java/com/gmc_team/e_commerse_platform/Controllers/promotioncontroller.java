package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Promotions;
import com.gmc_team.e_commerse_platform.Dto.promotion_types.*;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Promotion_typeImpl.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/promotions")
public class promotioncontroller implements Promotions {
    private final ByeN_GetNFreeServiceImpl byeN_GetNFreeServiceImpl;
    private final Percentage_discountsServiceImpl percentage_discountsServiceImpl;
    private final TieredPromotionServiceImpl tieredPromotionServiceImpl;
    private final FreeShippingPromotionServiceImpl freeShippingPromotionServiceImpl;
    private final GiftServiceImpl giftServiceImpl;
    private final Gift_with_purchaseServiceImpl gift_with_purchaseServiceImpl;
    private final Order_discount_promotionServiceImpl order_discount_promotionServiceImpl;

    public promotioncontroller(ByeN_GetNFreeServiceImpl byeN_GetNFreeServiceImpl, Percentage_discountsServiceImpl percentage_discountsServiceImpl, TieredPromotionServiceImpl tieredPromotionServiceImpl, FreeShippingPromotionServiceImpl freeShippingPromotionServiceImpl, GiftServiceImpl giftServiceImpl, Gift_with_purchaseServiceImpl gift_with_purchaseServiceImpl, Order_discount_promotionServiceImpl order_discount_promotionServiceImpl) {
        this.byeN_GetNFreeServiceImpl = byeN_GetNFreeServiceImpl;
        this.percentage_discountsServiceImpl = percentage_discountsServiceImpl;
        this.tieredPromotionServiceImpl = tieredPromotionServiceImpl;
        this.freeShippingPromotionServiceImpl = freeShippingPromotionServiceImpl;
        this.giftServiceImpl = giftServiceImpl;
        this.gift_with_purchaseServiceImpl = gift_with_purchaseServiceImpl;
        this.order_discount_promotionServiceImpl = order_discount_promotionServiceImpl;
    }

    @Override
    public ByeN_GetNFreeDto saveByeN_GetNfree(ByeN_GetNFreeDto dto) {
        return byeN_GetNFreeServiceImpl.save(dto);
    }

    @Override
    public Percentage_discountsDto savepercentage_discount(Percentage_discountsDto dto) {
        return percentage_discountsServiceImpl.save(dto);
    }

    @Override
    public TieredPromotionDto savetiered_promotion(TieredPromotionDto dto) {
        return tieredPromotionServiceImpl.save(dto);
    }

    @Override
    public FreeShippingPromotionDto savefree_shipping(FreeShippingPromotionDto dto) {
        return freeShippingPromotionServiceImpl.save(dto);
    }

    @Override
    public Gift_with_purchaseDto savegift_with_purchase(Gift_with_purchaseDto dto) {
        return gift_with_purchaseServiceImpl.save(dto);
    }

    @Override
    public GiftDto savegift(GiftDto dto) {
        return giftServiceImpl.save(dto);
    }

    @Override
    public Order_discount_promotionDto saveorder_discount(Order_discount_promotionDto dto) {
        return order_discount_promotionServiceImpl.save(dto);
    }

    @Override
    public List<ByeN_GetNFreeDto> findAllByeN_GetNfree() {
        return byeN_GetNFreeServiceImpl.findAll();
    }

    @Override
    public List<Percentage_discountsDto> findAllpercentage_discount() {
        return percentage_discountsServiceImpl.findAll();
    }

    @Override
    public List<TieredPromotionDto> findAlltiered_promotion() {
        return tieredPromotionServiceImpl.findAll();
    }

    @Override
    public List<FreeShippingPromotionDto> findAllfree_shipping() {
        return freeShippingPromotionServiceImpl.findAll();
    }

    @Override
    public List<Gift_with_purchaseDto> findAllgift_with_purchase() {
        return gift_with_purchaseServiceImpl.findAll();
    }

    @Override
    public List<GiftDto> findAllgift() {
        return giftServiceImpl.findAll();
    }

    @Override
    public List<Order_discount_promotionDto> findAllorder_discount() {
        return order_discount_promotionServiceImpl.findAll();
    }

    @Override
    public void deleteByeN_GetNfree(Long Id) {
        byeN_GetNFreeServiceImpl.delete(Id);
    }

    @Override
    public void deletepercentage_discount(Long Id) {
        percentage_discountsServiceImpl.delete(Id);
    }

    @Override
    public void deletetiered_promotion(Long Id) {
        tieredPromotionServiceImpl.delete(Id);
    }

    @Override
    public void deletefree_shipping(Long Id) {
        freeShippingPromotionServiceImpl.delete(Id);
    }

    @Override
    public void deletegift_with_purchase(Long Id) {
        gift_with_purchaseServiceImpl.delete(Id);
    }

    @Override
    public void deletegift(Long Id) {
        giftServiceImpl.delete(Id);
    }

    @Override
    public void deleteorder_discount(Long Id) {
        order_discount_promotionServiceImpl.delete(Id);
    }

    @Override
    public ByeN_GetNFreeDto findByeN_GetNfreeById(Long Id) {
        return byeN_GetNFreeServiceImpl.findById(Id);
    }

    @Override
    public Percentage_discountsDto findpercentage_discountById(Long Id) {
        return percentage_discountsServiceImpl.findById(Id);
    }

    @Override
    public TieredPromotionDto findtiered_promotionById(Long Id) {
        return tieredPromotionServiceImpl.findById(Id);
    }

    @Override
    public FreeShippingPromotionDto findfree_shippingById(Long Id) {
        return freeShippingPromotionServiceImpl.findById(Id);
    }

    @Override
    public Gift_with_purchaseDto findgift_with_purchaseById(Long Id) {
        return gift_with_purchaseServiceImpl.findById(Id);
    }

    @Override
    public GiftDto findgiftById(Long Id) {
        return giftServiceImpl.findById(Id);
    }

    @Override
    public Order_discount_promotionDto findorder_discountById(Long Id) {
        return order_discount_promotionServiceImpl.findById(Id);
    }
}
