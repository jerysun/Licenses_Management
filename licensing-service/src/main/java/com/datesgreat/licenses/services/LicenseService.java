package com.datesgreat.licenses.services;

import com.datesgreat.licenses.clients.OrganizationDiscoveryClient;
import com.datesgreat.licenses.clients.OrganizationFeignClient;
import com.datesgreat.licenses.clients.OrganizationRestTemplateClient;
import com.datesgreat.licenses.config.ServiceConfig;
import com.datesgreat.licenses.model.License;
import com.datesgreat.licenses.model.Organization;
import com.datesgreat.licenses.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseService {
	
	@Autowired
	private LicenseRepository licenseRepository;
	
	@Autowired
	ServiceConfig config;
	
	@Autowired
	OrganizationFeignClient organizationFeignClient;
	
	@Autowired
	OrganizationRestTemplateClient organizationRestClient;
	
	@Autowired
	OrganizationDiscoveryClient organizationDiscoveryClient;
	
	private Organization retrieveOrgInfo(String organizationId, String clientType) {
		Organization organization = null;
		
		switch (clientType) {
		case "feign":
			System.out.println("I am using the feign client");
			organization = organizationFeignClient.getOrganization(organizationId);
			break;
		case "rest":
			System.out.println("I am using the rest client");
			organization = organizationRestClient.getOrganization(organizationId);
			break;
		case "discovery":
			System.out.println("I am using the discovery client");
			organization = organizationDiscoveryClient.getOrganization(organizationId);
			break;
		default:
			organization = organizationRestClient.getOrganization(organizationId);
			break;
		}
		
		return organization;
	}
	
	public License getLicense(String organizationId, String licenseId, String clientType) {
		License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
		
		Organization org = retrieveOrgInfo(organizationId, clientType);
		
		return license
				.withOrganizationName( org.getName())
				.withContactName( org.getContactName())
				.withContactEmail( org.getContactEmail())
				.withContactPhone( org.getContactPhone())
				.withComment(config.getExampleProperty());
	}
	
	public List<License> getLicensesByOrg(String organizationId) {
		return licenseRepository.findByOrganizationId(organizationId);
	}
	
	public void saveLicense(License license) {
		license.withId(UUID.randomUUID().toString());
		licenseRepository.save(license);
		
	}
	
	public void updateLicense(License license) {
		licenseRepository.save(license);
	}

	public void deleteLicense(License license) {
		licenseRepository.delete(license);
	}
	
}