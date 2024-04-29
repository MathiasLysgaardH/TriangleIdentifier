package services;

public class InvalidTriangleException extends Exception{
	public InvalidTriangleException(String errorMessage) {
		super(errorMessage);
	}
}