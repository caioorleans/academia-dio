package academia.dio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academia.dio.dto.AlunoForm;
import academia.dio.dto.AlunoUpdateForm;
import academia.dio.model.Aluno;
import academia.dio.model.AvaliacaoFisica;
import academia.dio.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;

	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataNascimento(form.getDataNascimento());
		
		return repository.save(aluno);
	}
	
	public Aluno get(Long id) {
		return null;
	}
	
	public List<Aluno> getAll(){
		return repository.findAll();
	}
	
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		return null;
	}

	public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
		Aluno aluno = repository.findById(id).get();
		return aluno.getAvaliacoes();
	}
}
