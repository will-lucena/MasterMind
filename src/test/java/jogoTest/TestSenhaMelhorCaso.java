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
public class TestSenhaMelhorCaso {

	public TestSenhaMelhorCaso(boolean expected, String actual) {
		this.expected = expected;
		this.actual = actual;
		this.senha = new Senha();
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{ true, "azul" }, 
			{ true, "verde" }, 
			{ true, "amarelo" },
			{ true, "vermelho" },
			{ true, "cinza" },
			{ true, "roxo" },
			{ true, "azul" },
			{ true, "rosa" }
		});
	}

	private boolean expected;
	private String actual;

	private Senha senha;

	@Test
	public void testAdicionarPino() throws CorInvalidaException, PosicaoInvalidaException {
		senha.adicionarPino(actual);
		assertEquals(actual, senha.getPino(0));
	}

	@Test
	public void testCorEhValida() {
		assertEquals(expected, senha.CorEhValida(actual));
	}

}
