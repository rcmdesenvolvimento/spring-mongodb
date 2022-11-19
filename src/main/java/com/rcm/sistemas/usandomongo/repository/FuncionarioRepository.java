package com.rcm.sistemas.usandomongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rcm.sistemas.usandomongo.model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

	// gt = greater than
	// lt = less than
	// gte = greater than equals
	// lte = less than equals

	@Query("{ $and: [{'idade': {$gt: ?0} }, {'idade': {$lt: ?1} } ] }")
	public List<Funcionario> obterFuncioanarioPorFaixaDeIdade(Integer de, Integer ate);
	
	List<Funcionario> findByNome(String nome);

}
