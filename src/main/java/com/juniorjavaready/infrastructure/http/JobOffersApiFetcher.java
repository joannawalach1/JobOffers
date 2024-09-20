package com.juniorjavaready.infrastructure.http;

import com.juniorjavaready.domain.Offer.JobOffer;
import com.juniorjavaready.domain.Offer.NoJobsFoundException;
import com.juniorjavaready.domain.Offer.dto.JobOfferDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class JobOffersApiFetcher {

    private static final Logger logger = Logger.getLogger(JobOffersApiFetcher.class.getName());
    private final WebClient webClient;

    public JobOffersApiFetcher(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<JobOfferDto> fetchAllJobs() throws NoJobsFoundException {
        try {
            List<JobOffer> jobOffers = Optional.ofNullable(
                    webClient.get()
                            .uri("http://ec2-3-120-147-150.eu-central-1.compute.amazonaws.com:5057/offers")
                            .retrieve()
                            .bodyToFlux(JobOffer.class)
                            .collectList()
                            .block()
            ).orElseThrow(() -> new NoJobsFoundException("No job offers found from the API."));

            if (jobOffers.isEmpty()) {
                throw new NoJobsFoundException("No job offers found from the API.");
            }

            logger.info("Pobrano " + jobOffers.size() + " ofert(y) pracy: " + jobOffers);

            return jobOffers.stream()
                    .map(JobOfferMapper::toDto)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            logger.severe("Wystąpił błąd podczas pobierania ofert pracy: " + e.getMessage());
            throw new NoJobsFoundException("Błąd podczas pobierania ofert pracy z API: " + e.getMessage());
        }
    }
}

