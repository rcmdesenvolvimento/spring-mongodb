package com.rcm.sistemas.usandomongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rcm.sistemas.usandomongo.model.Funcionario;
import com.rcm.sistemas.usandomongo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping()
	public List<Funcionario> obterTodos() {
		return this.funcionarioService.obterTodos();
	}

	@GetMapping(value = "/{codigo}")
	public Funcionario obterPorCodigo(@PathVariable String codigo) {
		return this.funcionarioService.obterPorCodigo(codigo);
	}

	@GetMapping("/faixa")
	public List<Funcionario> obterFuncionarioPorFaixaDeIdade(
			@RequestParam("de") Integer de,
			@RequestParam("de") Integer ate) {
		return this.funcionarioService.obterFuncionarioPorFaixaDeIdade(de, ate);
	}
	

	@GetMapping("/por-nome")
	public List<Funcionario> findByNome(@RequestParam("nome") String nome) {
		return this.funcionarioService.findByNome(nome);
	}

	@PostMapping
	public Funcionario criar(@RequestBody Funcionario funcionario) {
		return this.funcionarioService.criar(funcionario);
	}

}

// localhost:8080/funcionarios/63791782e5387c1723705e8d
// localhost:8080/funcionarios/faixa?de=20&ate=30

/*
echo "# spring-mongodb" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:rcmdesenvolvimento/spring-mongodb.git
git push -u origin main
**************************************************************************
*
*
*git remote add origin git@github.com:rcmdesenvolvimento/spring-mongodb.git
git branch -M main
git push -u origin main
*/



