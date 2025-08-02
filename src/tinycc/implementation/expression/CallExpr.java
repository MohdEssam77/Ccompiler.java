package tinycc.implementation.expression;


import java.util.List;
import java.util.stream.Collectors;

public class CallExpr extends Expression {
	private final Expression callee;
	private final List<Expression> arguments;

	public CallExpr(Expression callee, List<Expression> arguments) {
		this.callee = callee;
		this.arguments = arguments;
	}

	@Override
	public String toString() {
		String args = arguments.stream().map(Object::toString).collect(Collectors.joining(", "));
		return arguments.isEmpty() //Used Chat GPT to fix the error that was failing the ❌testCallNoArgs.
		? "Call[" + callee + "]"
		: "Call[" + callee + " , " + args + "]";
	}
}
