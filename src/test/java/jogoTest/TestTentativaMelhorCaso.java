package jogoTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exceptions.CorInvalidaException;
import exceptions.PosicaoInvalidaException;
import jogo.Tentativa;

@RunWith(Parameterized.class)
public class TestTentativaMelhorCaso {

	private Tentativa tentativa = new Tentativa();
	private int posicao;
	private String cor;

	public TestTentativaMelhorCaso(int posicao, String cor) {
		this.posicao = posicao;
		this.cor = cor;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{ 0, "azul" }, 
			{ 1, "verde" }, 
			{ 2, "amarelo" }, 
			{ 3, "vermelho" }, 
			});
	}

	@Test
	public void testAdicionarPino() throws PosicaoInvalidaException, CorInvalidaException {
		tentativa.adicionarPino(posicao, cor);
		assertEquals(cor, tentativa.getPino(posicao));
	}

	@Test
	public void testCorEhValida() {
		assertEquals(true, tentativa.CorEhValida(cor));
	}

	@Test
	public void testQuantosPinosJaForamAdicionados() throws PosicaoInvalidaException, CorInvalidaException {
		tentativa.adicionarPino(0, cor);
		tentativa.adicionarPino(1, cor);
		tentativa.adicionarPino(2, cor);
		tentativa.adicionarPino(3, cor);

		assertEquals(4, tentativa.quantosPinosJaForamAdicionados());
	}

}
