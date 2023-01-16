/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TIfSymbol extends Token
{
    public TIfSymbol()
    {
        super.setText("if");
    }

    public TIfSymbol(int line, int pos)
    {
        super.setText("if");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TIfSymbol(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTIfSymbol(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TIfSymbol text.");
    }
}
