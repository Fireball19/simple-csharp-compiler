/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TDoubleSymbol extends Token
{
    public TDoubleSymbol()
    {
        super.setText("double");
    }

    public TDoubleSymbol(int line, int pos)
    {
        super.setText("double");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TDoubleSymbol(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDoubleSymbol(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TDoubleSymbol text.");
    }
}
