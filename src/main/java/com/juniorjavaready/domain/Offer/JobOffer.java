package com.juniorjavaready.domain.Offer;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode

public class JobOffer {
    private int id;
    private String title;
    private String company;
    private String offerUrl;
    private String salary;
}
