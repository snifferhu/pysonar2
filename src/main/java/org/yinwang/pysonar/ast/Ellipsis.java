package org.yinwang.pysonar.ast;

import org.jetbrains.annotations.NotNull;
import org.yinwang.pysonar.State;
import org.yinwang.pysonar.types.Type;

import java.util.List;


public class Ellipsis extends Node {

    public Ellipsis(String file, int start, int end) {
        super(file, start, end);
    }


    @NotNull
    @Override
    public String toString() {
        return "...";
    }


    @NotNull
    @Override
    public List<State> transform(State s) {
        return s.put(this, Type.NONE);
    }

}
