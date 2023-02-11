package com.ohspaces.bookmyspace.dto;

import lombok.Data;

@Data
public class InvoiceDto  {
    private Double serviceTax;

    private Double tax;

    private Double totalAmount;
}
