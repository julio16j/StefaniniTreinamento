package com.money.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.money.model.Pessoa;
import com.money.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public List<Pessoa> listar(){
		return pessoaRepository.findAll();
	}
	
	public  Pessoa cadastrar(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
}
	
	public Pessoa findById(Long id) {
		return this.pessoaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	
	}
	
	public Pessoa atualizar(Pessoa pessoa, Long id){
		Pessoa resposta = this.pessoaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	 	pessoa.setCodigo(resposta.getCodigo());
	 	return this.pessoaRepository.save(pessoa);
	 	
		
	}
	
	public ResponseEntity<Void> deleteById (Long id) {
		Optional<Pessoa> pessoa = this.pessoaRepository.findById(id);
		if(pessoa.isPresent()) {
			this.pessoaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		else return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Pessoa> delete(Pessoa pessoa) {
		if(this.pessoaRepository.findById(pessoa.getCodigo()).isPresent()) {
			this.pessoaRepository.delete(pessoa);
			return ResponseEntity.ok(null);
		}
		else return ResponseEntity.notFound().build();
		
	}
}
