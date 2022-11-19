package com.rcm.sistemas.usandomongo.service;

import java.util.List;

import com.rcm.sistemas.usandomongo.model.Funcionario;

public interface FuncionarioService {

	public List<Funcionario> obterTodos();

	public Funcionario obterPorCodigo(String codigo);

	public Funcionario criar(Funcionario funcionario);

	public List<Funcionario> obterFuncionarioPorFaixaDeIdade(Integer de, Integer ate);
	
	List<Funcionario> findByNome(String nome);

}
