/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.analysis;

import java.util.*;
import sablecc.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getPForm().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inAUsingForm(AUsingForm node)
    {
        defaultIn(node);
    }

    public void outAUsingForm(AUsingForm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAUsingForm(AUsingForm node)
    {
        inAUsingForm(node);
        if(node.getForm() != null)
        {
            node.getForm().apply(this);
        }
        outAUsingForm(node);
    }

    public void inANamespaceForm(ANamespaceForm node)
    {
        defaultIn(node);
    }

    public void outANamespaceForm(ANamespaceForm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANamespaceForm(ANamespaceForm node)
    {
        inANamespaceForm(node);
        if(node.getForm() != null)
        {
            node.getForm().apply(this);
        }
        outANamespaceForm(node);
    }

    public void inAClassCForm(AClassCForm node)
    {
        defaultIn(node);
    }

    public void outAClassCForm(AClassCForm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAClassCForm(AClassCForm node)
    {
        inAClassCForm(node);
        if(node.getForm() != null)
        {
            node.getForm().apply(this);
        }
        {
            List<PMethod> copy = new ArrayList<PMethod>(node.getMethodDefinitions());
            for(PMethod e : copy)
            {
                e.apply(this);
            }
        }
        outAClassCForm(node);
    }

    public void inAMainForm(AMainForm node)
    {
        defaultIn(node);
    }

    public void outAMainForm(AMainForm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMainForm(AMainForm node)
    {
        inAMainForm(node);
        {
            List<PVariable> copy = new ArrayList<PVariable>(node.getVariableDefinitions());
            for(PVariable e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatements());
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        outAMainForm(node);
    }

    public void inAParameter(AParameter node)
    {
        defaultIn(node);
    }

    public void outAParameter(AParameter node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParameter(AParameter node)
    {
        inAParameter(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAParameter(node);
    }

    public void inAMethod(AMethod node)
    {
        defaultIn(node);
    }

    public void outAMethod(AMethod node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMethod(AMethod node)
    {
        inAMethod(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getReturnType() != null)
        {
            node.getReturnType().apply(this);
        }
        {
            List<PParameter> copy = new ArrayList<PParameter>(node.getParameterDefinitions());
            for(PParameter e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVariable> copy = new ArrayList<PVariable>(node.getVariableDefinitions());
            for(PVariable e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatements());
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        outAMethod(node);
    }

    public void inAVoidReturnType(AVoidReturnType node)
    {
        defaultIn(node);
    }

    public void outAVoidReturnType(AVoidReturnType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVoidReturnType(AVoidReturnType node)
    {
        inAVoidReturnType(node);
        outAVoidReturnType(node);
    }

    public void inAIntReturnType(AIntReturnType node)
    {
        defaultIn(node);
    }

    public void outAIntReturnType(AIntReturnType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntReturnType(AIntReturnType node)
    {
        inAIntReturnType(node);
        outAIntReturnType(node);
    }

    public void inADoubleReturnType(ADoubleReturnType node)
    {
        defaultIn(node);
    }

    public void outADoubleReturnType(ADoubleReturnType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADoubleReturnType(ADoubleReturnType node)
    {
        inADoubleReturnType(node);
        outADoubleReturnType(node);
    }

    public void inAStringReturnType(AStringReturnType node)
    {
        defaultIn(node);
    }

    public void outAStringReturnType(AStringReturnType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringReturnType(AStringReturnType node)
    {
        inAStringReturnType(node);
        outAStringReturnType(node);
    }

    public void inABoolReturnType(ABoolReturnType node)
    {
        defaultIn(node);
    }

    public void outABoolReturnType(ABoolReturnType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABoolReturnType(ABoolReturnType node)
    {
        inABoolReturnType(node);
        outABoolReturnType(node);
    }

    public void inAIntType(AIntType node)
    {
        defaultIn(node);
    }

    public void outAIntType(AIntType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntType(AIntType node)
    {
        inAIntType(node);
        outAIntType(node);
    }

    public void inADoubleType(ADoubleType node)
    {
        defaultIn(node);
    }

    public void outADoubleType(ADoubleType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADoubleType(ADoubleType node)
    {
        inADoubleType(node);
        outADoubleType(node);
    }

    public void inAStringType(AStringType node)
    {
        defaultIn(node);
    }

    public void outAStringType(AStringType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringType(AStringType node)
    {
        inAStringType(node);
        outAStringType(node);
    }

    public void inABoolType(ABoolType node)
    {
        defaultIn(node);
    }

    public void outABoolType(ABoolType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABoolType(ABoolType node)
    {
        inABoolType(node);
        outABoolType(node);
    }

    public void inADeclarationVariable(ADeclarationVariable node)
    {
        defaultIn(node);
    }

    public void outADeclarationVariable(ADeclarationVariable node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADeclarationVariable(ADeclarationVariable node)
    {
        inADeclarationVariable(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outADeclarationVariable(node);
    }

    public void inAInitializationVariable(AInitializationVariable node)
    {
        defaultIn(node);
    }

    public void outAInitializationVariable(AInitializationVariable node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInitializationVariable(AInitializationVariable node)
    {
        inAInitializationVariable(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAInitializationVariable(node);
    }

    public void inAIntLiteral(AIntLiteral node)
    {
        defaultIn(node);
    }

    public void outAIntLiteral(AIntLiteral node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntLiteral(AIntLiteral node)
    {
        inAIntLiteral(node);
        if(node.getIntLiteral() != null)
        {
            node.getIntLiteral().apply(this);
        }
        outAIntLiteral(node);
    }

    public void inADoubleLiteral(ADoubleLiteral node)
    {
        defaultIn(node);
    }

    public void outADoubleLiteral(ADoubleLiteral node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADoubleLiteral(ADoubleLiteral node)
    {
        inADoubleLiteral(node);
        if(node.getDoubleLiteral() != null)
        {
            node.getDoubleLiteral().apply(this);
        }
        outADoubleLiteral(node);
    }

    public void inAStringLiteral(AStringLiteral node)
    {
        defaultIn(node);
    }

    public void outAStringLiteral(AStringLiteral node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringLiteral(AStringLiteral node)
    {
        inAStringLiteral(node);
        if(node.getStringLiteral() != null)
        {
            node.getStringLiteral().apply(this);
        }
        outAStringLiteral(node);
    }

    public void inABoolLiteral(ABoolLiteral node)
    {
        defaultIn(node);
    }

    public void outABoolLiteral(ABoolLiteral node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABoolLiteral(ABoolLiteral node)
    {
        inABoolLiteral(node);
        if(node.getBoolLiteral() != null)
        {
            node.getBoolLiteral().apply(this);
        }
        outABoolLiteral(node);
    }

    public void inALogicalOrExpression(ALogicalOrExpression node)
    {
        defaultIn(node);
    }

    public void outALogicalOrExpression(ALogicalOrExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALogicalOrExpression(ALogicalOrExpression node)
    {
        inALogicalOrExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outALogicalOrExpression(node);
    }

    public void inALogicalAndExpression(ALogicalAndExpression node)
    {
        defaultIn(node);
    }

    public void outALogicalAndExpression(ALogicalAndExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALogicalAndExpression(ALogicalAndExpression node)
    {
        inALogicalAndExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outALogicalAndExpression(node);
    }

    public void inACmpNotEqualsExpression(ACmpNotEqualsExpression node)
    {
        defaultIn(node);
    }

    public void outACmpNotEqualsExpression(ACmpNotEqualsExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACmpNotEqualsExpression(ACmpNotEqualsExpression node)
    {
        inACmpNotEqualsExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outACmpNotEqualsExpression(node);
    }

    public void inACmpEqualsExpression(ACmpEqualsExpression node)
    {
        defaultIn(node);
    }

    public void outACmpEqualsExpression(ACmpEqualsExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACmpEqualsExpression(ACmpEqualsExpression node)
    {
        inACmpEqualsExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outACmpEqualsExpression(node);
    }

    public void inACmpSmallerExpression(ACmpSmallerExpression node)
    {
        defaultIn(node);
    }

    public void outACmpSmallerExpression(ACmpSmallerExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACmpSmallerExpression(ACmpSmallerExpression node)
    {
        inACmpSmallerExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outACmpSmallerExpression(node);
    }

    public void inACmpGreaterExpression(ACmpGreaterExpression node)
    {
        defaultIn(node);
    }

    public void outACmpGreaterExpression(ACmpGreaterExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACmpGreaterExpression(ACmpGreaterExpression node)
    {
        inACmpGreaterExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outACmpGreaterExpression(node);
    }

    public void inACmpEqualsSmallerExpression(ACmpEqualsSmallerExpression node)
    {
        defaultIn(node);
    }

    public void outACmpEqualsSmallerExpression(ACmpEqualsSmallerExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACmpEqualsSmallerExpression(ACmpEqualsSmallerExpression node)
    {
        inACmpEqualsSmallerExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outACmpEqualsSmallerExpression(node);
    }

    public void inACmpEqualsGreaterExpression(ACmpEqualsGreaterExpression node)
    {
        defaultIn(node);
    }

    public void outACmpEqualsGreaterExpression(ACmpEqualsGreaterExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACmpEqualsGreaterExpression(ACmpEqualsGreaterExpression node)
    {
        inACmpEqualsGreaterExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outACmpEqualsGreaterExpression(node);
    }

    public void inASubExpression(ASubExpression node)
    {
        defaultIn(node);
    }

    public void outASubExpression(ASubExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASubExpression(ASubExpression node)
    {
        inASubExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outASubExpression(node);
    }

    public void inAAddExpression(AAddExpression node)
    {
        defaultIn(node);
    }

    public void outAAddExpression(AAddExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAddExpression(AAddExpression node)
    {
        inAAddExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAAddExpression(node);
    }

    public void inAModExpression(AModExpression node)
    {
        defaultIn(node);
    }

    public void outAModExpression(AModExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAModExpression(AModExpression node)
    {
        inAModExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAModExpression(node);
    }

    public void inADivExpression(ADivExpression node)
    {
        defaultIn(node);
    }

    public void outADivExpression(ADivExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivExpression(ADivExpression node)
    {
        inADivExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outADivExpression(node);
    }

    public void inAMultExpression(AMultExpression node)
    {
        defaultIn(node);
    }

    public void outAMultExpression(AMultExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultExpression(AMultExpression node)
    {
        inAMultExpression(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAMultExpression(node);
    }

    public void inANotExpression(ANotExpression node)
    {
        defaultIn(node);
    }

    public void outANotExpression(ANotExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANotExpression(ANotExpression node)
    {
        inANotExpression(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outANotExpression(node);
    }

    public void inAMinusExpression(AMinusExpression node)
    {
        defaultIn(node);
    }

    public void outAMinusExpression(AMinusExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMinusExpression(AMinusExpression node)
    {
        inAMinusExpression(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAMinusExpression(node);
    }

    public void inAPlusExpression(APlusExpression node)
    {
        defaultIn(node);
    }

    public void outAPlusExpression(APlusExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusExpression(APlusExpression node)
    {
        inAPlusExpression(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAPlusExpression(node);
    }

    public void inAParenthesisExpression(AParenthesisExpression node)
    {
        defaultIn(node);
    }

    public void outAParenthesisExpression(AParenthesisExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParenthesisExpression(AParenthesisExpression node)
    {
        inAParenthesisExpression(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAParenthesisExpression(node);
    }

    public void inAFunctionExpression(AFunctionExpression node)
    {
        defaultIn(node);
    }

    public void outAFunctionExpression(AFunctionExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFunctionExpression(AFunctionExpression node)
    {
        inAFunctionExpression(node);
        if(node.getFunction() != null)
        {
            node.getFunction().apply(this);
        }
        {
            List<PExpression> copy = new ArrayList<PExpression>(node.getParameters());
            for(PExpression e : copy)
            {
                e.apply(this);
            }
        }
        outAFunctionExpression(node);
    }

    public void inAIdentifierExpression(AIdentifierExpression node)
    {
        defaultIn(node);
    }

    public void outAIdentifierExpression(AIdentifierExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdentifierExpression(AIdentifierExpression node)
    {
        inAIdentifierExpression(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAIdentifierExpression(node);
    }

    public void inALiteralExpression(ALiteralExpression node)
    {
        defaultIn(node);
    }

    public void outALiteralExpression(ALiteralExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALiteralExpression(ALiteralExpression node)
    {
        inALiteralExpression(node);
        if(node.getLiteral() != null)
        {
            node.getLiteral().apply(this);
        }
        outALiteralExpression(node);
    }

    public void inABlockStatement(ABlockStatement node)
    {
        defaultIn(node);
    }

    public void outABlockStatement(ABlockStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABlockStatement(ABlockStatement node)
    {
        inABlockStatement(node);
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        outABlockStatement(node);
    }

    public void inAWriteLineStatement(AWriteLineStatement node)
    {
        defaultIn(node);
    }

    public void outAWriteLineStatement(AWriteLineStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWriteLineStatement(AWriteLineStatement node)
    {
        inAWriteLineStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAWriteLineStatement(node);
    }

    public void inACallStatement(ACallStatement node)
    {
        defaultIn(node);
    }

    public void outACallStatement(ACallStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACallStatement(ACallStatement node)
    {
        inACallStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outACallStatement(node);
    }

    public void inAReturnStatement(AReturnStatement node)
    {
        defaultIn(node);
    }

    public void outAReturnStatement(AReturnStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAReturnStatement(AReturnStatement node)
    {
        inAReturnStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAReturnStatement(node);
    }

    public void inAVariableAssignmentStatement(AVariableAssignmentStatement node)
    {
        defaultIn(node);
    }

    public void outAVariableAssignmentStatement(AVariableAssignmentStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVariableAssignmentStatement(AVariableAssignmentStatement node)
    {
        inAVariableAssignmentStatement(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAVariableAssignmentStatement(node);
    }

    public void inAIfStatement(AIfStatement node)
    {
        defaultIn(node);
    }

    public void outAIfStatement(AIfStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfStatement(AIfStatement node)
    {
        inAIfStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        outAIfStatement(node);
    }

    public void inAIfElseStatement(AIfElseStatement node)
    {
        defaultIn(node);
    }

    public void outAIfElseStatement(AIfElseStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfElseStatement(AIfElseStatement node)
    {
        inAIfElseStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAIfElseStatement(node);
    }

    public void inAWhileStatement(AWhileStatement node)
    {
        defaultIn(node);
    }

    public void outAWhileStatement(AWhileStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWhileStatement(AWhileStatement node)
    {
        inAWhileStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        outAWhileStatement(node);
    }

    public void inAEmptyStatement(AEmptyStatement node)
    {
        defaultIn(node);
    }

    public void outAEmptyStatement(AEmptyStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEmptyStatement(AEmptyStatement node)
    {
        inAEmptyStatement(node);
        outAEmptyStatement(node);
    }
}
