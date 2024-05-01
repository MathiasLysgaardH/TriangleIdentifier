package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import services.HumanInterface;

class HumanInterfaceTest {
	
	@Test
	void TestValidInput() {
		String testInput = "1.0";
		InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
		HumanInterface humanInterface = new HumanInterface(inputStream);
		double output = 0;
		try{
			output = humanInterface.getPositiveDoubleFromUser("test");
		}catch(Exception e) {
			fail("Input is valid.");
		}
		Assertions.assertEquals(output, 1.0);
	}
	
	@Test
	void TestWholeNumberInput() {
		String testInput = "1";
		InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
		HumanInterface humanInterface = new HumanInterface(inputStream);
		double output = 0;
		try{
			output = humanInterface.getPositiveDoubleFromUser("test");
		}catch(Exception e) {
			fail("Input is valid.");
		}
		Assertions.assertEquals(output, 1.0);
	}
	
	@Test
	void TestNaNInput() {
		String testInput = "NaN";
		InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
		HumanInterface humanInterface = new HumanInterface(inputStream);
		double output = 0;
		try{
			output = humanInterface.getPositiveDoubleFromUser("test");
		}catch(Exception e) {
			return;
		}
		fail("NaN is not a valid input.");
	}
	
	@Test
	void TestEmptyInput() {
		String testInput = "";
		InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
		HumanInterface humanInterface = new HumanInterface(inputStream);
		double output = 0;
		try{
			output = humanInterface.getPositiveDoubleFromUser("test");
		}catch(Exception e) {
			return;
		}
		fail("Empty string is not a valid input.");
	}
	
	@Test
	void TestInfinityInput() {
		String testInput = "Infinity";
		InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
		HumanInterface humanInterface = new HumanInterface(inputStream);
		double output = 0;
		try{
			output = humanInterface.getPositiveDoubleFromUser("test");
		}catch(Exception e) {
			return;
		}
		fail("Infinity is not a valid input.");
	}
	
	@Test
	void TestNegativeInput() {
		String testInput = "-1.0";
		InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
		HumanInterface humanInterface = new HumanInterface(inputStream);
		double output = 0;
		try{
			output = humanInterface.getPositiveDoubleFromUser("test");
		}catch(Exception e) {
			return;
		}
		fail("Input must be positive.");
	}
	
	@Test
	void TestEmojiInput() {
		String testInput = "💩";
		InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
		HumanInterface humanInterface = new HumanInterface(inputStream);
		double output = 0;
		try{
			output = humanInterface.getPositiveDoubleFromUser("test");
		}catch(Exception e) {
			return;
		}
		fail("An emoji is not a valid input.");
	}
	
	@Test
	void TestTextInput() {
		String testInput = "Keylane";
		InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
		HumanInterface humanInterface = new HumanInterface(inputStream);
		double output = 0;
		try{
			output = humanInterface.getPositiveDoubleFromUser("test");
		}catch(Exception e) {
			return;
		}
		fail("Text is not a valid input.");
	}
}
