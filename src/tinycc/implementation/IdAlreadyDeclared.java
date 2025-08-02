package tinycc.implementation;

public class IdAlreadyDeclared extends RuntimeException {
	public IdAlreadyDeclared(String id) {
		super("Identifier already declared: " + id);
	}
}
