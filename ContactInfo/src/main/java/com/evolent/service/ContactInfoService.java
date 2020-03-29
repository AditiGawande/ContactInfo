package com.evolent.service;


import java.util.List;

import com.evolent.model.ContactInfo;

public interface ContactInfoService {

	 ContactInfo load(String costAssignmentId) ;
	
	 List<ContactInfo> loadAll() ;

	 ContactInfo save(ContactInfo costAssignment) ;
	
	 ContactInfo update(ContactInfo costAssignment,String costAssignmentId) ;
	
	 ContactInfo patchUpdate(ContactInfo costAssignment,String costAssignmentId) ;
	
	 Boolean delete(String costAssignmentId) ;
	 
	 List<ContactInfo> loadByPersonResponsible(String personResponsible) ;

}
