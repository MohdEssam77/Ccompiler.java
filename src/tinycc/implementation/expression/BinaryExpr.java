package tinycc.implementation.expression;


public class BinaryExpr extends Expression {
    private final String op;
    private final Expression left, right;

    public BinaryExpr(String op, Expression left, Expression right){
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString(){
        return "Binary_" + op + "[" + left + ", " + right + "]";
    }
}
