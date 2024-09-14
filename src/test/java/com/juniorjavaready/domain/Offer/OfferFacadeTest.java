package com.juniorjavaready.domain.Offer;

import lombok.RequiredArgsConstructor;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RequiredArgsConstructor
public class OfferFacadeTest {

    private final OfferFacade offerFacade = new OfferFacade();


    @Test
    public void shouldFindAllOffers() {
        String allOffers = offerFacade.findAllOffers();
        assertThat(allOffers).isEqualTo("success");
    }

    @Test
    public void shouldFindOfferById() {
        String offer = offerFacade.findOfferById(1);
        assertThat(offer).isEqualTo("success");
    }

    @Test
    public void shouldCreateOffer() {
        String offer = offerFacade.createOffer(1, "developer", "Solution", "http://linkedin.com");
        assertThat(offer).isEqualTo("success");
    }

    @Test
    public void shouldFetchAllOffersAndSaveAllIfNotExists() {
        String allOffers = offerFacade.findAllOffers();
        assertThat(allOffers).isEqualTo("success");
    }
}