package com.gmc_team.e_commerse_platform.models;

public enum Order_status {

    processing,//: The order is being processed and the items are being picked from the warehouse.
    fulfilled,//: The order has been fulfilled and the items have been packed for shipping.
    shipped,//: The order has been shipped and is on its way to the customer.
    delivered,//: The order has been delivered to the customer.
    canceled,//: The order has been canceled by the customer or the seller.
    on_hold,//: The order has been put on hold for some reason, such as if the customer's
    // payment is being verified or if the items they ordered are out of stock.
    returned //: The customer has returned the order.
}
