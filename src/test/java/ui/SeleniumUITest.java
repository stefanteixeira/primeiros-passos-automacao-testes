package ui;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumUITest
{
	private WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://45.55.53.141:5000");
	}
	
	@Test
	public void verificarTituloPagina()
	{
		String titulo = driver.getTitle();
		
    	assertEquals("TodoApp -- Store your Todo items", titulo);
	}
	
	@Test
    public void criarTodo()
	{
    	WebElement novoTodo = driver.findElement(By.id("new"));
    	novoTodo.click();
    	
    	WebElement nomeTodo = driver.findElement(By.id("title"));
    	nomeTodo.sendKeys("Apresentar palestra na M4U");
    	
    	WebElement descricao = driver.findElement(By.id("text"));
    	descricao.sendKeys("1o Ciclo de Palestras - 2015");
    	
    	WebElement salvar = driver.findElement(By.id("save"));
    	salvar.click();
    	
    	assertEquals("http://45.55.53.141:5000/", driver.getCurrentUrl());
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
