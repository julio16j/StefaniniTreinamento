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

import com.money.exceptionhandler.CadastroInvalidoException;
import com.money.model.Categoria;
import com.money.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listar(){
		
		return this.categoriaService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
	 	return ResponseEntity.ok( this.categoriaService.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria,  @PathVariable Long id) {
		return ResponseEntity.ok(categoriaService.atualizar(categoria, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		categoriaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping
	public ResponseEntity<Categoria> delete(@RequestBody Categoria categoria){
		categoriaService.delete(categoria);
		return ResponseEntity.noContent().build();
	}
	@PostMapping
	public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria) throws CadastroInvalidoException {
		return  ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.cadastrar(categoria));
	}
	
	
	
	
}
