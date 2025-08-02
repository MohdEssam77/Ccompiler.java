package tinycc.implementation.statement;

import tinycc.implementation.expression.Expression;
import tinycc.implementation.type.Type;
import tinycc.parser.Token;

public class DeclarationStmt extends Statement {
    private final String name;
	private final Type type;
	private final Expression init;

	public DeclarationStmt(Type type, Token name, Expression init) {
		this.name = name.getText();
		this.type = type;
		this.init = init;
	}

	@Override
	public String toString() {
		if (init == null) {
			return "Declaration_" + name + " [" + type + "]";
		} else {
			return "Declaration_" + name + " [" + type + ", " + init + "]";
		}
	}
    
}
