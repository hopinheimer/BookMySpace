package com.ohspaces.bookmyspace.resource;

import com.ohspaces.bookmyspace.bo.ProductBo;
import com.ohspaces.bookmyspace.exception.BookSpaceException;
import com.ohspaces.bookmyspace.model.BookRequestModel;
import com.ohspaces.bookmyspace.model.BookingResponseModel;
import com.ohspaces.bookmyspace.model.CheckoutRequest;
import com.ohspaces.bookmyspace.model.CheckoutResponseModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path ={"/com/ohspaces"})
public interface BookingResource {

    @GetMapping(path ={"/product"},produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody List<ProductBo> getProducts() throws BookSpaceException;

    @PostMapping(path = {"/book"},consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody BookingResponseModel bookSeat(@RequestBody BookRequestModel request) throws BookSpaceException;

    @PostMapping(path ={"/checkout"},consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody CheckoutResponseModel checkoutBooking(@RequestBody CheckoutRequest request) throws BookSpaceException;
}
