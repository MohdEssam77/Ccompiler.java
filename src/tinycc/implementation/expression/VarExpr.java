package tinycc.implementation.expression;

public class VarExpr extends Expression {
    private final String value;
    public VarExpr(String value){
        this.value = value;

    }

    @Override
    public String toString(){
        return "Var_" + value;
    }
}
