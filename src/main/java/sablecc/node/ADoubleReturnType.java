/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class ADoubleReturnType extends PReturnType
{

    public ADoubleReturnType()
    {
        // Constructor
    }

    @Override
    public Object clone()
    {
        return new ADoubleReturnType();
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADoubleReturnType(this);
    }

    @Override
    public String toString()
    {
        return "";
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        throw new RuntimeException("Not a child.");
    }
}
