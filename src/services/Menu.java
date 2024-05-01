package services;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.Triangle;

public class Menu {
	
	public void Run() {
		System.out.println("Welcome to the triangle identifier.");
		System.out.println("Please input the length of the sides of your triangle:");
		Triangle triangle = null;
		HumanInterface humanInterface = new HumanInterface(System.in);
		while(triangle == null) {
			double sideA = humanInterface.getPositiveDoubleFromUser("Side A");
			double sideB = humanInterface.getPositiveDoubleFromUser("side B");
			double sideC = humanInterface.getPositiveDoubleFromUser("Side C");
			try {
				triangle = new Triangle(sideA, sideB, sideC); 
			}catch(InvalidTriangleException e) {
				System.out.println(e.getMessage());
			}
		}
		Triangle.TriangleType triangleType = triangle.getTriangleType();
		if(triangleType == Triangle.TriangleType.scalene) {
			System.out.println("Your triangle is a " + triangleType + " triangle.");
		}else {
			System.out.println("Your triangle is an " + triangleType + " triangle.");
		}
	}
}