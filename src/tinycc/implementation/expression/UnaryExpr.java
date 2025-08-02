package tinycc.implementation.expression;

public class UnaryExpr extends Expression {
	private final String operator;
	private final boolean isPostfix;
	private final Expression operand;

	public UnaryExpr(String operator, boolean isPostfix, Expression operand) {
		this.operator = operator;
		this.isPostfix = isPostfix;
		this.operand = operand;
	}

	@Override
	public String toString() {
		return (isPostfix ? "PostUnary_" : "Unary_") + operator + "[" + operand + "]";
	}
}
