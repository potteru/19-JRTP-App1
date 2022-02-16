package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.ContactForm;
import in.ashokit.entities.Contact;
import in.ashokit.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
	private ContactRepository contactrepo;//this service class will call Repository so we need this 

	@Override
	public String save(ContactForm form) {
		
		// we have received form binding object as parameter
		// Repository save(entity) method expecting entity object
		// So copy the data from form binding object to entity object
		
		Contact entity = new Contact();
		BeanUtils.copyProperties(form, entity);// to copy two objects they must pointing to same
		entity.setActiveSw("Yes");
		entity = contactrepo.save(entity);
		if(entity.getContactId() != null) {
			return "SUCCESS";
		}
		return "FAILURE";
	}

	@Override
	public List<ContactForm> viewContacts() {
		List<ContactForm> dataList = new ArrayList<>();
		
		List<Contact> findall= contactrepo.findAll();
		for(Contact entity : findall) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		
		Optional<Contact> findById = contactrepo.findById(contactId);
		if(findById.isPresent()) {
			Contact entity = findById.get();
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			return form;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		contactrepo.deleteById(contactId);
		
		// getting latest data from table and returning
		List<ContactForm> dataList = new ArrayList<>();
		List<Contact> findAll = contactrepo.findAll();
		for(Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}
}
