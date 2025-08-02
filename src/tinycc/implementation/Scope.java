package tinycc.implementation;

import tinycc.implementation.statement.DeclarationStmt;
import java.util.HashMap;
import java.util.Map;

public class Scope {
	private final Map<String, DeclarationStmt> table;
	private final Scope parent;

	public Scope() {
		this(null);
	}

	private Scope(Scope parent) {
		this.parent = parent;
		this.table = new HashMap<>();
	}

	public Scope newNestedScope() {
		return new Scope(this);
	}

	public void add(String id, DeclarationStmt decl) throws IdAlreadyDeclared {
		if (table.containsKey(id))
			throw new IdAlreadyDeclared(id);
		table.put(id, decl);
	}

	public DeclarationStmt lookup(String id) throws IdUndeclared {
		if (table.containsKey(id)) return table.get(id);
		if (parent != null) return parent.lookup(id);
		throw new IdUndeclared(id);
	}
}
