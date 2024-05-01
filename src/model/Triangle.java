package model;

import services.InvalidTriangleException;
import services.TrigonometryCalculator;

public class Triangle {
	private double sideA, sideB, sideC;
	private TriangleType triangleType;
	
	public Triangle(double sideA, double sideB, double sideC) throws InvalidTriangleException {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		Validate();
	}

	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public void setSideC(double sideC) {
		this.sideC = sideC;
	}
	
	
	public TriangleType getTriangleType() {
		TrigonometryCalculator calculator = new TrigonometryCalculator();
		return calculator.DetermineTriangleType(this);
	}

	
	private void Validate() throws InvalidTriangleException {
		if(sideA <= 0 || sideB <= 0 || sideC <= 0 ) {
			throw new InvalidTriangleException("Triangle cannot have negative-length sides");
		}else if(this.sideA + this.sideB <= this.sideC||
				 this.sideA + this.sideC <= this.sideB||
				 this.sideB + this.sideC <= this.sideA  ) {
			throw new InvalidTriangleException("Described triangle is impossible.");
		}
	}

	public enum TriangleType{
		equilateral,
		isosceles,
		scalene
	}
}