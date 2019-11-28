package com.money.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.money.model.Pessoa;
import com.money.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> listar(){
		
		return this.pessoaService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
	 	return ResponseEntity.ok(this.pessoaService.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa,  @PathVariable Long id) {
		return ResponseEntity.ok(this.pessoaService.atualizar(pessoa, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		return pessoaService.deleteById(id);
	}
	@DeleteMapping
	public ResponseEntity<Pessoa> delete(@RequestBody Pessoa pessoa){
		return pessoaService.delete(pessoa);
		
	}
	@PostMapping
	public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {
		return  ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.cadastrar(pessoa));
	}

}
