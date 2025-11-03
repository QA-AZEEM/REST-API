package azt.rest_ful_api.testdatautil;

import com.github.javafaker.Faker;

public class TestData {
	
	private static Faker data = new Faker();
	
	public static int getyear() {
		return data.number().numberBetween(2024, 2030);
	}
	
	public static double getPrice() {
		return data.number().numberBetween(25000, 50000);
	}
	
	public static String getName() {
		return data.options().option("IQOO","XIOMI","IPHONE","SAMSUNG","OPPO");
	}
	
	public static String getSSD() {
		return data.options().option("128","256","512");
	}
	
	public static String getCPUModel() {
		return data.options().option("Snapdragon 8E","MediaTech");
	}
	
	
}
