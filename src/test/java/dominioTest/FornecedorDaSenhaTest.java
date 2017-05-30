package dominioTest;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import dominio.FornecedorDaSenha;
import dominio.Retorno;
import exceptions.CorInvalidaException;
import exceptions.PosicaoInvalidaException;
import jogo.Senha;
import jogo.Tentativa;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Before;

public class FornecedorDaSenhaTest 
{
	@Test
	public void criarSenhaTest() throws PosicaoInvalidaException
	{
		FornecedorDaSenha fornecedor = new FornecedorDaSenha();
		fornecedor.criarSenha();
		Senha s = fornecedor.getSenha();
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = i+1; j < 4; j++)
			{
				assertFalse(s.getPino(i).equals(s.getPino(j)));
			}
			assertFalse(s.getPino(i).equals("branco") || s.getPino(i).equals("preto"));
		}
		assertEquals(4, s.getPinosInseridos());
	}
	
	@Test
	public void jogarTest() throws PosicaoInvalidaException, CorInvalidaException
	{
		FornecedorDaSenha fornecedor = new FornecedorDaSenha();
		fornecedor.criarSenha();
		Senha s = fornecedor.getSenha();
		
		Tentativa t = new Tentativa();
		for (int i = 0; i < 4; i++)
		{
			t.adicionarPino(i, s.getPino(i));
		}
		
		Retorno r = fornecedor.jogar(t);
		
		for (int i = 0; i < 4; i++)
		{
			assertTrue(r.getPino(i).equals("preto"));
		}
	}
	
	@Test
	public void jogarTestFail()
	{
		FornecedorDaSenha fornecedor = new FornecedorDaSenha();
		fornecedor.jogar();
	}
}
