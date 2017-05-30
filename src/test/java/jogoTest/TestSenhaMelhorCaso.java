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
	private boolean valido;
	private String cor;
	private Senha senha;
	
	public TestSenhaMelhorCaso(boolean valido, String cor) {
		this.valido = valido;
		this.cor = cor;
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

	@Test
	public void testAdicionarPino() throws CorInvalidaException, PosicaoInvalidaException {
		senha.adicionarPino(cor);
		assertEquals(cor, senha.getPino(0));
	}

	@Test
	public void testCorEhValida() {
		assertEquals(valido, senha.CorEhValida(cor));
	}

}
