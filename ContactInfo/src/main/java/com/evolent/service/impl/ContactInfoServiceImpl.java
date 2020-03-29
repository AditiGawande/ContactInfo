package com.evolent.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolent.common.RecordNotFoundException;
import com.evolent.model.ContactInfo;
import com.evolent.repository.ContactInfoRepository;
import com.evolent.service.ContactInfoService;

@Service
@Transactional
public class ContactInfoServiceImpl implements ContactInfoService {

	private static final String COST_ASSIGNMENT_ID = "costAssignmentId";
	@Autowired
	ContactInfoRepository costAssignmentRepository;

	@Override
	public ContactInfo load(String costAssignmentId) {
		Optional<ContactInfo> entityOpt = costAssignmentRepository.findById(costAssignmentId);
		if(entityOpt.isPresent()) {
			ContactInfo costAssignmentEntity = entityOpt.get();
	
			if (costAssignmentEntity == null) {
				throw new RecordNotFoundException(COST_ASSIGNMENT_ID);
			}
			return costAssignmentEntity;
		}
		return null;
	}

	@Override
	public ContactInfo save(ContactInfo costAssignment) {
		return costAssignmentRepository.save(costAssignment);
	}
	
	@Override
	public List<ContactInfo> loadAll() {
		return costAssignmentRepository.findAll();
	}

	@Override
	public ContactInfo update(ContactInfo costAssignment, String costAssignmentId) {
		Optional<ContactInfo> entityOpt = costAssignmentRepository.findById(costAssignmentId);
		if(entityOpt.isPresent()) {
			ContactInfo  costAssignmentEntity = entityOpt.get();
				if (costAssignmentEntity == null) {
					throw new RecordNotFoundException(COST_ASSIGNMENT_ID);
				}
				costAssignmentEntity.setName(costAssignment.getName());
				costAssignmentEntity.setCode(costAssignment.getCode());
				costAssignmentEntity.setDescription(costAssignment.getDescription());
				costAssignmentEntity.setPersonResponsible(costAssignment.getPersonResponsible());
				costAssignmentEntity.setResponsibleCostCenter(costAssignment.getResponsibleCostCenter());
				costAssignmentEntity.setAccountCategory(costAssignment.getAccountCategory());
				costAssignmentEntity.setActualPostedCostCenter(costAssignment.getActualPostedCostCenter());
				costAssignmentEntity.setCurrency(costAssignment.getCurrency());
				costAssignmentEntity.setRemoteSystem(costAssignment.getRemoteSystem());
				
				costAssignmentEntity.setStartDate(costAssignment.getStartDate());
				costAssignmentEntity.setEndDate(costAssignment.getEndDate());
				
				return costAssignmentRepository.save(costAssignmentEntity);
		}
		return null;
	}

	@Override
	public ContactInfo patchUpdate(ContactInfo costAssignment, String costAssignmentId) {
		Optional<ContactInfo> entityOpt = costAssignmentRepository.findById(costAssignmentId);
		
		if(entityOpt.isPresent()){
			ContactInfo costAssignmentEntity = entityOpt.get();
				if (costAssignmentEntity == null) {
					throw new RecordNotFoundException(COST_ASSIGNMENT_ID);
				}
				setCostAssignmentDetails(costAssignment, costAssignmentEntity);
				return costAssignmentRepository.save(costAssignmentEntity);
		}
		return null;
	}

	private void setCostAssignmentDetails(ContactInfo costAssignment, ContactInfo costAssignmentEntity) {
		if (null != costAssignment.getName()) {
			costAssignmentEntity.setName(costAssignment.getName());
		}
		if (null != costAssignment.getCode()) {
			costAssignmentEntity.setCode(costAssignment.getCode());
		}
		if (null != costAssignment.getDescription()) {
			costAssignmentEntity.setDescription(costAssignment.getDescription());
		}
		if (null != costAssignment.getPersonResponsible()) {
			costAssignmentEntity.setPersonResponsible(costAssignment.getPersonResponsible());
		}
		if (null !=costAssignment.getResponsibleCostCenter()) {
			costAssignmentEntity.setResponsibleCostCenter(costAssignment.getResponsibleCostCenter());
		}
		if (null != costAssignment.getAccountCategory()) {
			costAssignmentEntity.setAccountCategory(costAssignment.getAccountCategory());
		}
		if (null != costAssignment.getActualPostedCostCenter()) {
			costAssignmentEntity.setActualPostedCostCenter(costAssignment.getActualPostedCostCenter());
		}
		if (null != costAssignment.getCurrency()) {
			costAssignmentEntity.setCurrency(costAssignment.getCurrency());
		}
		if (null != costAssignment.getRemoteSystem()) {
			costAssignmentEntity.setRemoteSystem(costAssignment.getRemoteSystem());
		}
		if (null != costAssignment.getStartDate()) {
			costAssignmentEntity.setStartDate(costAssignment.getStartDate());
		}
		if (null != costAssignment.getEndDate()) {
			costAssignmentEntity.setEndDate(costAssignment.getEndDate());
		}
	}

	
	@Override
	public Boolean delete(String costAssignmentId) {
		Optional<ContactInfo> entityOpt = costAssignmentRepository.findById(costAssignmentId);
		if(entityOpt.isPresent()) {
			ContactInfo costAssignmentEntity = entityOpt.get();
				if (costAssignmentEntity == null) {
					throw new RecordNotFoundException(COST_ASSIGNMENT_ID);
				}
		
				costAssignmentRepository.delete(costAssignmentEntity);
				return true;
		}
		return false;
	}

	@Override
	public List<ContactInfo> loadByPersonResponsible(String personResponsible) {
		return costAssignmentRepository.findByPersonResponsible(personResponsible);
	}
}
