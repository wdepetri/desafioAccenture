package steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.EnterInsurantData;
import pages.EnterProductData;
import pages.EnterVehicleData;
import pages.SelectPriceOption;
import pages.SendQuote;

public class StepsDesafio {

	WebDriver driver;

	/*Primeiramente, precisamos inicializar o navegador*/
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	/*Uma vez aberto, o navegador precisa se direcinado à URL fornecida*/
	@Dado("que eu esteja na pagina {string}")
	public void que_eu_esteja_na_pagina(String url) {
		driver.get(url);
	}

	/*uma vez carregada a página, deve-se preencher todos os formulários referentes ao veículo, ao assegurado, e ao produto desejado
	 * em seguida, deve-se selecionar a opção de valor do plano
	 * e enviar a quotação para o e-mail*/
	@Quando("preencher corretamente todos os formulários")
	public void preencher_corretamente_todos_os_formulários() {
		EnterVehicleData enterVehicleData = new EnterVehicleData(driver);
		EnterInsurantData enterInsurantData = new EnterInsurantData(driver);
		EnterProductData enterProductData = new EnterProductData(driver);
		SelectPriceOption selectPriceOption = new SelectPriceOption(driver);
		SendQuote sendQuote = new SendQuote(driver);

		/*verifica se a tela carregou*/
		if(enterVehicleData.verificaCarregamentoVehicle() == true) {
			enterVehicleData.preencherVehicleData();
		}
		else
			throw new io.cucumber.java.PendingException("Formulário 'Vehicle Data' não carregou corretamente");

		/*verifica se a tela carregou*/
		if(enterInsurantData.verificaCarregamentoInsurant() == true) {
			enterInsurantData.preencherInsurantData();
		}
		else
			throw new io.cucumber.java.PendingException("Formulário 'Insurant Data' não carregou corretamente.");
		
		/*verifica se a tela carregou*/
		if(enterProductData.verificaCarregamentoProduct() == true) {
			enterProductData.preencherProductData();
		}
		else
			throw new io.cucumber.java.PendingException("Formulário 'Product Data' não carregou corretamente.");
		
		/*verifica se a tela carregou*/
		if(selectPriceOption.verificaCarregamentoPriceOption() == true) {
			selectPriceOption.selecionarOpcao();
		}
		else
			throw new io.cucumber.java.PendingException("Tela 'Select Option' não carregou corretamente. Verifique se o preenchimento dos formulários anteriores está correto.");
		
		/*verifica se a tela carregou*/
		if(sendQuote.verificaCarregamentoSendQuote() == true) {
			sendQuote.preencherSendQuote();
		}
		else
			throw new io.cucumber.java.PendingException("Tela 'Send Quote' não carregou corretamente. Verifique se o preenchimento dos formulários anteriores está correto.");
		
	}

	/*uma vez que o botão de enviar quotação é clicado, deve-se surgir uma mensagem na tela confirmando o envio do e-mail*/
	@Então("Uma mensagem de {string} deve aparecer na tela")
	public void uma_mensagem_de_deve_aparecer_na_tela(String alertaEsperado) {
		SendQuote sendQuote = new SendQuote(driver);
		
		Assert.assertEquals(alertaEsperado, sendQuote.retornaMensagem());
		
		driver.close();
	}
}
