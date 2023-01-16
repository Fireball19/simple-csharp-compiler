/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TElseSymbol extends Token
{
    public TElseSymbol()
    {
        super.setText("else");
    }

    public TElseSymbol(int line, int pos)
    {
        super.setText("else");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TElseSymbol(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTElseSymbol(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TElseSymbol text.");
    }
}
