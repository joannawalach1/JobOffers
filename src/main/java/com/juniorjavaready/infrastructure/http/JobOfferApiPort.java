package com.juniorjavaready.infrastructure.http;

import com.juniorjavaready.domain.Offer.JobOffer;
import com.juniorjavaready.domain.Offer.NoJobsFoundException;

import java.util.List;

public interface JobOfferApiPort {
    List<JobOffer> fetchAllJobs() throws NoJobsFoundException;
}
