package com.juniorjavaready.domain.Offer;

import lombok.*;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class JobOfferResponse {
        private String position;
        private String company;
        private String salary;
        private String snippet;
        private String link;
        private String source;
    }

