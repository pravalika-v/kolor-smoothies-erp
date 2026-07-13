package com.kolorsmoothies.erp.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("auditorProvider")
public class AuditorAwareImpl implements AuditorAware<Long> {

	 @Override
	    public Optional<Long> getCurrentAuditor() {

	        Authentication authentication =
	                SecurityContextHolder.getContext().getAuthentication();

	        if (authentication == null
	                || !authentication.isAuthenticated()
	                || authentication instanceof AnonymousAuthenticationToken) {

	            return Optional.of(0L);   // SYSTEM
	        }

	        return Optional.of(1L);       // admin user
	    }
}