package com.example.form.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class AddBookResources {

	ConcurrentHashMap contacts = new ConcurrentHashMap<Integer, Contact>();

	@GetMapping("/{id}")
	@ApiOperation(value="Finds contants by id",
	                notes="provide an id to look up specific contact from the address book",
	                response=Contact.class)
	public Contact getContact(@PathVariable String id) {

		return (Contact) contacts.get(id);

	}

	@GetMapping("/")
	public List<Contact> getAllContact() {
		return new ArrayList<Contact>(contacts.values());

	}

	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact) {
		contacts.put(contact.getId(), contact);
		return contact;

	}
}