package services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Triangle;

public class Menu {
	public Menu() {
		
	}
	
	public void Run() {
		System.out.println("Welcome to the triangle identifier.");
		System.out.println("Please input the length of the sides of your triangle:");
		Triangle triangle = null;
		while(triangle == null) {
			double sideA = getPositiveDoubleFromUser("Side A");
			double sideB = getPositiveDoubleFromUser("side B");
			double sideC = getPositiveDoubleFromUser("Side C");
			try {
				triangle = new Triangle(sideA, sideB, sideC); 
			}catch(InvalidTriangleException e) {
				System.out.println(e.getMessage());
			}
		}
		TrigenometryCalculator calculator = new TrigenometryCalculator();
		Triangle.TriangleType triangleType = calculator.DetermineTriangleType(triangle);
		if(triangleType == Triangle.TriangleType.scalene) {
			System.out.println("Your triangle is a " + triangleType + " triangle.");
		}else {
			System.out.println("Your triangle is an " + triangleType + " triangle.");
		}
	}
		
	
	private double getPositiveDoubleFromUser(String valueName) {
		Scanner scanner = new Scanner(System.in);
		double input = -1.0;
		while(input <= 0.0) {
			System.out.print(valueName + ": ");
			try {
				input = scanner.nextDouble();
				if(input <= 0.0) {
					throw new InputMismatchException();
				}
			}catch(InputMismatchException e) {
				System.out.println("Please input a valid, positive number.");
				scanner.nextLine();
			}
		}
		return input;
	}
}
