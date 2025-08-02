package tinycc.implementation;
import tinycc.parser.ASTFactory;
import tinycc.parser.Token;
import tinycc.parser.TokenKind;
import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.*;
import tinycc.implementation.statement.*;
import tinycc.implementation.type.*;

import java.util.ArrayList;
import java.util.List;

public class ASTFactory7 implements ASTFactory {
    private final List<Statement> externalDecls = new ArrayList<>();
    public List<Statement> getExternalDeclarations() {
		return externalDecls;
	}

    @Override
    public Type createBaseType(TokenKind kind) {
	    return new BaseType(kind);
    }

    @Override
    public Type createPointerType(Type pointsTo) {
	    return new PointerType(pointsTo);
    }

    @Override
    public Type createFunctionType(Type returnType, List<Type> paramenters){
        return new FunctionType(returnType, paramenters);
    }

    @Override
    public Expression createPrimaryExpression(Token token) {
    	switch (token.getKind()) {
    		case NUMBER:
    			return new ConstExpr(Integer.parseInt(token.getText()));
            case CHARACTER:
			    return new ConstExpr(token.getText().charAt(0));
		    case STRING:
			    return new ConstExpr(token.getText());
    		case IDENTIFIER:
    			return new VarExpr(token.getText());
    		default:
    			throw new UnsupportedOperationException("Unsupported primary expression: " + token);
    	}
    }

    @Override
    public Expression createBinaryExpression(Token operator, Expression left, Expression right) {
    	return new BinaryExpr(operator.getText(), left, right);
    }

    @Override
    public Expression createUnaryExpression(Token operator, boolean postfix, Expression operand) {
    	return new UnaryExpr(operator.getText(), postfix, operand);
    }

    @Override
    public Expression createCallExpression(Token token, Expression callee, List<Expression> arguments) {
    	return new CallExpr(callee, arguments);
    }

    @Override
    public Statement createReturnStatement(Locatable loc, Expression expression) {
    	return new ReturnStmt(loc, expression);
    }

    @Override
    public Statement createDeclarationStatement(Type type, Token name, Expression init) {
    	return new DeclarationStmt(type, name, init);
    }

    @Override
    public Statement createExpressionStatement(Locatable loc, Expression expression) {
    	return new ExpressionStmt(loc, expression);
    }

    @Override
    public Statement createBlockStatement(Locatable loc, List<Statement> statements) {
    	return new BlockStmt(loc, statements);
    }

    @Override
    public Statement createIfStatement(Locatable loc, Expression condition, Statement consequence, Statement alternative) {
    	return new IfStmt(loc, condition, consequence, alternative);
    }

    @Override
    public Expression createConditionalExpression(Token token, Expression condition, Expression consequence,
                                                  Expression alternative) {
    	throw new UnsupportedOperationException("Conditional expressions are not supported.");
    }

    @Override
    public Statement createWhileStatement(Locatable loc, Expression condition, Statement body) {
    	return new WhileStmt(loc, condition, body);
    }

    @Override
    public void createExternalDeclaration(Type type, Token name) {
    	externalDecls.add(new DeclarationStmt(type, name, null));
    }

    @Override
    public void createFunctionDefinition(Type type, Token name, List<Token> parameterNames, Statement body) {
    	externalDecls.add(new FunctionDefinition(type, name.getText(), parameterNames, body));
    }


}
