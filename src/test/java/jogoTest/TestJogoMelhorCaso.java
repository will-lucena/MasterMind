package jogoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import dominio.Adivinho;
import dominio.FornecedorDaSenha;
import dominio.Jogada;
import dominio.Retorno;
import jogo.Jogo;

public class TestJogoMelhorCaso {

	private Jogo jogo;
	@Mock
	private FornecedorDaSenha fornecedor;
	@Mock
	private Adivinho adivinho;
	@Mock
	private Jogada jogada;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		jogo = new Jogo();
		jogo.setAdivinho(adivinho);
		jogo.setFornecedor(fornecedor);
		jogo.setJogada(jogada);
	}

	@Test
	public void testVerSeAdivinhoGanhouJogo() {
		Retorno retorno = new Retorno();
		when(jogada.getRetorno()).thenReturn(retorno);
		jogo.verSeAdivinhoGanhouJogo();
	}

}
