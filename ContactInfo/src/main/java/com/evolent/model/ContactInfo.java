package com.evolent.model;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "cost_assignment")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContactInfo {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String costAssignmentId;
	
	private String code;
	private String name;
	private String description;
	private String personResponsible;
	private String responsibleCostCenter;
	private String actualPostedCostCenter;
	private String currency;
	private String accountCategory;
	
	private Timestamp startDate;
	private Timestamp endDate;
	private String remoteSystem;
	
	public ContactInfo() {
		
	}
	
	public String getCostAssignmentId() {
		return costAssignmentId;
	}
	public void setCostAssignmentId(String costAssignmentId) {
		this.costAssignmentId = costAssignmentId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPersonResponsible() {
		return personResponsible;
	}
	public void setPersonResponsible(String personResponsible) {
		this.personResponsible = personResponsible;
	}
	public String getResponsibleCostCenter() {
		return responsibleCostCenter;
	}
	public void setResponsibleCostCenter(String responsibleCostCenter) {
		this.responsibleCostCenter = responsibleCostCenter;
	}
	public String getActualPostedCostCenter() {
		return actualPostedCostCenter;
	}
	public void setActualPostedCostCenter(String actualPostedCostCenter) {
		this.actualPostedCostCenter = actualPostedCostCenter;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAccountCategory() {
		return accountCategory;
	}
	public void setAccountCategory(String accountCategory) {
		this.accountCategory = accountCategory;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public String getRemoteSystem() {
		return remoteSystem;
	}
	public void setRemoteSystem(String remoteSystem) {
		this.remoteSystem = remoteSystem;
	}
	
	
}
