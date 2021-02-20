package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {

	@Id
    @Column(name = "add_id")
    private int add_id;
 
    @Column(name = "street")
    private String street;
    
    @Column(name = "dno")
    private String dno;
  
    //@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "address")
	//@OneToOne(targetEntity = Address.class)
    
    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="STUDENT_ADDRESS", joinColumns = @JoinColumn(name="add_id"),
    inverseJoinColumns = @JoinColumn(name="std_id"))
    */
    
    @OneToOne(mappedBy="address")
    private Student student;


	public int getAdd_id() {
		return add_id;
	}

	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
 
    
    
}
