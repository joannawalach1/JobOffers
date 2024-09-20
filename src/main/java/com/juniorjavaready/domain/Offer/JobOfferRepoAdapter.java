package com.juniorjavaready.domain.Offer;

import java.util.List;
import java.util.Optional;

public class JobOfferRepoAdapter implements JobOfferRepo {
    @Override
    public List<JobOffer> findAll() {
        return List.of();
    }

    @Override
    public Optional<JobOffer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public JobOffer save(JobOffer jobOffer) {
        return null;
    }
}
