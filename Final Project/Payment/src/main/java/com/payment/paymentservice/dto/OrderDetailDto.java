package com.payment.paymentservice.dto;

import commonproject.model.order.OrderDetail;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailDto {

    private List<OrderDetail> orderDetailList;
}
