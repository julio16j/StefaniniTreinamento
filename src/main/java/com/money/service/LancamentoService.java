package com.money.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.money.model.Lancamento;
import com.money.repository.LancamentoRepository;

@Service
public class LancamentoService {
	@Autowired
	LancamentoRepository lancamentoRepository;
	
	public List<Lancamento> listar(){
		return lancamentoRepository.findAll();
	}
	
	public  Lancamento cadastrar(Lancamento lancamento) {
		return this.lancamentoRepository.save(lancamento);
}
	
	public Lancamento findById(Long id) {
		return this.lancamentoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	
	}
	
	public Lancamento atualizar(Lancamento lancamento, Long id){
		Lancamento resposta = this.lancamentoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	 	lancamento.setCodigo(resposta.getCodigo());
	 	return this.lancamentoRepository.save(lancamento);
	}
	
	public void deleteById (Long id) {
		this.lancamentoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		this.lancamentoRepository.deleteById(id);
	}

	public void delete(Lancamento lancamento) {
		Lancamento resposta = this.lancamentoRepository.findById(lancamento.getCodigo()).orElseThrow(() -> new EmptyResultDataAccessException(1));
		this.lancamentoRepository.delete(resposta);
		
	}

}
