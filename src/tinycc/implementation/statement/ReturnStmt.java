package tinycc.implementation.statement;

import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Expression;


public class ReturnStmt extends Statement {
    private final Locatable loc;
	private final Expression expr;

	public ReturnStmt(Locatable loc, Expression expr) {
		this.loc = loc;
		this.expr = expr;
	}

	@Override
	public String toString() {
		return "Return[" + (expr == null ? "" : expr.toString()) + "]";
	}
    
}
