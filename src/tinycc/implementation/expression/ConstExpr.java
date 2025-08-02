package tinycc.implementation.expression;

public class ConstExpr extends Expression {
	private final Object value;
	public ConstExpr(Object value){
		this.value = value;
	}

	@Override
	public String toString(){
		if (value instanceof String){
            return "Const_\"" + value + "\"";
        } else if (value instanceof Character){
            return "Const_'" + value + "'";
        } else{
            return"Const_" + value;
        }
    }
}
