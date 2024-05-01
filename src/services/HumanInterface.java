package services;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanInterface {
	private InputStream InputStream;
	
	public HumanInterface(InputStream inputStream) {
		this.InputStream = inputStream;
	}
	
	public double getPositiveDoubleFromUser(String valueName) {
		Scanner scanner = new Scanner(InputStream);
		double input = -1.0;
		while(input <= 0.0 || Double.isNaN(input) || !Double.isFinite(input)) {
			System.out.print(valueName + ": ");
			try {
				input = Double.parseDouble(scanner.nextLine());
				if(input <= 0.0 || Double.isNaN(input) || !Double.isFinite(input) ) {
					throw new InputMismatchException();
				}
			}catch(NumberFormatException | InputMismatchException e) {
				System.out.println("Please input a valid, positive number.");
			}
		}
		return input;
	}
}
