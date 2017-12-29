package com.vs.os.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vs.os.model.Order;


@Api(value = "placeOrder", description = "the placeOrder API")
public interface PlaceOrderApi {

    @ApiOperation(value = "Order An Item.", notes = "", response = Integer.class, tags={ "Order", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Product Created", response = Integer.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Integer.class) })
    @RequestMapping(value = "/placeOrder",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Integer> placeOrder(

@ApiParam(value = "Create aproduct"  ) @RequestBody Order body

);

}
