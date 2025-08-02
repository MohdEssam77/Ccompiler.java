package tinycc.implementation.type;

import tinycc.parser.TokenKind;

public class BaseType extends Type {
    private final TokenKind kind;

	public BaseType(TokenKind kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		switch (kind) {
			case CHAR:
				return "Type_char";
			case INT:
				return "Type_int";
			case VOID:
				return "Type_void";
			default:
				throw new IllegalArgumentException("Unsupported base type: " + kind);
		}
	}
    
}
