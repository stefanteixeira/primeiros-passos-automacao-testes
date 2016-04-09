package calculadora;

public class CalculadoraDesconto
{	
	public int getPercentualDesconto(int valorCompra)
	{
		int percentualDesconto = 0;

		if (valorCompra <= 100)
		{
			percentualDesconto = 0;
		}
		else if (valorCompra <= 200)
		{
			percentualDesconto = 10;
		}
		else
		{
			percentualDesconto = 15;
		}
		
		return percentualDesconto;
	}
}
