package com.vs.os.api;

import io.swagger.annotations.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.vs.os.model.Error;
import com.vs.os.model.Order;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-17T10:01:03.258Z")

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
