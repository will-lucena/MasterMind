package exceptions;

/**
 * Exce��o disparada quando � tentado adicionar uma cor na Tentativa do
 * adivinho, na Senha ou no Retorno que n�o � v�lida para nosso jogo.
 * 
 * Para a tentativa do adivinho e a senha do jogo, as cores v�lidas s�o:
 * vermelho,rosa,amarelo,roxo,verde,cinza e laranja.
 * 
 * Para o retorno(feedback mostrado ao adivinho para indica se ele acertou algo
 * em sua tentativa de adivinhar a senha), as cores v�lidas s�o: preto(indicando
 * que ele acertou uma cor e uma posi��o de um pino na senha) e branco(indicando
 * que ele acertou a cor de um pino na senha, mas n�o acertou posi��o).
 */
public class CorInvalidaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CorInvalidaException() {
		super("cor inv�lida");
	}

}
