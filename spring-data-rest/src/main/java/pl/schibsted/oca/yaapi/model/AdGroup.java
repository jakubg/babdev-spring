package pl.schibsted.oca.yaapi.model;

import java.util.List;

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

import org.hibernate.annotations.Where;

@Entity
@Table(name = "T_AD_GROUP")
public class AdGroup {

	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_group_id", nullable = false)
    private Integer id;
    
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    
    @Column(name = "active", unique = false, nullable = true)
    private Boolean active = new Boolean(true);
    
    @ManyToMany(fetch = FetchType.LAZY)
    // TODO get rid of such filtering on entities
    @Where(clause = "active='1'")
    @JoinTable(name = "T_AD_GROUP_T_AD", joinColumns = { @JoinColumn(name = "ad_group_id") }, inverseJoinColumns = { @JoinColumn(name = "ad_id") })
    private List<Ad> ads;
    
    
	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
