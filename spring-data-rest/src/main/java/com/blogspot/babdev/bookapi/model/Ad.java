package com.blogspot.babdev.bookapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ad")
public class Ad {
	


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

/*
		private String title;
	    private String heading;
	    private String contentType;
	    private Blob defaultImage;
	    private String defaultImageUrl;
	    private String price;
	    private String objectId;
	    private String url;
	    private Date createdAt;
	    private Date modifiedAt;
	    private Date publishedDate;
	    private Date expireDate;
	    private List<AdGroup> groups;
	    private List<AdPropertyLink> propertyLinks;
	    private String uniqueId;
	    private String defaultLogo;
	    private AdType type;
	    private BusinessEntity businessEntity;
	    private boolean active = true;
	    private boolean infoSend = false;
	    
	    */
}
