/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import java.util.*;
import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class AMainForm extends PForm
{
    private final LinkedList<PVariable> _variableDefinitions_ = new LinkedList<PVariable>();
    private final LinkedList<PStatement> _statements_ = new LinkedList<PStatement>();

    public AMainForm()
    {
        // Constructor
    }

    public AMainForm(
        @SuppressWarnings("hiding") List<?> _variableDefinitions_,
        @SuppressWarnings("hiding") List<?> _statements_)
    {
        // Constructor
        setVariableDefinitions(_variableDefinitions_);

        setStatements(_statements_);

    }

    @Override
    public Object clone()
    {
        return new AMainForm(
            cloneList(this._variableDefinitions_),
            cloneList(this._statements_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMainForm(this);
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
            + toString(this._variableDefinitions_)
            + toString(this._statements_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
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