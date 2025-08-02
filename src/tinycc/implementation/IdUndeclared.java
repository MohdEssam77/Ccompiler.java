package tinycc.implementation;


public class IdUndeclared extends RuntimeException {
	public IdUndeclared(String id) {
		super("Identifier not declared: " + id);
	}
}