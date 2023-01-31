package com.zd.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompany;

	@NotNull
	private String nombre;

	private String telefono;

	private String email;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private Set<Store> stores = new HashSet<>();

	public void setStore(Set<Store> stores) {
		this.stores = stores;
		for (Store store : stores) {
			store.setCompany(this);
		}
	}
}
