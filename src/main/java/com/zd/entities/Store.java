package com.zd.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity
@Data
@Table(name = "store", uniqueConstraints = { @UniqueConstraint(columnNames = { "nombre" }) })
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStore;

	@NotNull
	private String nombre;

	private String telefono;

	private String email;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_company")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Company company;
}
