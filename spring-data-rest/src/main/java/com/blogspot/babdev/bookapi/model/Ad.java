package com.blogspot.babdev.bookapi.model;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_AD")
public class Ad {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_id", nullable = false)
    private Integer id;

    
   
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	private boolean active;
	private String price;
	private Date createdAt;
	private Date modifiedAt;
	private Date publishedDate;
	private Date expireDate;
	private String objectId;
	//private List<AdGroup> groups;
	private String heading;

	@Column(name = "heading", unique = false, nullable = true, length = 1000)
	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	 /**
     * Returns price using provided {@link Locale} for formatting.
     *
     * If there is any problem while formatting then original price set is being returned.
     *
     * @param locale the {@link Locale} for price formatting
     * @return String representation of price
     */
    // TODO find better but common place for formatting
    public String getPrice(final Locale locale) {
        String formattedPrice = null;
        if (price != null) {
            try {
                NumberFormat nf = NumberFormat.getNumberInstance(locale);
                String priceAfterReplace = price.replace(" ", "").replaceAll("\\xA0", "").replace(",-", "")
                        .replace("-", "");
                if (!priceAfterReplace.isEmpty()) {
                    formattedPrice = nf.format(Double.parseDouble(priceAfterReplace));
                }
            } catch (Exception e) {
//                if (LOGGER.isWarnEnabled()) {
//                    LOGGER.warn("Error while formatting price: " + price);
//                }
                formattedPrice = price;
            }
        }
        return formattedPrice;
    }

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "created", unique = false, nullable = true)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Column(name = "modified", unique = false, nullable = false)
	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Column(name = "published", nullable = true)
	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	@Column(name = "expire", nullable = false)
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	@Column(name = "objectId", unique = false, nullable = true, length = 40)
	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
/*
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    @JoinTable(name = "T_AD_GROUP_T_AD", joinColumns = { @JoinColumn(name = "ad_id") },
        inverseJoinColumns = { @JoinColumn(name = "ad_group_id") })
	public List<AdGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<AdGroup> groups) {
		this.groups = groups;
	}
	*/
	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


}
