package com.zd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.entities.Company;
import com.zd.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Company> listar() {
		List<Company> company = companyRepository.findAll();
		return company;
	}

	@Override
	public Company guardar(Company company) {
		Company companyGuardada = companyRepository.save(company);
		return companyGuardada;
	}

	@Override
	public Company editar(Long id, Company company) {
		Optional<Company> companyOptional = companyRepository.findById(id);

		if (!companyOptional.isPresent()) {
			return null;
		}

		company.setIdCompany(companyOptional.get().getIdCompany());
		Company companyGuardar = companyRepository.save(company);
		return companyGuardar;
	}

	@Override
	public void eliminar(Long id) {
		companyRepository.deleteById(id);
	}

	@Override
	public Company obtenerPorId(Long id) {
		Company company = companyRepository.findById(id).orElse(null);
		return company;
	}

}
