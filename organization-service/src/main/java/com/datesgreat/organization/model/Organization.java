package com.datesgreat.organization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizations")
public class Organization {
	@Id
	@Column(name = "organization_id", nullable = false)
	String id;
	
	@Column(name = "name", nullable = false)
	String name;
	
	@Column(name = "contact_name", nullable = false)
	String contactname;
	
	@Column(name = "contact_email", nullable = false)
	String contactemail;
	
	@Column(name = "contact_phone", nullable = false)
	String contactphone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getContactemail() {
		return contactemail;
	}

	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}

	public String getContactphone() {
		return contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	
	

}
