/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class AEmptyStatement extends PStatement
{

    public AEmptyStatement()
    {
        // Constructor
    }

    @Override
    public Object clone()
    {
        return new AEmptyStatement();
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEmptyStatement(this);
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
