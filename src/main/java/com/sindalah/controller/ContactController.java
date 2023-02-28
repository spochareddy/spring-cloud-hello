package com.sindalah.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sindalah.entity.Contact;
import com.sindalah.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping({ "/api/v1/contacts" })
@Slf4j
public class ContactController {

	private ContactRepository repository;

	ContactController(ContactRepository contactRepository) {
		this.repository = contactRepository;
	}

	@GetMapping
	public List<Contact> findAll() {
		List<Contact> list = repository.findAll();
		log.info("Contact list Size ::" + list.size());
		return list;
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Contact> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
}
