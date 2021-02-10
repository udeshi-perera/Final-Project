package com.order.orderservice.Controller;

import com.order.orderservice.dto.OrderDetailDto;
import com.order.orderservice.service.OrderDetailService;
import commonproject.model.order.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;


    @RequestMapping(value = "/orderDetail", method = RequestMethod.POST)
    public OrderDetail save(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.save(orderDetail);
    }

    @RequestMapping(value = "/orderDetail", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam(value = "id") int id) {
        try {
            orderDetailService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Order detail deleted successfully");
        } catch (NoSuchElementException noSuchElementException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order detail Id is not existing");
        }
    }

    @RequestMapping(value = "/orderDetail/{id}", method = RequestMethod.GET)
    public OrderDetailDto fetch(@PathVariable(value = "id") int id) {
        OrderDetailDto orderList = new OrderDetailDto();
        orderList.setOrderDetailList(orderDetailService.findByOrderId(id));
        return orderList;
    }

}
