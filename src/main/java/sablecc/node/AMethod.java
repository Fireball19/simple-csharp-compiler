/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import java.util.*;
import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class AMethod extends PMethod
{
    private TIdentifier _identifier_;
    private PReturnType _returnType_;
    private final LinkedList<PParameter> _parameterDefinitions_ = new LinkedList<PParameter>();
    private final LinkedList<PVariable> _variableDefinitions_ = new LinkedList<PVariable>();
    private final LinkedList<PStatement> _statements_ = new LinkedList<PStatement>();

    public AMethod()
    {
        // Constructor
    }

    public AMethod(
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") PReturnType _returnType_,
        @SuppressWarnings("hiding") List<?> _parameterDefinitions_,
        @SuppressWarnings("hiding") List<?> _variableDefinitions_,
        @SuppressWarnings("hiding") List<?> _statements_)
    {
        // Constructor
        setIdentifier(_identifier_);

        setReturnType(_returnType_);

        setParameterDefinitions(_parameterDefinitions_);

        setVariableDefinitions(_variableDefinitions_);

        setStatements(_statements_);

    }

    @Override
    public Object clone()
    {
        return new AMethod(
            cloneNode(this._identifier_),
            cloneNode(this._returnType_),
            cloneList(this._parameterDefinitions_),
            cloneList(this._variableDefinitions_),
            cloneList(this._statements_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethod(this);
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    public PReturnType getReturnType()
    {
        return this._returnType_;
    }

    public void setReturnType(PReturnType node)
    {
        if(this._returnType_ != null)
        {
            this._returnType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._returnType_ = node;
    }

    public LinkedList<PParameter> getParameterDefinitions()
    {
        return this._parameterDefinitions_;
    }

    public void setParameterDefinitions(List<?> list)
    {
        for(PParameter e : this._parameterDefinitions_)
        {
            e.parent(null);
        }
        this._parameterDefinitions_.clear();

        for(Object obj_e : list)
        {
            PParameter e = (PParameter) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._parameterDefinitions_.add(e);
        }
    }

    public LinkedList<PVariable> getVariableDefinitions()
    {
        return this._variableDefinitions_;
    }

    public void setVariableDefinitions(List<?> list)
    {
        for(PVariable e : this._variableDefinitions_)
        {
            e.parent(null);
        }
        this._variableDefinitions_.clear();

        for(Object obj_e : list)
        {
            PVariable e = (PVariable) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._variableDefinitions_.add(e);
        }
    }

    public LinkedList<PStatement> getStatements()
    {
        return this._statements_;
    }

    public void setStatements(List<?> list)
    {
        for(PStatement e : this._statements_)
        {
            e.parent(null);
        }
        this._statements_.clear();

        for(Object obj_e : list)
        {
            PStatement e = (PStatement) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._statements_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifier_)
            + toString(this._returnType_)
            + toString(this._parameterDefinitions_)
            + toString(this._variableDefinitions_)
            + toString(this._statements_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._returnType_ == child)
        {
            this._returnType_ = null;
            return;
        }

        if(this._parameterDefinitions_.remove(child))
        {
            return;
        }

        if(this._variableDefinitions_.remove(child))
        {
            return;
        }

        if(this._statements_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._returnType_ == oldChild)
        {
            setReturnType((PReturnType) newChild);
            return;
        }

        for(ListIterator<PParameter> i = this._parameterDefinitions_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PParameter) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PVariable> i = this._variableDefinitions_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PVariable) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PStatement> i = this._statements_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PStatement) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}