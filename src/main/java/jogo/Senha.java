package jogo;

import exceptions.CorInvalidaException;
import exceptions.PosicaoInvalidaException;

/**
 * Classe que representa a senha do jogo. Vai armazenar pinos de cores
 * diferentes e o adivinho(usu�rio que usa o sistema) vai tentar adivinhar a
 * senha para ganhar o jogo.
 */
public class Senha {
	/**
	 * o atributo senha � um arranjo que s� vai ter 4 posi��es representando os
	 * pinos da senha. � um arranjo de Strings onde cada elemento do arranjo � a
	 * cor de um pino. Por exemplo, se senha=["azul", "verde", "rosa" e "cinza"]
	 * ent�o a senha �: pino1="azul" pino2="verde" pino3="rosa" pino4="cinza"
	 */
	private String senha[];

	/**
	 * o atributo pinosInseridos representa o total de pinos j� inseridos na
	 * senha. Essa senha s� pode ter 4 pinos.
	 */
	private int pinosInseridos;

	public Senha() {
		senha = new String[4];
		for (int i = 0; i < 4; i++) {
			senha[i] = "nenhum";// por enquanto, nenhum pino foi inserido na
								// senha.
		}
		pinosInseridos = 0;
	}

	/**
	 * m�todo para adicionar um pino na senha.
	 * 
	 * @param corPino
	 *            � uma String representando a cor do pino a ser adicionado.
	 *            Pode ser "vermelho","rosa","amarelo","roxo","verde","cinza" ou
	 *            "laranja".
	 * @throws CorInvalidaException
	 *             caso a cor fornecida como par�metro do m�todo n�o seja v�lida
	 *             no nosso jogo.
	 */
	public void adicionarPino(String corPino) throws CorInvalidaException {
		if (this.CorEhValida(corPino) != true) {
			throw new CorInvalidaException();
		} else if (pinosInseridos != 4) {
			senha[pinosInseridos] = corPino;
			pinosInseridos++;
		}

	}

	public int getPinosInseridos() {
		return pinosInseridos;
	}

	/**
	 * m�todo para checar se uma String representando uma cor � v�lida para ser
	 * adicionada na senha(consequentemente, checa se o pino � v�lido para a
	 * senha). As cores v�lidas s�o:
	 * "vermelho","rosa","amarelo","roxo","verde","cinza" ou "laranja".
	 * 
	 * @param c1
	 *            String que representa a cor a ser checada.
	 * @return um booleano indicando se a cor � v�lida para ser inserida na
	 *         senha
	 */
	public boolean CorEhValida(String c1) {
		if (c1 == null) {
			return false;
		} else if ((c1.compareTo("vermelho") == 0) || (c1.compareTo("azul") == 0) || (c1.compareTo("rosa") == 0)
				|| (c1.compareTo("amarelo") == 0) || (c1.compareTo("roxo") == 0) || (c1.compareTo("verde") == 0)
				|| (c1.compareTo("cinza") == 0) || (c1.compareTo("laranja") == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * esse m�todo pega um pino(String com cor do pino) no atributo
	 * "String [] senha" da classe.
	 * 
	 * @param posicao
	 *            indica o �ndice onde o pino est� inserido na senha.
	 * @return String representando a cor do pino contido na senha.
	 * @throws PosicaoInvalidaException
	 *             essa exce��o � lan�ada quando o par�metro do m�todo � um
	 *             �ndice inv�lido para a senha.
	 */
	public String getPino(int posicao) throws PosicaoInvalidaException {
		if (posicao < 0 || posicao > 3) {
			throw new PosicaoInvalidaException();
		}

		return this.senha[posicao];

	}

	/**
	 * checa se uma senha � v�lida para ser usada no jogo. Uma senha v�lida
	 * cont�m 4(QUATRO) pinos de CORES DIFERENTES.
	 * 
	 * @return um booleano representando se a senha � v�lida para ser usada no
	 *         jogo.
	 */
	public boolean ehSenhaValida() {
		// como n�o podemos inserir senha de cor inv�lida, basta
		// checar se n�o h� cores repetidas
		boolean ehValida = true;
		String corComparada;
		int i, j;
		for (i = 0; i < 4; i++) {
			corComparada = senha[i];
			if (corComparada == "nenhum") {
				ehValida = false;
			}

			// temos de ver se h� pinos de cores iguais
			for (j = i + 1; j < 4; j++) {
				if (senha[j] == corComparada) {
					ehValida = false;
				}
			}
		}
		return ehValida;
	}

}
