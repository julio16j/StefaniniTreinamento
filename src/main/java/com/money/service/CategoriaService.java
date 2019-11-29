package com.money.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	
	public Categoria findById(Long id) {
		return this.categoriaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public Categoria atualizar(Categoria categoria, Long id){
		Categoria resposta = this.categoriaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	 	categoria.setCodigo(resposta.getCodigo());
	 	return this.categoriaRepository.save(categoria);
		
	}
	
	public void deleteById (Long id) {
		this.categoriaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		this.categoriaRepository.deleteById(id);
	}

	public void delete(Categoria categoria) {
		this.categoriaRepository.findById(categoria.getCodigo()).orElseThrow(() -> new EmptyResultDataAccessException(1));
		this.categoriaRepository.delete(categoria);
		
	}

}
