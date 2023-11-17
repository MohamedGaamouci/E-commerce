package com.gmc_team.e_commerse_platform.Controllers.Api;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface Promotions {
    @PostMapping(value = "/ByeN_GetNfree/save" ,produces = MediaType.APPLICATION_JSON_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE)
    ByeN_GetNFreeDto saveByeN_GetNfree(@RequestBody ByeN_GetNFreeDto dto);

    @PostMapping(value = "/percentage_discount/save" ,produces = MediaType.APPLICATION_JSON_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE)
    Percentage_discountsDto savepercentage_discount(@RequestBody Percentage_discountsDto dto);

    @PostMapping(value = "/tiered_promotion/save" ,produces = MediaType.APPLICATION_JSON_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE)
    TieredPromotionDto savetiered_promotion(@RequestBody TieredPromotionDto dto);

    @PostMapping(value = "/free_shipping/save" ,produces = MediaType.APPLICATION_JSON_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE)
    FreeShippingPromotionDto savefree_shipping(@RequestBody FreeShippingPromotionDto dto);

    @PostMapping(value = "/gift_with_purchase/save" ,produces = MediaType.APPLICATION_JSON_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE)
    Gift_with_purchaseDto savegift_with_purchase(@RequestBody Gift_with_purchaseDto dto);

    @PostMapping(value = "/gift/save" ,produces = MediaType.APPLICATION_JSON_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE)
    GiftDto savegift(@RequestBody GiftDto dto);

    @PostMapping(value = "/order_discount/save" ,produces = MediaType.APPLICATION_JSON_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE)
    Order_discount_promotionDto saveorder_discount(@RequestBody Order_discount_promotionDto dto);

//
    @GetMapping(value = "/ByeN_GetNfree/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE )
    List<ByeN_GetNFreeDto> findAllByeN_GetNfree();

    @GetMapping(value = "/percentage_discount/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE )
    List<Percentage_discountsDto> findAllpercentage_discount();

    @GetMapping(value = "/tiered_promotion/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE )
    List<TieredPromotionDto> findAlltiered_promotion();

    @GetMapping(value = "/free_shipping/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE )
    List<FreeShippingPromotionDto> findAllfree_shipping();

    @GetMapping(value = "/gift_with_purchase/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE )
    List<Gift_with_purchaseDto> findAllgift_with_purchase();

    @GetMapping(value = "/gift/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE )
    List<GiftDto> findAllgift();

    @GetMapping(value = "/order_discount/findAll" ,produces = MediaType.APPLICATION_JSON_VALUE )
    List<Order_discount_promotionDto> findAllorder_discount();

//
    @DeleteMapping(value = "/ByeN_GetNfree/delete/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    void deleteByeN_GetNfree(@PathVariable("Id") Long Id);

    @DeleteMapping(value = "/percentage_discount/delete/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    void deletepercentage_discount(@PathVariable("Id") Long Id);

    @DeleteMapping(value = "/tiered_promotion/delete/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    void deletetiered_promotion(@PathVariable("Id") Long Id);

    @DeleteMapping(value = "/free_shipping/delete/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    void deletefree_shipping(@PathVariable("Id") Long Id);

    @DeleteMapping(value = "/gift_with_purchase/delete/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    void deletegift_with_purchase(@PathVariable("Id") Long Id);

    @DeleteMapping(value = "/gift/delete/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    void deletegift(@PathVariable("Id") Long Id);

    @DeleteMapping(value = "/order_discount/delete/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    void deleteorder_discount(@PathVariable("Id") Long Id);
//
    @GetMapping(value = "/ByeN_GetNfree/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    ByeN_GetNFreeDto findByeN_GetNfreeById(@PathVariable("Id") Long Id);

    @GetMapping(value = "/percentage_discount/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    Percentage_discountsDto findpercentage_discountById(@PathVariable("Id") Long Id);

    @GetMapping(value = "/tiered_promotion/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    TieredPromotionDto findtiered_promotionById(@PathVariable("Id") Long Id);

    @GetMapping(value = "/free_shipping/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    FreeShippingPromotionDto findfree_shippingById(@PathVariable("Id") Long Id);

    @GetMapping(value = "/gift_with_purchase/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    Gift_with_purchaseDto findgift_with_purchaseById(@PathVariable("Id") Long Id);

    @GetMapping(value = "/gift/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    GiftDto findgiftById(@PathVariable("Id") Long Id);

    @GetMapping(value = "/order_discount/findById/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    Order_discount_promotionDto findorder_discountById(@PathVariable("Id") Long Id);






}
