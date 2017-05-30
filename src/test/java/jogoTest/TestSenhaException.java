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
import jogo.Senha;

@RunWith(Parameterized.class)
public class TestSenhaException {

	private boolean valido;
	private String cor;
	private Senha senha;
	private int posicao;

	public TestSenhaException(boolean valido, int posicao, String cor) {
		this.valido = valido;
		this.cor = cor;
		this.posicao = posicao;
		this.senha = new Senha();
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { false, -20, "XXXX" }, { false, -1, "VERDE" }, { false, 0, "amarel" },
				{ false, 3, "ermelho" }, { false, 4, "ROSA" }, { false, 5, "blue" }, { false, 30, "branca" } });
	}

	@Test
	public void testAdicionarPino() {
		try {
			senha.adicionarPino(cor);
			fail("Adicionou cor inválida");
		} catch (CorInvalidaException e) {
			assertEquals(0, senha.getPinosInseridos(), 0);
		}
	}

	@Test
	public void testCorEhValida() {
		assertEquals(valido, senha.CorEhValida(cor));
	}

	@Test
	public void testGetPino() {
		try {
			senha.getPino(posicao);			
		} catch (PosicaoInvalidaException e) {
		}
	}

	@Test
	public void testEhSenhaValida() {
		try {
			senha.adicionarPino("azul");
			senha.adicionarPino("azul");
			senha.adicionarPino("azul");
			senha.adicionarPino("azul");
			assertEquals(false,senha.ehSenhaValida());
		} catch (CorInvalidaException e) {
		
		}		
	}

}
