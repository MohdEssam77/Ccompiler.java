package tinycc.implementation.type;

public class PointerType extends Type {
    private final Type pointsTo;

	public PointerType(Type pointsTo) {
		this.pointsTo = pointsTo;
	}

	@Override
	public String toString() {
		return "Pointer[" + pointsTo.toString() + "]";
	}
    
}
