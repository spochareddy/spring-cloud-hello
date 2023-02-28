package com.sindalah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sindalah.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}