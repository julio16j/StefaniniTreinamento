package com.money.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

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
	
	public void deleteById (Long id) {
		this.pessoaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		this.pessoaRepository.deleteById(id);
	}

	public void delete(Pessoa pessoa) {
		Pessoa resposta = this.pessoaRepository.findById(pessoa.getCodigo()).orElseThrow(() -> new EmptyResultDataAccessException(1));
		this.pessoaRepository.delete(resposta);
		
	}
}
