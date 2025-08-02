package tinycc.implementation.statement;

import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Expression;

public class IfStmt extends Statement {
    private final Expression condition;
	private final Statement thenStmt;
	private final Statement elseStmt;

	public IfStmt(Locatable loc, Expression condition, Statement thenStmt, Statement elseStmt) {
		this.condition = condition;
		this.thenStmt = thenStmt;
		this.elseStmt = elseStmt;
	}

	@Override
	public String toString() {
		return "If[" + condition + ", " + thenStmt +
				(elseStmt != null ? ", " + elseStmt : "") + "]";
	}
    
}
