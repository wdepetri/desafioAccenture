package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterInsurantData {
	
	WebDriver driver;
	
	/*Contruir elementos da página 'Insurant Data'*/
	final String FIRST_NAME_TEXTBOX = "First Name";
	final String LAST_NAME_TEXTBOX = "Last Name";
	final String BIRTHDATE_DATEPICKER = "Date of Birth";
	final String GENDER_MALE = "#insurance-form > div > section:nth-child(2) > div:nth-child(4) > p > label:nth-child(1) > span";
	final String STREET_TEXTBOX = "Street Address";
	final String COUNTRY_BRAZIL = "#country > option:nth-child(32)";
	final String ZIP_CODE_TEXTBOX = "Zip Code";
	final String CITY_TEXTBOX = "City";
	final String OCCUPATION_UNEMPLOYED = "#occupation > option:nth-child(5)";
	final String HOBBIES_BUNGEE_JUMPING = "//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[2]/span";
	final String HOBBIES_SKYDIVING = "//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[4]/span";
	final String WEBSITE_TEXTBOX = "Website";
	final String NEXT_BUTTON_INSURANT = "Next (Enter Product Data)";
	
	/*referenciar o driver*/
	public EnterInsurantData(WebDriver driver) {
		this.driver = driver;
	}
	
	/*selecionar os campos de dropdown (selecionados aleatoriamente), e enviar os dados esperados pelos campos*/
	public void preencherInsurantData() {
		
		driver.findElement(By.name(FIRST_NAME_TEXTBOX)).sendKeys("William");           /*nome não pode conter caracteres numéricos*/
		driver.findElement(By.name(LAST_NAME_TEXTBOX)).sendKeys("Depetri");            /*sobrenome não pode conter caracteres numéricos*/
		driver.findElement(By.name(BIRTHDATE_DATEPICKER)).sendKeys("10/20/1991");      /*idade deve ter entre 18 e 70 anos*/
		driver.findElement(By.cssSelector(GENDER_MALE)).click();
		driver.findElement(By.name(STREET_TEXTBOX)).sendKeys("Whatever Street, 42");
		driver.findElement(By.cssSelector(COUNTRY_BRAZIL)).click();
		driver.findElement(By.name(ZIP_CODE_TEXTBOX)).sendKeys("12345678");            /*código de área deve conter apenas caracteres numéricos*/
		driver.findElement(By.name(CITY_TEXTBOX)).sendKeys("São Paulo");
		driver.findElement(By.cssSelector(OCCUPATION_UNEMPLOYED)).click();
		driver.findElement(By.xpath(HOBBIES_BUNGEE_JUMPING)).click();
		driver.findElement(By.xpath(HOBBIES_SKYDIVING)).click();
		driver.findElement(By.name(WEBSITE_TEXTBOX)).sendKeys("https://www.accenture.com/br-pt");
		
		driver.findElement(By.name(NEXT_BUTTON_INSURANT)).click();
	}
	
	/*função que verifica se a página está carregada corretamente*/
	public boolean verificaCarregamentoInsurant() {
		if (driver.findElement(By.name(NEXT_BUTTON_INSURANT)).isDisplayed()) {
			return true;
		}
		else
			return false;
	}

}
