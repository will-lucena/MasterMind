package dominioTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Jogada;
import exceptions.CorInvalidaException;
import exceptions.PosicaoInvalidaException;
import jogo.Tentativa;

public class AdivinhoTest {

	@Test
	public void test() {
	//	fail("Not yet implemented");
	}

	public void realizarTentativaOk(){
		Jogada j = new Jogada();
		Tentativa t = new Tentativa();
		j.setTentativa(t);
		assertEquals(t, j.getTentativa());
	}
	
	public void realizarTentativaFail(){
		Jogada j = new Jogada();
		Tentativa t = new Tentativa();
		j.setTentativa(t);
		assertEquals(t, j.getTentativa());
	}
	
	public void jogarOk(){
		
		
		
	}
	
	public void adicionarNovoPinoATentativaOk() throws PosicaoInvalidaException, CorInvalidaException{
		Jogada j = new Jogada();
		Tentativa t = new Tentativa();
		t.adicionarPino(2, "azul");
		j.setTentativa(t);
	}
	
	//Ao tentar inserir em uma posição inválida, deve disparar a PosicaoInvalidaException
	@Test (expected = PosicaoInvalidaException.class)
	public void adicionarNovoPinoATentativaFailPosicaoInvalida() throws  PosicaoInvalidaException, CorInvalidaException{
		Jogada j = new Jogada();
		Tentativa t = new Tentativa();
		t.adicionarPino(4, "azul");
		j.setTentativa(t);
	}
	
	@Test (expected = CorInvalidaException.class)
	public void adicionarNovoPinoATentativaFailCorInvalida() throws CorInvalidaException, PosicaoInvalidaException{
		Jogada j = new Jogada();
		Tentativa t = new Tentativa();
		t.adicionarPino(2, "pink");
		j.setTentativa(t);
	}
	

}
