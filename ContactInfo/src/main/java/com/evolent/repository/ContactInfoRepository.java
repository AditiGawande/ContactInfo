package com.evolent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evolent.model.ContactInfo;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, String>{

	List<ContactInfo> findByPersonResponsible(String personResponsible) ;

}
