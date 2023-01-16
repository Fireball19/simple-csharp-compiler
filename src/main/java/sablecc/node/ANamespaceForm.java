/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class ANamespaceForm extends PForm
{
    private PForm _form_;

    public ANamespaceForm()
    {
        // Constructor
    }

    public ANamespaceForm(
        @SuppressWarnings("hiding") PForm _form_)
    {
        // Constructor
        setForm(_form_);

    }

    @Override
    public Object clone()
    {
        return new ANamespaceForm(
            cloneNode(this._form_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANamespaceForm(this);
    }

    public PForm getForm()
    {
        return this._form_;
    }

    public void setForm(PForm node)
    {
        if(this._form_ != null)
        {
            this._form_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._form_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._form_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._form_ == child)
        {
            this._form_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._form_ == oldChild)
        {
            setForm((PForm) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
