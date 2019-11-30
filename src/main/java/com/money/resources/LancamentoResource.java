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

import com.money.model.Lancamento;
import com.money.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
	@Autowired
	private LancamentoService lancamentoService;
	
	@GetMapping
	public List<Lancamento> listar(){
		
		return this.lancamentoService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Lancamento> findById(@PathVariable Long id) {
	 	return ResponseEntity.ok(this.lancamentoService.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Lancamento> atualizar(@RequestBody Lancamento lancamento,  @PathVariable Long id) {
		return ResponseEntity.ok(this.lancamentoService.atualizar(lancamento, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		lancamentoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping
	public ResponseEntity<Lancamento> delete(@RequestBody Lancamento lancamento){
		lancamentoService.delete(lancamento);
		return ResponseEntity.noContent().build();
		
	}
	@PostMapping
	public ResponseEntity<Lancamento> cadastrar(@RequestBody Lancamento lancamento) {
		return  ResponseEntity.status(HttpStatus.CREATED).body(lancamentoService.cadastrar(lancamento));
	}
}
