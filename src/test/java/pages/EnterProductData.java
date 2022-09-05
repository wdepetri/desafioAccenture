package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterProductData {
	
	WebDriver driver;
	
	/*Contruir elementos da página 'Product Data'*/
	final String START_DATE_DATEPICKER = "Start Date";
	final String INSURANCE_10M = "#insurancesum > option:nth-child(5)";
	final String MERIT_MALUS15 = "#meritrating > option:nth-child(17)";
	final String DAMAGE_INSURANCE_FULL = "#damageinsurance > option:nth-child(4)";
	final String OPTIONAL_EURO = "//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span";
	final String OPTIONAL_LEGAL_DEFENSE = "//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[2]/span";
	final String COURTESY_YES = "#courtesycar > option:nth-child(3)";
	final String NEXT_BUTTON_PRODUCT = "Next (Select Price Option)";
	
	/*referenciar o driver*/
	public EnterProductData(WebDriver driver) {
		this.driver = driver;
	}
	
	/*selecionar os campos de dropdown (selecionados aleatriamente), e enviar os dados esperados pelos campos*/
	public void preencherProductData() {
		
		driver.findElement(By.name(START_DATE_DATEPICKER)).sendKeys("09/01/2023"); /*data deve ser pelo menos 1 mês adiante da data atual*/
		driver.findElement(By.cssSelector(INSURANCE_10M)).click();
		driver.findElement(By.cssSelector(MERIT_MALUS15)).click();
		driver.findElement(By.cssSelector(DAMAGE_INSURANCE_FULL)).click();
		driver.findElement(By.xpath(OPTIONAL_EURO)).click();
		driver.findElement(By.xpath(OPTIONAL_LEGAL_DEFENSE)).click();
		driver.findElement(By.cssSelector(COURTESY_YES)).click();
		
		driver.findElement(By.name(NEXT_BUTTON_PRODUCT)).click();
	}
	
	/*função que verifica se a página está carregada corretamente*/
	public boolean verificaCarregamentoProduct() {
		if (driver.findElement(By.name(NEXT_BUTTON_PRODUCT)).isDisplayed()) {
			return true;
		}
		else
			return false;
	}

}
