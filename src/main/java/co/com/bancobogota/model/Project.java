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
@Table( name = "projects")
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "priority", nullable = false)
	private int priority;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "deliverydate", nullable = false)
	private String deliveryDate;

}
