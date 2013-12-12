package com.blogspot.babdev.bookapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_AD_GROUP")
public class AdGroup {

	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_group_id", nullable = false)
    private Integer id;

    
    
    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
