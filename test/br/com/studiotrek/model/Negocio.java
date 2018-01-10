package br.com.studiotrek.model;

import br.com.studiotrek.annotation.AnnotationModel;
import br.com.studiotrek.annotation.AnnotationModel.TypeSQL;
import br.com.studiotrek.annotation.AnnotationNotNull;

public class Negocio {
	
	@AnnotationModel(maxSize = 10, typeSQL = TypeSQL.NVARCHAR, error = "Valor de atributo maior que o permitido", line = 9)
	@AnnotationNotNull(error = "Não permitido nulo", line = 10)
	public String nome;
	
	@AnnotationModel(typeSQL = TypeSQL.INT, line = 13)
	public Integer idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
}
