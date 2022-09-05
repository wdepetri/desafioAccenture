package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterVehicleData {

	WebDriver driver;
	
	/*Contruir elementos da página 'Vehicle Data'*/
	final String MAKE_AUDI = "#make > option:nth-child(2)";
	final String MODEL_SCOOTER = "#model > option:nth-child(2)";
	final String CYLINDER_TEXTBOX = "Cylinder Capacity";
	final String ENGINE_TEXTBOX = "[kW]";
	final String DATE_MANUFACTURE_DATEPICKER = "Date of Manufacture";
	final String NUMBER_SEATS_2 = "#numberofseats > option:nth-child(3)";
	final String RHD_YES = "#insurance-form > div > section:nth-child(1) > div:nth-child(7) > p > label:nth-child(1) > span";
	final String SEATS_MOTO_2 = "#numberofseatsmotorcycle > option:nth-child(3)";
	final String FUEL_GAS = "#fuel > option:nth-child(5)";
	final String PAYLOAD_TEXTBOX = "Payload";
	final String LIST_PRICE_TEXTBOX = "List Price";
	final String TOTAL_WEIGHT_TEXTBOX = "Total Weight";
	final String LICENSE_PLATE_TEXTBOX = "License Plate Number";
	final String ANNUAL_MILEAGE_TEXTBOX = "Annual Mileage";
	final String NEXT_BUTTON_VEHICLE = "Next (Enter Insurant Data)";

	/*referenciar o driver*/
	public EnterVehicleData(WebDriver driver) {
		this.driver = driver;
	}

	/*selecionar os campos de dropdown (selecionados aleatoriamente), e enviar os dados esperados pelos campos*/
	public void preencherVehicleData() {
		driver.findElement(By.cssSelector(MAKE_AUDI)).click();
		driver.findElement(By.cssSelector(MODEL_SCOOTER)).click();
		driver.findElement(By.name(CYLINDER_TEXTBOX)).sendKeys("250");                   /*capacidade  deve ser um número entrer 1 e 2.000*/
		driver.findElement(By.name(ENGINE_TEXTBOX)).sendKeys("1000");                    /*performance motor  deve ser um número entre 1 e 2.000*/
		driver.findElement(By.name(DATE_MANUFACTURE_DATEPICKER)).sendKeys("09/01/2022"); /*fabricação não pode ser uma data futura a hoje*/
		driver.findElement(By.cssSelector(NUMBER_SEATS_2)).click();
		driver.findElement(By.cssSelector(RHD_YES)).click();
		driver.findElement(By.cssSelector(SEATS_MOTO_2)).click();
		driver.findElement(By.cssSelector(FUEL_GAS)).click();
		driver.findElement(By.name(PAYLOAD_TEXTBOX)).sendKeys("500");                    /*payload deve ser um número entre 1 e 1.000*/
		driver.findElement(By.name(LIST_PRICE_TEXTBOX)).sendKeys("3500");                /*preço deve ser um número entre 500 e 100.000*/
		driver.findElement(By.name(TOTAL_WEIGHT_TEXTBOX)).sendKeys("50000");             /*peso deve ser um número entre 100 e 50.000*/
		driver.findElement(By.name(LICENSE_PLATE_TEXTBOX)).sendKeys("FPZ3993");          /*PLACA DEVE TER NO MÁXIMO 10 CARACTERES*/
		driver.findElement(By.name(ANNUAL_MILEAGE_TEXTBOX)).sendKeys("200");             /*milhagem deve ser um número entre 100 e 100.000*/

		driver.findElement(By.name(NEXT_BUTTON_VEHICLE)).click();
	}
	
	/*função que verifica se a página está carregada corretamente*/
	public boolean verificaCarregamentoVehicle() {
		if (driver.findElement(By.name(NEXT_BUTTON_VEHICLE)).isDisplayed()) {
			return true;
		}
		else
			return false;
	}
}
