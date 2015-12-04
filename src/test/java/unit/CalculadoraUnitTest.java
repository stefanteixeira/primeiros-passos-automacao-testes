package unit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import calculadora.Calculadora;

public class CalculadoraUnitTest
{
	private Calculadora calc;
	
	@Before
	public void setUp()
	{
		calc = new Calculadora();
	}
	
	@Test
	public void soma()
	{
		int soma = calc.somar(1, 3);
		
		assertEquals(4, soma);
	}

	@Test
	public void subtracao()
	{
		int subtracao = calc.subtrair(5, 2);
		
		assertEquals(3, subtracao);
	}

	@Test
	public void divisao()
	{
		int divisao = calc.dividir(10, 2);
		
		assertEquals(5, divisao);
	}

	@Test(expected = ArithmeticException.class)
	public void divisaoPorZeroDeveLancarExcecao()
	{
		calc.dividir(5, 0);
	}
}
