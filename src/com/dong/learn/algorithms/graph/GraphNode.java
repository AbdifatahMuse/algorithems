package com.dong.learn.algorithms.graph;

/**
 * Created by coding-dong on 2017/10/29.
 */
public class GraphNode {
    private String name;

    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public GraphNode() {
    }

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
