package com.order.orderservice.Controller;

import com.google.gson.Gson;
import com.order.orderservice.dto.OrderDetailDto;
import com.order.orderservice.service.OrderDetailService;
import commonproject.model.order.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("services")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("/orderDetail")
    public OrderDetail save(@RequestBody OrderDetail orderDetail) {
         return orderDetailService.save(orderDetail);

//        OrderDetail newOrderDetail = orderDetailService.save(new Gson().fromJson(orderDetail, OrderDetail.class));
//        try {
//            return ResponseEntity.ok().body(newOrderDetail);
//        } catch (NullPointerException nullPointerException) {
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Menu ID does not exist.");
//        }

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
