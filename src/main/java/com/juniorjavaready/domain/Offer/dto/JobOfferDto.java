package com.juniorjavaready.domain.Offer.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class JobOfferDto {
    private String title;
    private String company;
    private String offerUrl;
    private String salary;
}
