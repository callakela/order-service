package com.vs.os.api;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.vs.os.model.Error;
import com.vs.os.model.Order;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-17T10:01:03.258Z")

@Controller
public class OrderListApiController implements OrderListApi {

    public ResponseEntity<Order> orderListGet(@ApiParam(value = "Return all items for e-mail id", required = true) @RequestParam(value = "email", required = true) String email



) {
        // do some magic!
        return new ResponseEntity<Order>(HttpStatus.OK);
    }

}
