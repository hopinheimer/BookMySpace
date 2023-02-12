package com.ohspaces.bookmyspace.service;

import com.ohspaces.bookmyspace.bo.ProductBo;
import com.ohspaces.bookmyspace.dto.InvoiceDto;
import com.ohspaces.bookmyspace.entity.MembershipEntity;
import com.ohspaces.bookmyspace.entity.ProductEntity;
import com.ohspaces.bookmyspace.entity.TransactionEntity;
import com.ohspaces.bookmyspace.entity.UserEntity;
import com.ohspaces.bookmyspace.exception.BookSpaceException;
import com.ohspaces.bookmyspace.model.BookRequestModel;
import com.ohspaces.bookmyspace.model.BookingResponseModel;
import com.ohspaces.bookmyspace.model.CheckoutRequest;
import com.ohspaces.bookmyspace.model.CheckoutResponseModel;
import com.ohspaces.bookmyspace.repository.MembershipRepository;
import com.ohspaces.bookmyspace.repository.ProductRepository;
import com.ohspaces.bookmyspace.repository.TransactionRepository;
import com.ohspaces.bookmyspace.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public List<ProductBo> getProduct() throws BookSpaceException {
        List<ProductEntity> entities = productRepository.findAllByActive();
        return entityToBo(entities);
    }

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = {BookSpaceException.class})
    @Override
    public BookingResponseModel bookSeat(BookRequestModel request) throws BookSpaceException {

        Optional<MembershipEntity> membershipOptional = membershipRepository.getMembershipBydate(request.getStartDate(), request.getProductId());
        if (membershipOptional.isPresent()) {
            throw new BookSpaceException("BSE01", "Seat unavailable!!");
        }

        ProductEntity product = productRepository.findById(request.getProductId()).orElseThrow(() -> new BookSpaceException("BSE02", "product not found"));
        UserEntity user = userRepository.findById(request.getUserId()).orElseThrow(() -> new BookSpaceException("BSE03", "user not found"));
        membershipOptional = membershipRepository.getMembershipByUserId(request.getUserId());
        MembershipEntity membership = new MembershipEntity();
        if (membershipOptional.isPresent())
            membership = membershipOptional.get();

        membership.setProducts(product);
        membership.setUser(user);
        membership.setStartDate(Timestamp.valueOf(request.getStartDate()));
        membership.setEndDate(Timestamp.valueOf(request.getEndDate()));
        membership.setIsActive(false);

        membership = membershipRepository.save(membership);

        BookingResponseModel res = new BookingResponseModel();
        InvoiceDto invoice = getInvoice(membership);
        res.setMemId(membership.getMemId());
        res.setTax(invoice.getTax());
        res.setServiceTax(invoice.getServiceTax());
        res.setTotalAmount(invoice.getTotalAmount());
        res.setAmount(product.getPrice());

        return res;
    }

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = {BookSpaceException.class})
    @Override
    public CheckoutResponseModel checkoutBooking(CheckoutRequest request) throws BookSpaceException {
        MembershipEntity membership = membershipRepository.findById(request.getMemId()).orElseThrow(() -> new BookSpaceException("BSE14", "invalid membership id"));

        TransactionEntity txn = new TransactionEntity();

        txn.setMembership(membership);
        txn.setAmount(getInvoice(membership).getTotalAmount());
        txn.setTxnRefId("23mfspsdkfsd");//TODO: generated unique id


        //TODO: full protocol to procceed with transaction
        membership.setIsActive(Boolean.TRUE);
        membershipRepository.save(membership);

        return null;
    }

    private InvoiceDto getInvoice(MembershipEntity membership) throws BookSpaceException {
        Duration duration = Duration.between(membership.getStartDate().toInstant(), membership.getEndDate().toInstant());
        long requestDays = duration.toDays();
        double Amount = membership.getProducts().getPrice() * (requestDays / 30.0);
        InvoiceDto invoice = new InvoiceDto();
        invoice.setServiceTax(Amount * 0.02);
        invoice.setTax(Amount * 0.18);
        invoice.setTotalAmount(Amount + invoice.getTax() + invoice.getServiceTax());
        return invoice;
    }

    private ProductBo entityToBo(ProductEntity entity) {
        ProductBo bo = new ProductBo();
        bo.setFloor(entity.getFloor());
        bo.setPrice(entity.getPrice());
        bo.setIsActive(entity.getIsActive());
        bo.setSeatNumber(entity.getSeatNumber());
        bo.setShift(entity.getShift());
        bo.setProductid(entity.getProductId());

        return bo;
    }

    private List<ProductBo> entityToBo(List<ProductEntity> entities) {
        return entities.stream().map(this::entityToBo).collect(Collectors.toList());
    }
}
