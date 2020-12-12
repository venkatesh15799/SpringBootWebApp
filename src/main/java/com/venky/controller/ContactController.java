package com.venky.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.venky.constants.AppConstants;
import com.venky.entity.Contact;
import com.venky.props.AppProperties;
import com.venky.service.ContactService;


@Controller
public class ContactController {
	private static final Logger logger=LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private	ContactService contactService;
	@Autowired
	private	AppProperties appProps;
	
	
	@GetMapping("/loadForm")
	public String loadForm(Model model)
	{
		logger.info("*****Form loading started*******");
		model.addAttribute("contact", new Contact());
		logger.info("*****Form loading loaded successfully");
		return AppConstants.INDEX_VIEW;
	}
	@PostMapping("/saveContact")
	public String handlesSaveContactBtn(Contact contact,Model model,RedirectAttributes redirectAttributes)
	{
		logger.info("***Save contact is loaded****");
		Map<String, String> messages = appProps.getMessages();
		String text;
		if(contact.getContactId()==null){
			text=messages.get(AppConstants.SAVE_SUCCESS);
		}else{
			text=messages.get(AppConstants.UPDATE_SUCCESS);
		}
		
		boolean saveContact = contactService.saveContact(contact);
		if(saveContact)
		{
			redirectAttributes.addFlashAttribute(AppConstants.SUCC_MSG, text);
			logger.info("*****Save Contact is successfully executed*****");
		}
		else
		{
			redirectAttributes.addFlashAttribute(AppConstants.ERR_MSG,messages.get(AppConstants.FAIL_SUCCESS));
		}
		return "redirect:/loadForm";
	}
	
	@GetMapping("/viewContacts")
	public String getAllContacts(Model model)
	{
		logger.info("*******Loaded view all contacts ********");
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts",allContacts);
		logger.info("******Loaded successfully all contacts******");
		return "viewContacts";
	}
	@GetMapping("/editContact")
	public String handleEditClick(@RequestParam("cid") Integer cid,Model model)
	{
		logger.info("******Edit contact is loaded******");
		Contact contactObject = contactService.getContactById(cid);
		model.addAttribute("contact", contactObject);
		logger.info("****edit contact successfully loaded*****");
		return AppConstants.INDEX_VIEW;
	}
	@GetMapping("/deleteContact")
	public String handleDeleteClick(@RequestParam("cid") Integer cid)
	{
		logger.info("*****loaded delete contact method*****");
		contactService.daleteContactById(cid);
		logger.info("******delete contact successfully completed*******");
		return "redirect:/viewContacts";
	}
}
