package services;

import model.Triangle;

public class TrigenometryCalculator {
	public TrigenometryCalculator() {
		
	}
	public Triangle.TriangleType DetermineTriangleType(Triangle triangle){
		if(triangle.getSideA() == triangle.getSideB() && triangle.getSideA() == triangle.getSideC()) {			//All sides equal
			return Triangle.TriangleType.equilateral;
		}else if((triangle.getSideA() == triangle.getSideB() && triangle.getSideA() != triangle.getSideC())||   //Side A & Side B equal, Side C differs
				  triangle.getSideA() == triangle.getSideC() && triangle.getSideA() != triangle.getSideB() ||   //Side A & Side B equal, Side B differs.
				  triangle.getSideB() == triangle.getSideC() && triangle.getSideB() != triangle.getSideA()   ) {//Side B & Side C equal, Side A differs.
			return Triangle.TriangleType.isosceles;
		}else {
			return Triangle.TriangleType.scalene;
		}
	}
}