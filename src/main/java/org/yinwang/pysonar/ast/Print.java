package org.yinwang.pysonar.ast;

import org.jetbrains.annotations.NotNull;
import org.yinwang.pysonar.State;
import org.yinwang.pysonar.types.Type;

import java.util.List;


public class Print extends Node {

    public Node dest;
    public List<Node> values;


    public Print(Node dest, List<Node> elts, String file, int start, int end) {
        super(file, start, end);
        this.dest = dest;
        this.values = elts;
        addChildren(dest);
        addChildren(elts);
    }


    @NotNull
    @Override
    public List<State> transform(State s) {
        if (dest != null) {
            transformExpr(dest, s);
        }
        if (values != null) {
            transformList(values, s);
        }
        return s.put(this, Type.NONE);
    }


    @NotNull
    @Override
    public String toString() {
        return "(print:" + values + ")";
    }

}
