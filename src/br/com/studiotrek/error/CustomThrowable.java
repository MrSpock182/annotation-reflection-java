package br.com.studiotrek.error;

/***
 * Classe responsavel por criar exception com stack de erro mais legivel.
 * @author kleber
 */
public class CustomThrowable {

	private String mensagem;
	
	public CustomThrowable(String mensagem) {
		this.mensagem = mensagem;
	}
	
	/**
	 * Metodo para criar stack de erro customizada.
	 * @param classNamem
	 * @param method
	 * @param numberLine
	 * @return Throwable
	 */
	public Throwable getThrowable(String classNamem, String method, Integer numberLine) {
		
		StackTraceElement stack = new StackTraceElement(classNamem, 
				method, 
				classNamem + ".java", 
				numberLine);
		StackTraceElement[] stacks = {stack};
		Throwable throwable = new Throwable(this.mensagem);
		throwable.setStackTrace(stacks);
		
		return throwable;
	}
	
}
