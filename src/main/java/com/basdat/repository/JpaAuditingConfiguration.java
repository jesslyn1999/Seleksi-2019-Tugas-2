package com.basdat.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableJpaAuditing
public class JpaAuditingConfiguration {
    //
    //@Bean
    //public AuditorAware<String> auditorProvider() {
    //
    //    /*
    //      if you are using spring security, you can get the currently logged username with following code segment.
    //      SecurityContextHolder.getContext().getAuthentication().getName()
    //     */
    //    return () -> Optional.ofNullable("chathuranga");
    //}
}