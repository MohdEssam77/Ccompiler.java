package tinycc.implementation.statement;

import java.util.List;
import java.util.stream.Collectors;
import tinycc.diagnostic.Locatable;

public class BlockStmt extends Statement {
    private final Locatable loc;
	private final List<Statement> statements;

	public BlockStmt(Locatable loc, List<Statement> statements) {
		this.loc = loc;
		this.statements = statements;
	}

	@Override
	public String toString() {
		String content = statements.stream()
				.map(Object::toString)
				.collect(Collectors.joining(" , "));
		return "Block [" + content + "]";
	}
}
