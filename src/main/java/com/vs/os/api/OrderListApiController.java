package com.vs.os.api;

import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.vs.os.model.Order;




@Controller
public class OrderListApiController implements OrderListApi {

    public ResponseEntity<Order> orderListGet(@ApiParam(value = "Return all items for e-mail id", required = true) @RequestParam(value = "email", required = true) String email



) {
        // do some magic!
        return new ResponseEntity<Order>(HttpStatus.OK);
    }

}
