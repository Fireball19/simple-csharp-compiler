/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TNamespaceSymbol extends Token
{
    public TNamespaceSymbol()
    {
        super.setText("namespace");
    }

    public TNamespaceSymbol(int line, int pos)
    {
        super.setText("namespace");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TNamespaceSymbol(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNamespaceSymbol(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TNamespaceSymbol text.");
    }
}
