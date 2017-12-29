package com.vs.os.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vs.os.model.Order;


@Api(value = "orderList", description = "the orderList API")
public interface OrderListApi {

    @ApiOperation(value = "Get List Of all oreders by e-mail id", notes = "Get List Of all placed orders", response = Order.class, tags={ "Order", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of all available vendors", response = Order.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Order.class) })
    @RequestMapping(value = "/orderList",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Order> orderListGet(@ApiParam(value = "Return all items for e-mail id", required = true) @RequestParam(value = "email", required = true) String email



);

}
