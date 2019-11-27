package com.money.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.money.model.Categoria;
import com.money.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> listar(){
		return this.categoriaRepository.findAll();
	}
	
	public  Categoria cadastrar(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}
	
	public ResponseEntity<Categoria> findById(Long id) {
		Optional<Categoria> resposta = this.categoriaRepository.findById(id);
	 	if(resposta.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(resposta.get());
	 	else return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<Categoria> atualizar(Categoria categoria, Long id){
		Optional<Categoria> resposta = this.categoriaRepository.findById(id);
	 	if(resposta.isPresent()) {
	 		categoria.setCodigo(resposta.get().getCodigo());
	 		return ResponseEntity.status(HttpStatus.OK).body(this.categoriaRepository.save(categoria));
	 	}
	 	else return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
	}
	
	public ResponseEntity<Categoria> deleteById (Long id) {
		Optional<Categoria> categoria = this.categoriaRepository.findById(id);
		if(categoria.isPresent()) {
			this.categoriaRepository.deleteById(id);
			return ResponseEntity.ok(null);
		}
		else return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Categoria> delete(Categoria categoria) {
		if(this.categoriaRepository.findById(categoria.getCodigo()).isPresent()) {
			this.categoriaRepository.delete(categoria);
			return ResponseEntity.ok(null);
		}
		else return ResponseEntity.notFound().build();
		
	}

}
