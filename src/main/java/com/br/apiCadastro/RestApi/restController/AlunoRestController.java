package com.br.apiCadastro.RestApi.restController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.apiCadastro.RestApi.model.Aluno;
import com.br.apiCadastro.RestApi.service.AlunoService;

@SuppressWarnings("deprecation")
@RestController
@RequestMapping(value = "/rest/aluno",
produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AlunoRestController {
	@Autowired
	private AlunoService service;
	@Autowired
    private HttpServletResponse response;
	
	@GetMapping("/consultar")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Aluno> consultar(){
		return service.consultar();
	}
	@PostMapping("/inserir")
	@ResponseStatus(code = HttpStatus.OK)
	public void inserir(@RequestBody Aluno aluno){
		try {
			 if(service.salvar(aluno)) {
				 response.setStatus(200); 
			 }else {
				 response.setStatus(418);
			 }
		} catch (Exception e) {
			response.setStatus(500);
		}
	}
	@DeleteMapping("/excluir/{id}")
	public void delete(@PathVariable("id") Long id) {
		try {
			if(service.excluir(id)) {
				response.setStatus(200);
			}else {
				response.setStatus(418);
			}
		} catch (Exception e) {
			response.setStatus(500);
		}
	}
	@PostMapping("/editar/{id}")
	public void editar(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
		try {
			if(service.editar(id, aluno)) {
				response.setStatus(200);
			}else{
				response.setStatus(418);
			}
		} catch (Exception e) {
			response.setStatus(500);
		}
	}

}
