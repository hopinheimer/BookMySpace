package com.ohspaces.bookmyspace.service;

import com.ohspaces.bookmyspace.bo.ProductBo;
import com.ohspaces.bookmyspace.exception.BookSpaceException;
import com.ohspaces.bookmyspace.model.BookRequestModel;
import com.ohspaces.bookmyspace.model.BookingResponseModel;
import com.ohspaces.bookmyspace.model.CheckoutRequest;
import com.ohspaces.bookmyspace.model.CheckoutResponseModel;

import java.util.List;

public interface BookingService {

    List<ProductBo> getProduct() throws BookSpaceException;


    BookingResponseModel bookSeat(BookRequestModel request) throws BookSpaceException;

    CheckoutResponseModel checkoutBooking(CheckoutRequest request) throws BookSpaceException;
}
