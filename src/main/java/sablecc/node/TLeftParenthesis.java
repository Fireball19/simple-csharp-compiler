/* This file was generated by SableCC (http://www.sablecc.org/). */

package sablecc.node;

import sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TLeftParenthesis extends Token
{
    public TLeftParenthesis()
    {
        super.setText("(");
    }

    public TLeftParenthesis(int line, int pos)
    {
        super.setText("(");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TLeftParenthesis(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTLeftParenthesis(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TLeftParenthesis text.");
    }
}
