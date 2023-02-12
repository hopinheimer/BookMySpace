package com.ohspaces.bookmyspace.resource;

import com.ohspaces.bookmyspace.bo.ProductBo;
import com.ohspaces.bookmyspace.exception.BookSpaceException;
import com.ohspaces.bookmyspace.model.BookRequestModel;
import com.ohspaces.bookmyspace.model.BookingResponseModel;
import com.ohspaces.bookmyspace.model.CheckoutRequest;
import com.ohspaces.bookmyspace.model.CheckoutResponseModel;
import com.ohspaces.bookmyspace.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Autowired
    private BookingService bookingService;

    @Override
    public List<ProductBo> getProducts() throws BookSpaceException {
        return bookingService.getProduct();
    }

    @Override
    public BookingResponseModel bookSeat(BookRequestModel request) throws BookSpaceException {
        return bookingService.bookSeat(request);
    }

    @Override
    public CheckoutResponseModel checkoutBooking(CheckoutRequest request) throws BookSpaceException {
        return bookingService.checkoutBooking(request);
    }
}
