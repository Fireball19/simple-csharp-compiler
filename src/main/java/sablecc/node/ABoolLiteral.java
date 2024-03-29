/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class ABoolLiteral extends PLiteral
{
    private TBoolLiteral _boolLiteral_;

    public ABoolLiteral()
    {
        // Constructor
    }

    public ABoolLiteral(
        @SuppressWarnings("hiding") TBoolLiteral _boolLiteral_)
    {
        // Constructor
        setBoolLiteral(_boolLiteral_);

    }

    @Override
    public Object clone()
    {
        return new ABoolLiteral(
            cloneNode(this._boolLiteral_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABoolLiteral(this);
    }

    public TBoolLiteral getBoolLiteral()
    {
        return this._boolLiteral_;
    }

    public void setBoolLiteral(TBoolLiteral node)
    {
        if(this._boolLiteral_ != null)
        {
            this._boolLiteral_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._boolLiteral_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._boolLiteral_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._boolLiteral_ == child)
        {
            this._boolLiteral_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._boolLiteral_ == oldChild)
        {
            setBoolLiteral((TBoolLiteral) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
