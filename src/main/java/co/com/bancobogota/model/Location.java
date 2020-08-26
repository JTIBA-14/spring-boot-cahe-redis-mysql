package co.com.bancobogota.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table( name = "location")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "area_m2", nullable = false)
	private int area_m2;
	
	@ManyToOne
	@JoinColumn(name = "location_id", nullable = true)
	private Location location;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setArea_m2(int area_m2) {
		this.area_m2 = area_m2;
	}
	public int getArea_m2() {
		return this.area_m2;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocationId() {
		return this.location;
	}
}
