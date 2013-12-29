package org.yinwang.pysonar.ast;

import org.jetbrains.annotations.NotNull;
import org.yinwang.pysonar.State;
import org.yinwang.pysonar.types.ListType;

import java.util.List;


public class ListComp extends Node {

    public Node elt;
    public List<Comprehension> generators;


    public ListComp(Node elt, List<Comprehension> generators, String file, int start, int end) {
        super(file, start, end);
        this.elt = elt;
        this.generators = generators;
        addChildren(elt);
        addChildren(generators);
    }


    /**
     * Python's list comprehension will bind the variables used in generators.
     * This will erase the original values of the variables even after the
     * comprehension.
     */
    @NotNull
    @Override
    public List<State> transform(State s) {
        transformList(generators, s);
        return transformExpr(elt, s);
    }


    @NotNull
    @Override
    public String toString() {
        return "(ListComp:" + elt + ")";
    }

}
