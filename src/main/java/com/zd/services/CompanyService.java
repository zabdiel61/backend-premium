package com.zd.services;

import java.util.List;

import com.zd.entities.Company;

public interface CompanyService {
	
	public List<Company> listar();
	
	public Company obtenerPorId(Long id);

	public Company guardar(Company company);

	public Company editar(Long id, Company company);

	public void eliminar(Long id);

}
