package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class FieldInputData {
	 public static String randamAlpha(int length) {
	        return RandomStringUtils.randomAlphabetic(length);
	    }
	 
	public static String day(int length) {
		Random random = new Random();
		int day = random.nextInt(length)+1;
		return String.valueOf(day);
	}
	
	public static String randomPhoneNumber() {
        Random random = new Random();
        int firstDigit = random.nextInt(9) + 1; 

        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append(firstDigit);

        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }

        return phoneNumber.toString();
    }
	
	public static String todayDate() {
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy");
        String formattedDate = today.format(formatter);
        return formattedDate;
	}

}
