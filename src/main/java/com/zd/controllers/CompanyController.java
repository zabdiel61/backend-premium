package com.zd.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zd.entities.Company;
import com.zd.services.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping("/")
	public ResponseEntity<List<Company>> listarCompanys() {
		List<Company> companys = companyService.listar();
		return ResponseEntity.ok(companys);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> obtenerCompanyPorId(@PathVariable Long id) {
		Company company = companyService.obtenerPorId(id);
		return ResponseEntity.ok(company);
	}

	@PostMapping("/")
	public ResponseEntity<Company> guardarCompany(@Valid @RequestBody Company company) {
		Company companyGuardada = companyService.guardar(company);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(companyGuardada.getIdCompany()).toUri();
		return ResponseEntity.created(ubicacion).body(companyGuardada);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Company> editarCompany(@PathVariable Long id, @Valid @RequestBody Company company) {
		if (companyService.editar(id, company) == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		companyService.editar(id, company);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Company> eliminarCompany(@PathVariable Long id) {
		companyService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
