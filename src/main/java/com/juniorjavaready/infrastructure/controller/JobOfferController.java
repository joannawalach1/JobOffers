package com.juniorjavaready.infrastructure.controller;

import com.juniorjavaready.domain.Offer.JobOffer;
import com.juniorjavaready.domain.Offer.NoJobsFoundException;
import com.juniorjavaready.domain.Offer.dto.JobOfferDto;
import com.juniorjavaready.infrastructure.http.JobOfferMapper;
import com.juniorjavaready.infrastructure.http.JobOffersApiFetcher;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobOfferController {

    private static final Logger logger = LoggerFactory.getLogger(JobOfferController.class);

    private final JobOffersApiFetcher jobOffersApiFetcher;

    public JobOfferController(JobOffersApiFetcher jobOffersApiFetcher) {
        this.jobOffersApiFetcher = jobOffersApiFetcher;
    }

    @GetMapping("/fetchOffers")
    public ResponseEntity<List<JobOfferDto>> getAllJobOffers() throws NoJobsFoundException {
        try {
            List<JobOfferDto> jobOffers = jobOffersApiFetcher.fetchAllJobs();
            logger.info("Successfully fetched {} job offers", jobOffers.size());
            return ResponseEntity.ok(jobOffers);
        } catch (NoJobsFoundException e) {
            logger.error("No job offers found: {}", e.getMessage());
            throw e;
        }
    }

    @ExceptionHandler(NoJobsFoundException.class)
    public ResponseEntity<String> handleNoJobsFound(NoJobsFoundException e) {
        return ResponseEntity.status(404).body("No job offers available at the moment.");
    }
}
