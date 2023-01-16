/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TPublicSymbol extends Token
{
    public TPublicSymbol()
    {
        super.setText("public");
    }

    public TPublicSymbol(int line, int pos)
    {
        super.setText("public");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TPublicSymbol(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTPublicSymbol(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TPublicSymbol text.");
    }
}