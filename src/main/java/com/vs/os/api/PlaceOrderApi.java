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
