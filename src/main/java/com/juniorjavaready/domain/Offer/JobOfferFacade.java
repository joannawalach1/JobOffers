package com.juniorjavaready.domain.Offer;

import com.juniorjavaready.infrastructure.http.JobOfferApiPort;
import com.juniorjavaready.infrastructure.http.JobOffersApiFetcher;

public class JobOfferFacade {
    private final JobOffersApiFetcher jobOfferApiAdapter;

    public JobOfferFacade(JobOffersApiFetcher jobOfferApiAdapter) {
        this.jobOfferApiAdapter = jobOfferApiAdapter;
    }


    public String findAllOffers() {
        return "success";
    }

    public String findOfferById(int id) {
        return "success";
    }

    public String createOffer(int i, String developer, String solution, String url) {
        return "success";
    }

    public String fetchAllOffersAndSaveAllIfNotExists() throws NoJobsFoundException {
        return jobOfferApiAdapter.fetchAllJobs().toString();
    }

}
