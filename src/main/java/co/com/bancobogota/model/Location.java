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

import java.io.Serializable;

@Data
@Entity
@Table( name = "location")
public class Location implements Serializable {

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
}
