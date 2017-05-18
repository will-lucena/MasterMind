package jogo;

import dominio.Adivinho;
import dominio.FornecedorDaSenha;
import dominio.Jogada;
import dominio.Retorno;
import exceptions.PosicaoInvalidaException;

/**
 * A unica classe executavel do projeto. Esta classe que cria um
 * FornecedorDaSenha, Um Adivinho, mantem a quantidade de turnos que se
 * passaram(ou seja, a quantidade de tentativas submetidas pelo Adivinho ou a
 * quantidade de Retornos gerados pelo Fornecedor) e imprime cada jogada, seja
 * ela do Adivinho ou do FornecedorDaSenha(que � tamb�m quem verifica se o
 * Adivinho conseguiu acertar a senha). "Jogo" tamb�m � a classe que instancia
 * Jogada, a classe que permite que FornecedorDaSenha conhe�a a tentativa criada
 * pelo Adivinho.
 * 
 */
public class Jogo {
	/**
	 * "turno" � turno atual do jogo. Quando o Adivinho faz uma tentativa e a
	 * tentativa � verificada pelo Fornecedor e � gerado um Retorno, termina um
	 * turno.
	 */
	private int turno;
	private FornecedorDaSenha fornecedor = null;
	private Adivinho adivinho = null;

	/**
	 * "Jogada" � o objeto que permite que o Fornecedor conhe�a a tentativa que
	 * o Adivinho criou e que permite que a classe "Jogo" conhe�a o Retorno que
	 * o FornecedorDaSenha criou.
	 */
	private Jogada jogada;

	public Jogo() {
		turno = 0;
		fornecedor = new FornecedorDaSenha();
		adivinho = new Adivinho();
		jogada = null;
	}

	public int getTurno() {
		return turno;
	}

	public Adivinho getAdivinho() {
		return adivinho;
	}

	public FornecedorDaSenha getFornecedor() {
		return fornecedor;
	}

	public void setJogada(Jogada jog) {
		jogada = jog;
	}

	/**
	 * A fun��o n�o necessariamente cria uma nova senha, apenas manda o
	 * FornecedorDaSenha gerar uma senha.
	 */
	public void criarSenha() {
		fornecedor.criarSenha();
	}

	/**
	 * Fun��o que verifica se o Adivinho j� ganhou o jogo. - Se o jogo n�o
	 * come�ou ainda(jogada == null), a fun��o retorna false - Se algum pino do
	 * retorno n�o for preto, a fun��o retorna false (pois para que o adivinho
	 * ganhe o jogo, o retorno gerado pelo FornecedorDaSenha deve conter apenas
	 * pinos de cor preto) - Caso todos os pinos do Retorno sejam pretos, ent�o
	 * isso significa que o jogo terminou e o adivinho ganhou.
	 * 
	 * @return
	 */
	public boolean verSeAdivinhoGanhouJogo() {
		if (jogada == null) {
			return false;
		} else {
			Retorno retorno = jogada.getRetorno();
			for (int i = 0; i < 4; i++) {
				try {
					if (retorno.getPino(i).compareTo("preto") != 0) {
						return false;
					}
				} catch (PosicaoInvalidaException e) {
				}
			}
			return true;
		}
	}

	/**
	 * a fun��o abaixo � a principal fun��o do nosso sistema. Nela, o jogo
	 * realmente acontece. Os passos s�o: 1) Uma senha � criada pelo
	 * FornecedorDaSenha 2) Come�a o jogo. A cada turno, acontecem os seguintes
	 * passos: 1 - Uma nova Jogada � criada e � passada tanto para o Adivinho
	 * como para o FornecedorDaSenha 2 - O adivinho joga. Ele cria uma nova
	 * Tentativa para tentar acertar a senha. 3 - O FornecedorDaSenha joga. Ele
	 * compara a Senha e a Tentativa do Adivinho para gerar um retorno 3) Caso
	 * passem 10 turnos ou o adivinho ganhe o jogo, o jogo acaba. 4) � mostrada
	 * ao jogador uma frase que indica se ele perdeu ou ganhou.
	 */
	public void executarJogo() {
		this.criarSenha();
		while (turno < 10 && this.verSeAdivinhoGanhouJogo() == false) {
			System.out.println("///////////////turno " + turno + "////////////////");
			jogada = new Jogada();
			adivinho.setJogada(jogada);
			fornecedor.setJogada(jogada);
			adivinho.jogar();
			System.out.println("----------------------------------------");
			this.mostrarPinosTentativaDaJogada();
			fornecedor.jogar();
			this.mostrarPinosRetornoDaJogada();
			System.out.println("----------------------------------------");
			System.out.println(" ");
			turno = turno + 1;
		}
		terminarJogo();
	}

	/**
	 * m�todo usado para imprimir no terminal(System.out()) qual foi a tentativa
	 * feita pelo adivinho(o usu�rio que est� jogando) para tentar descobrir a
	 * senha.
	 */
	public void mostrarPinosTentativaDaJogada() {
		try {
			Tentativa tentativa = this.jogada.getTentativa();
			System.out.println("A tentativa da jogada foi:");
			for (int i = 0; i < tentativa.quantosPinosJaForamAdicionados(); i++) {
				System.out.println(tentativa.getPino(i));
			}
			System.out.println(" ");
		} catch (PosicaoInvalidaException e) {
			System.out.println("erro ao tentar acessar pinos de um retorno de uma jogada");
		}
	}

	/**
	 * m�todo usado para imprimir no terminal(System.out()) o Retorno para a
	 * tentativa do adivinho (pinos pretos e brancos indicando se ele acertou
	 * uma posi��o e cor -ou- uma cor de algum pino da senha )
	 */
	public void mostrarPinosRetornoDaJogada() {
		try {
			Retorno retorno = this.jogada.getRetorno();
			System.out.println("O retorno da jogada foi:");
			for (int i = 0; i < retorno.getPinosInseridos(); i++) {
				System.out.println(retorno.getPino(i));
			}
			System.out.println(" ");
		} catch (PosicaoInvalidaException e) {
			System.out.println("erro ao tentar acessar pinos de um retorno de uma jogada");
		}
	}

	/**
	 * m�todo chamado quando o jogo termina. Dependendo da quantidade de turnos
	 * passados, o jogo pode ter acabado com o jogador descobrindo a senha antes
	 * de 10 turnos passarem (vit�ria do adivinho) ou com 10 turnos acabarem(o
	 * adivinho perdeu)
	 */
	public void terminarJogo() {
		if (turno >= 10) {
			System.out.println("Voc� perdeu. Tente novamente mais tarde");
		} else {
			System.out.println("Parab�ns!Voc� venceu!!!!");
		}
	}

	public static void main(String args[]) {
		Jogo jogoSenha = new Jogo();
		jogoSenha.executarJogo();
	}

}
