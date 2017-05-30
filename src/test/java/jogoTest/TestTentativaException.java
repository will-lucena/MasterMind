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
public class TestTentativaException {

	private Tentativa tentativa = new Tentativa();
	private int posicao;
	private String cor;
	private int posicaoInvalida;

	public TestTentativaException(int posicao, int posicaoInvalida, String cor) {
		this.cor = cor;
		this.posicao = posicao;
		this.posicaoInvalida = posicaoInvalida;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] { { 0, 10, "black" }, { 1, 11, "xxxxx" }, { 2, 12, "amarel" }, { 3, 13, "VERMELHO" }, });
	}

	@Test
	public void testAdicionarPinoCorIvalida() {
		try {
			tentativa.adicionarPino(posicao, cor);
			fail("Adicionou cor inválida");
		} catch (PosicaoInvalidaException | CorInvalidaException e) {
			try {
				assertEquals(cor, tentativa.getPino(posicaoInvalida));
			} catch (PosicaoInvalidaException e1) {
			}
		}
	}

	@Test
	public void testAdicionarPinoposicaoIvalida() {
		try {
			tentativa.adicionarPino(posicaoInvalida, cor);
			fail("Adicionou cor inválida");
		} catch (PosicaoInvalidaException | CorInvalidaException e) {
			try {
				assertEquals(cor, tentativa.getPino(posicaoInvalida));
			} catch (PosicaoInvalidaException e1) {
			}
		}
	}

	@Test
	public void testEhTentativaIncompleta() {
		try {
			tentativa.adicionarPino(0, cor);
			tentativa.adicionarPino(1, cor);
			tentativa.adicionarPino(2, cor);
			tentativa.adicionarPino(3, cor);
			fail("contabilizou tentativas com cores inválidas");
		} catch (PosicaoInvalidaException | CorInvalidaException e) {
			assertEquals(true, tentativa.ehTentativaIncompleta());
		}
	}

	@Test
	public void testCorEhValida() {
		assertEquals(false, tentativa.CorEhValida(cor));
	}

	@Test
	public void testQuantosPinosJaForamAdicionados() {
		try {
			tentativa.adicionarPino(0, cor);
			tentativa.adicionarPino(1, cor);
			tentativa.adicionarPino(2, cor);
			tentativa.adicionarPino(3, cor);
			fail("Adicionou pinos com cores inválidas");
		} catch (PosicaoInvalidaException | CorInvalidaException e) {
			assertEquals(0, tentativa.quantosPinosJaForamAdicionados());
		}
	}

}
