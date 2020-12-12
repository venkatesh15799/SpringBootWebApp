package com.venky.service;

import java.util.List;

import com.venky.entity.Contact;

public interface ContactService {
	public  boolean saveContact(Contact contact);
	public List<Contact> getAllContacts();
	public Contact getContactById(Integer contactId);
	public boolean daleteContactById(Integer contactId);
}
