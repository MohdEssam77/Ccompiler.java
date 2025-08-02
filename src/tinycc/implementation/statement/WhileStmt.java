package tinycc.implementation.statement;

import tinycc.implementation.expression.Expression;
import tinycc.diagnostic.Locatable;


public class WhileStmt extends Statement {
    private final Expression condition;
    private final Statement body;

    public WhileStmt(Locatable loc, Expression condition, Statement body){
        this.condition = condition;
        this.body = body;

    }

    @Override
    public String toString(){
        return "While[" + condition + ", " + body + "]";
    }
    
}
