package tinycc.implementation.statement;
import tinycc.implementation.type.Type;
import tinycc.parser.Token;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionDefinition extends Statement {
    private final String name;
	private final Type type;
	private final List<Token> parameterNames;
	private final Statement body;

	public FunctionDefinition(Type type, String name, List<Token> parameterNames, Statement body) {
		this.name = name;
		this.type = type;
		this.parameterNames = parameterNames;
		this.body = body;
	}

	@Override
	public String toString() {
		String params = parameterNames.stream()
			.map(Token::getText)
			.collect(Collectors.joining(" , "));
		return "Function_" + name + " [ " + type + 
			(parameterNames.isEmpty() ? "" : " , " + params) +
			" , " + body + " ]";
	}
}
