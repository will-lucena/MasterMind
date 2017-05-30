package dominioTest;

import org.junit.Assert;
import org.junit.Test;

import dominio.Retorno;
import exceptions.CorInvalidaException;
import exceptions.PosicaoInvalidaException;

public class RetornoTest 
{
	@Test
	public void adicionarPinoOk() throws CorInvalidaException, PosicaoInvalidaException
	{
		Retorno retorno = new Retorno();
		retorno.adicionarPino("branco");
	
		Assert.assertEquals("branco", retorno.getPino(0));
	}
	
	@Test (expected = CorInvalidaException.class)
	public void adicionarPinoCorInvalidaFail() throws CorInvalidaException
	{
		Retorno retorno = new Retorno();
		retorno.adicionarPino("azul");
	}
	
	@Test (expected = PosicaoInvalidaException.class)
	public void getPinoPosicaoInvalidaOk() throws CorInvalidaException, PosicaoInvalidaException
	{
		Retorno retorno = new Retorno();
		retorno.getPino(1);
	}
	
	@Test (expected = PosicaoInvalidaException.class)
	public void getPinoPosicaoInvalidaFail() throws CorInvalidaException, PosicaoInvalidaException
	{
		Retorno retorno = new Retorno();
		retorno.adicionarPino("branco");
	
		Assert.assertEquals("branco", retorno.getPino(3));
	}	
}
