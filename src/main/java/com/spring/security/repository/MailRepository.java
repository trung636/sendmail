package com.spring.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.Mail;

@Repository
public interface MailRepository extends JpaRepository<Mail, Integer> {


}
