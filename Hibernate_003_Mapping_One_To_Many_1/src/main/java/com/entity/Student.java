package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	@Id
    @Column(name = "std_id")
    private int std_id;
 
    @Column(name = "name")
    private String name;
    
    @Column(name = "user_email")
    private String user_email;
 
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="STUD_ADD", joinColumns = @JoinColumn(name="std_id"),
    inverseJoinColumns = @JoinColumn(name="add_id"))
    private Address address;

	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
 
    
    
}
