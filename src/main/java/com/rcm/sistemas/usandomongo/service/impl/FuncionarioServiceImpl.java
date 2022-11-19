package com.rcm.sistemas.usandomongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcm.sistemas.usandomongo.model.Funcionario;
import com.rcm.sistemas.usandomongo.repository.FuncionarioRepository;
import com.rcm.sistemas.usandomongo.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> obterTodos() {
		return this.funcionarioRepository.findAll();
	}

	@Override
	public Funcionario obterPorCodigo(String codigo) {
		return this.funcionarioRepository.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Funcionário não existe."));
	}

	@Override
	public Funcionario criar(Funcionario funcionario) {

		Funcionario chefe = this.funcionarioRepository
				.findById(funcionario.getChefe().getCodigo())
				.orElseThrow(() -> new IllegalArgumentException("Chefe Inexistente"));
		funcionario.setChefe(chefe);
		
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public List<Funcionario> obterFuncionarioPorFaixaDeIdade(Integer de, Integer ate) {
		return this.funcionarioRepository.obterFuncionarioPorFaixaDeIdade(de, ate);
	}

	@Override
	public List<Funcionario> findByNome(String nome) {
		return this.funcionarioRepository.findByNome(nome);
	}

}
