package unit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import calculadora.CalculadoraDesconto;

public class CalculadoraDescontoUnitTest
{
	private CalculadoraDesconto calculadora;
	
	@Before
	public void setUp() 
	{
		calculadora = new CalculadoraDesconto();
	}
	
	@Test
	public void descontoCompraMenorQue100()
	{
		int desconto = calculadora.getPercentualDesconto(50);
		
		assertEquals(0, desconto);
	}
	
	@Test
	public void descontoCompraIgualA100()
	{
		int desconto = calculadora.getPercentualDesconto(100);
		
		assertEquals(0, desconto);
	}
	
	@Test
	public void descontoCompraMenorQue200()
	{
		int desconto = calculadora.getPercentualDesconto(150);
		
		assertEquals(10, desconto);
	}
	
	@Test
	public void descontoCompraIgualA200()
	{
		int desconto = calculadora.getPercentualDesconto(200);
		
		assertEquals(10, desconto);
	}

	@Test
	@Ignore
	public void descontoCompraMaiorQue200()
	{
		int desconto = calculadora.getPercentualDesconto(230);
		
		assertEquals(15, desconto);
	}
	
}
