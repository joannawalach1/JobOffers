package com.juniorjavaready.infrastructure.http;

import com.juniorjavaready.domain.Offer.JobOffer;
import com.juniorjavaready.domain.Offer.dto.JobOfferDto;

public class JobOfferMapper {

    public JobOffer toEntity(JobOfferDto jobOfferDto) {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setId(jobOffer.getId());
        jobOffer.setCompany(jobOfferDto.getCompany());
        jobOffer.setTitle(jobOfferDto.getTitle());
        jobOffer.setSalary(jobOfferDto.getSalary());
        jobOffer.setOfferUrl(jobOfferDto.getOfferUrl());
        return jobOffer;
    }

    public static JobOfferDto toDto(JobOffer jobOffer) {
        JobOfferDto jobOfferDto = new JobOfferDto();
        jobOfferDto.setCompany(jobOffer.getCompany());
        jobOfferDto.setTitle(jobOffer.getTitle());
        jobOfferDto.setSalary(jobOffer.getSalary());
        jobOfferDto.setOfferUrl(jobOffer.getOfferUrl());
        return jobOfferDto;
    }
}
