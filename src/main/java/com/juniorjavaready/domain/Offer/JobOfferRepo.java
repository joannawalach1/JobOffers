package com.juniorjavaready.domain.Offer;

import java.util.List;
import java.util.Optional;

public interface JobOfferRepo {
    List<JobOffer> findAll();
    Optional<JobOffer> findById(Long id);
    JobOffer save(JobOffer jobOffer);
}
