package academia.dio.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academia.dio.dto.AvaliacaoFisicaForm;
import academia.dio.model.Aluno;
import academia.dio.model.AvaliacaoFisica;
import academia.dio.repository.AlunoRepository;
import academia.dio.repository.AvaliacaoFisicaRepository;

@Service
public class AvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository repository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		
		avaliacaoFisica.setAluno(aluno);
		avaliacaoFisica.setAltura(form.getAltura());
		avaliacaoFisica.setPeso(form.getPeso());
		avaliacaoFisica.setDataAvalaicao(LocalDateTime.now());
		
		return repository.save(avaliacaoFisica);
	}

}
