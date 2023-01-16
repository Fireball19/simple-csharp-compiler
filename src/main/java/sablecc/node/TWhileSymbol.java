/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TWhileSymbol extends Token
{
    public TWhileSymbol()
    {
        super.setText("while");
    }

    public TWhileSymbol(int line, int pos)
    {
        super.setText("while");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TWhileSymbol(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTWhileSymbol(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TWhileSymbol text.");
    }
}
