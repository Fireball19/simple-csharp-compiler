/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TMainSymbol extends Token
{
    public TMainSymbol()
    {
        super.setText("Main");
    }

    public TMainSymbol(int line, int pos)
    {
        super.setText("Main");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TMainSymbol(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTMainSymbol(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TMainSymbol text.");
    }
}
