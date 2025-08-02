package tinycc.implementation.statement;

import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Expression;

public class ExpressionStmt extends Statement {
    private final Locatable loc;
	private final Expression expr;

	public ExpressionStmt(Locatable loc, Expression expr) {
		this.loc = loc;
		this.expr = expr;
	}

	@Override
	public String toString() {
		return expr.toString();
	}
    
}
