package dominio;

/**
 * interface em comum ao Adivinho e ao FornecedorDaSenha que s�o os dois
 * jogadores necess�rios para se jogar o jogo Senha.
 *
 */
public interface Jogador {
	/**
	 * seta uma Jogada ao jogador.� chamada pelo jogo para setar uma nova Jogada
	 * tanto no Adivinho quanto no FornecedordaSenha em cada novo turno do
	 * jogo(o jogo tem no m�ximo 10 turnos).
	 * 
	 * @param jog
	 *            � a nova jogada passada para o Jogador(Adivinho e
	 *            FornecedorDaSenha).
	 */
	public void setJogada(Jogada jog);

	public void jogar();

}
