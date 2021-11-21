package com.br.apiCadastro.RestApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apiCadastro.RestApi.model.Aluno;
import com.br.apiCadastro.RestApi.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repository;
	
	
	public List<Aluno> consultar() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	public boolean salvar(Aluno aluno) {
		try {
			repository.save(aluno);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean excluir(Long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean editar(Long id, Aluno aluno) {
		try {
			aluno.setId(id);
			salvar(aluno);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
