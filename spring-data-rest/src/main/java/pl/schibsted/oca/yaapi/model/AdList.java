package pl.schibsted.oca.yaapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_AD_LIST")
public class AdList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_list_id")
    private Integer id;

    private String name;
    private Boolean active =  new Boolean(true);
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

}
