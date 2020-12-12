package com.venky.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.venky.entity.Contact;
import com.venky.repository.ContactRepository;
@Service
public class ContactSrviceImpl implements ContactService {
	@Autowired
	ContactRepository contactRepo;
	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSw("Y");
		Contact savedObj1= contactRepo.save(contact);
		return savedObj1.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepo.findByActiveSw("Y");
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);
			if(findById.isPresent())
			{
				return findById.get();
			}
		return null;		
	}

	@Override
	public boolean daleteContactById(Integer contactId) {
		try {
			Optional<Contact> findById = contactRepo.findById(contactId);
			if(findById.isPresent())
			{
				Contact contact=findById.get();
				contact.setActiveSw("N");
				contactRepo.save(contact);
				return true;
			}
		}
		catch(Exception e)
		{
			return false;
		}
		return false;
	}

}
