package Exceptions;

public class BadFunctionException extends RuntimeException {
    public BadFunctionException() {
        super("It is impossible to find the extremum point for this function.");
    }
}
