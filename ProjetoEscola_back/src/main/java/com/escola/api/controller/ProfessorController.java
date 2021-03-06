package com.escola.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.api.model.Aluno;
import com.escola.api.model.Professor;
import com.escola.api.repository.AlunoRepository;
import com.escola.api.repository.ProfessorRepository;
import com.escola.api.repository.filter.ProfessorFilter;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_LISTAR_PROFESSORES')")
	public List<Professor> listarProfessores(ProfessorFilter professorFilter){
		return this.professorRepository.filtrar(professorFilter);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_LISTAR_PROFESSOR')")
	public ResponseEntity<Professor> listarProfessorPorId(@PathVariable Long id){
		Professor professor = this.professorRepository.findOne(id);
		return professor != null ? ResponseEntity.ok(professor) : ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_SALVAR_PROFESSOR')")
	public ResponseEntity<Professor> salvarProfessor(@Valid @RequestBody Professor professor){
		for (Aluno aluno: this.alunoRepository.findAll()) {
			if(aluno.getEmail().equalsIgnoreCase(professor.getEmail())) {
				throw new DataIntegrityViolationException("Email já cadastrado");
			}
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		professor.setSenha( encoder.encode(professor.getSenha()) );
		Professor professorSalvo = this.professorRepository.save(professor);
		return ResponseEntity.status(HttpStatus.CREATED).body(professorSalvo);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_DELETAR_PROFESSOR')")
	public void deletarAluno(@Valid @PathVariable Long id) {
		this.professorRepository.delete(id);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_EDITAR_PROFESSOR')")
	public ResponseEntity<Professor> atualizarProfessor(@PathVariable Long id, @Valid @RequestBody Professor professorReq){
		for (Aluno aluno: this.alunoRepository.findAll()) {
			if(aluno.getEmail().equalsIgnoreCase(professorReq.getEmail())) {
				throw new DataIntegrityViolationException("Email já cadastrado");
			}
		}
		Professor professorOpt = this.professorRepository.findOne(id);		
		BeanUtils.copyProperties(professorReq, professorOpt, "id");
		Professor professorDepois =  professorRepository.save(professorOpt);
		
		return ResponseEntity.ok(professorDepois);
	}
	
	@PutMapping("/senha/{id}")
	@PreAuthorize("hasAuthority('ROLE_EDITAR_PROFESSOR')")
	public ResponseEntity<Professor> atualizarProfessor2(@PathVariable Long id, @Valid @RequestBody Professor professorReq){
		for (Aluno aluno: this.alunoRepository.findAll()) {
			if(aluno.getEmail().equalsIgnoreCase(professorReq.getEmail())) {
				throw new DataIntegrityViolationException("Email já cadastrado");
			}
		}
		professorReq.setSenha(encoder.encode(professorReq.getSenha()));
		Professor professorOpt = this.professorRepository.findOne(id);		
		BeanUtils.copyProperties(professorReq, professorOpt, "id");
		Professor professorDepois =  professorRepository.save(professorOpt);
		
		return ResponseEntity.ok(professorDepois);
	}

}
