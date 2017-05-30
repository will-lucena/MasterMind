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
import exceptions.CorInvalidaException;
import exceptions.PosicaoInvalidaException;
import jogo.Jogo;
import jogo.Tentativa;

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
	public void testVerSeAdivinhoGanhouJogo() throws CorInvalidaException {
		Retorno retorno = new Retorno();

		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");

		when(jogada.getRetorno()).thenReturn(retorno);
		assertEquals(true, jogo.verSeAdivinhoGanhouJogo());

		verify(jogada, atLeastOnce()).getRetorno();
	}

	@Test
	public void testMostrarPinosTentativaDaJogada() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa tentativa = new Tentativa();

		tentativa.adicionarPino(0, "verde");

		when(jogada.getTentativa()).thenReturn(tentativa);
		assertEquals(tentativa.quantosPinosJaForamAdicionados(), jogo.mostrarPinosTentativaDaJogada());

		verify(jogada, atLeastOnce()).getTentativa();
	}
}
