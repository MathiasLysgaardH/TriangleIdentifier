package model;

import services.InvalidTriangleException;

public class Triangle {
	private double sideA, sideB, sideC;
	
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
	
	private void Validate() throws InvalidTriangleException {
		if(this.sideA + this.sideB < this.sideC||
		   this.sideA + this.sideC < this.sideB||
		   this.sideB + this.sideC < this.sideA  ) {
			throw new InvalidTriangleException("Described triangle is impossible.");
		}
	}
	
	public enum TriangleType{
		equilateral,
		isosceles,
		scalene
	}
}