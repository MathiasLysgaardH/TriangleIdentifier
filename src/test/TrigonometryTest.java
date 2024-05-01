package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Triangle;
import services.HumanInterface;
import services.InvalidTriangleException;
import services.TrigonometryCalculator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class TrigonometryTest {

	@Test
	void CreateTriangleTest() {
		Triangle triangle = null;
		try {
			triangle = new Triangle(1.0, 2.0, 1.5);
		} catch (InvalidTriangleException e) {
			fail("this triangle is valid");
		}
		Assertions.assertFalse(triangle == null);
	}
	
	@Test
	void CreateNegativeLengthSideTriangle() {
		Triangle triangleA = null, triangleB = null, triangleC = null;
		try {
			triangleA = new Triangle(-1.0, 2.0, 1.0);
			triangleB = new Triangle(1.0, -1.0, 1.0);
			triangleC = new Triangle(1.0, 2.0, -1.5);
		} catch (InvalidTriangleException e) {
			return;
		}
		fail("Triangle created with negative length.");
	}
	
	@Test
	void CreateImpossibleTriangle() {
		Triangle triangle = null;
		try {
			triangle = new Triangle(1.0, 1.0, 50.0);
			triangle = new Triangle(1.0, 50.0, 1.0);
			triangle = new Triangle(50.0, 1.0, 1.0);
		}catch (InvalidTriangleException e) {
			return;
		}
		fail("Impossible triangle created");
	}
	
	@Test
	void CreateEquilateralTriange() {
		Triangle triangle = null;
		try {
			triangle = new Triangle(1.0, 1.0, 1.0);
		} catch (InvalidTriangleException e) {
			fail("This triangle is valid");
		}
		Assertions.assertEquals(triangle.getTriangleType(), Triangle.TriangleType.equilateral);
	}
	
	@Test
	void CreateIsoscelesTriange() {
		Triangle triangleAB = null, triangleAC = null, triangleBC = null;
		try {
			triangleAB = new Triangle(2.0, 2.0, 1.0);
			triangleAC = new Triangle(2.0, 1.0, 2.0);
			triangleBC = new Triangle(1.0, 2.0, 2.0); 
		} catch (InvalidTriangleException e) {
			fail("this triangle is valid");
		}
		Assertions.assertEquals(triangleAB.getTriangleType(), Triangle.TriangleType.isosceles);
		Assertions.assertEquals(triangleAC.getTriangleType(), Triangle.TriangleType.isosceles);
		Assertions.assertEquals(triangleBC.getTriangleType(), Triangle.TriangleType.isosceles);
	}
	
	@Test
	void CreateScaleneTriangle() {
		Triangle triangle = null;
		try {
			triangle = new Triangle(1.0, 2.0, 1.5);
		} catch (InvalidTriangleException e) {
			fail("This triangle is valid");
		}
		Assertions.assertEquals(triangle.getTriangleType(), Triangle.TriangleType.scalene);
	}
}
