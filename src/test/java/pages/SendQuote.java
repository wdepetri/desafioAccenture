package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendQuote {

	WebDriver driver;

	/*Contruir elementos da página 'Send Quote'*/
	final String EMAIL_TEXTBOX = "E-Mail";
	final String PHONE_TEXTBOX = "Phone";
	final String USERNAME_TEXTBOX = "Username";
	final String PASSWORD_TEXTBOX = "Password";
	final String CONFIRM_PASSWORD_TEXTBOX = "Confirm Password";
	final String RETURN_ALERT_QUOTE = "//*[@id=\"xLoaderQuote\"]/p";
	final String SEND_EMAIL_BUTTON = "Send E-Mail";
	final String ALERT_MESSAGE = "body > div.sweet-alert.showSweetAlert.visible > h2";
	
	/*referenciar o driver*/
	public SendQuote(WebDriver driver) {
		this.driver = driver;
	}

	/*selecionar os campos de dropdown, e enviar os dados esperados pelos campos*/
	public void preencherSendQuote() {

		driver.findElement(By.name(EMAIL_TEXTBOX)).sendKeys("xpto@gmail.com");
		driver.findElement(By.name(PHONE_TEXTBOX)).sendKeys("05511912345678");                /*telefone deve conter apenas caracteres numericos*/
		driver.findElement(By.name(USERNAME_TEXTBOX)).sendKeys("XPTO");
		driver.findElement(By.name(PASSWORD_TEXTBOX)).sendKeys("ThisIsMyPassword42");         /*senha precisa ter caracteres maiusculos, minusculos, e numeros*/
		driver.findElement(By.name(CONFIRM_PASSWORD_TEXTBOX)).sendKeys("ThisIsMyPassword42"); /*senha precisa ter caracteres maiusculos, minusculos, e numeros*/

		driver.findElement(By.name(SEND_EMAIL_BUTTON)).click();
	}

	/*função que retorna a mensagem de envio de e-mail, a ser comparada com a mensagem esperada*/
	public String retornaMensagem() {
		return driver.findElement(By.cssSelector(ALERT_MESSAGE)).getText();	
	}
	
	/*função que verifica se a página está carregada corretamente*/
	public boolean verificaCarregamentoSendQuote() {
		if (driver.findElement(By.xpath(RETURN_ALERT_QUOTE)).isDisplayed()) {
			return false;
		}
		else
			return true;
	}
}
