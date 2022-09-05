package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectPriceOption {

	WebDriver driver;

	/*Contruir elementos relevantes da página 'Price Option'*/
	final String OPCAO_PLATINUM = "#priceTable > tfoot > tr > th.group > label:nth-child(3) > span";
	final String RETURN_ALERT_PRICE = "//*[@id=\"xLoaderPrice\"]/p";
	final String NEXT_BUTTON_PRICE = "Next (Send Quote)";

	/*referenciar o driver*/
	public SelectPriceOption(WebDriver driver) {
		this.driver = driver;
	}

	/*selecionar uma das opções*/
	public void selecionarOpcao() {

		driver.findElement(By.cssSelector(OPCAO_PLATINUM)).click(); /*selecionada uma das 4 opções disponíveis*/

		driver.findElement(By.name(NEXT_BUTTON_PRICE)).click();
	}

	/*função que verifica se a página está carregada corretamente*/
	public boolean verificaCarregamentoPriceOption() {
		if (driver.findElement(By.xpath(RETURN_ALERT_PRICE)).isDisplayed()) {
			return false;
		} else
			return true;
	}
}
