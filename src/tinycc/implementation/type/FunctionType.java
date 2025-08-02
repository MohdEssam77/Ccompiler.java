package tinycc.implementation.type;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionType extends Type {
    private final Type returnType;
    private final List<Type> parameters;
    public FunctionType(Type returnType, List<Type> parameters){
        this.returnType = returnType;
        this.parameters = parameters;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
		sb.append("FunctionType[");
		sb.append(returnType.toString());            //Used Chat GPT to come up with this string building idea!

		for (Type param : parameters) {
			sb.append(", ");
			sb.append(param.toString());
		}

		sb.append("]");
		return sb.toString();
    }
}
