package business;

import annotation.AnnotationModel;
import annotation.AnnotationNotNull;

public class Negocio {
	
	@AnnotationModel(maxSize = 10, error = "Valor de atributo maior que o permitido", line = 8)
	@AnnotationNotNull(error = "Não permitido nulo", line = 9)
	public String nome;
	
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
