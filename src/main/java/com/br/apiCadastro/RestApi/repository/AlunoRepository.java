package com.br.apiCadastro.RestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.apiCadastro.RestApi.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
