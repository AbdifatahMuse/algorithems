package com.dong.learn.algorithms.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by coding-dong on 2017/10/29.
 */
public class Graph {

    private List<GraphNode> vertexList;

    private int[][] edgeArray = {{1,1,1,0,0,0},{1,1,1,1,0,1},{1,1,1,0,1,0},{0,1,0,1,0,0},{0,0,1,0,1,1},{0,1,0,0,1,1}};

    //顶点访问记录
    private boolean[] visited = {false, false, false, false, false, false};

    public void initGraph(){
        vertexList = new LinkedList<>();
        for(int i = 0; i <= 5; i++){
            GraphNode graphNode = new GraphNode(((char)('A' + i)) + "", i);

            vertexList.add(graphNode);
        }

    }

    public void dfs(GraphNode graphNode){
        if(graphNode == null){
            return;
        }

        visited[graphNode.getIndex()] = true;

        System.out.print(graphNode.getName() + "    ");

        for(int i = 0; i < vertexList.size(); i++){
            if(edgeArray[graphNode.getIndex()][i] == 1 && !visited[i]){
                dfs(vertexList.get(i));
            }
        }
    }

    public void bfs(){
        Queue<GraphNode> vertexQueue = new LinkedList<>();

        vertexQueue.offer(vertexList.get(0));

        while (!vertexQueue.isEmpty()){
            GraphNode graphNode = vertexQueue.poll();
            visited[graphNode.getIndex()] = true;

            System.out.print(graphNode.getName() + "    ");
            for(int i = 0; i < vertexList.size(); i++){
                if(edgeArray[graphNode.getIndex()][i] == 1 && !visited[i]){
                    vertexQueue.offer(vertexList.get(i));
                    visited[i] = true;
                }
            }
            System.out.println("<=========queue detail=========>");
            System.out.println(vertexQueue.toString());
            System.out.println("<=========queue detail=========>");
        }

    }

    public static void main(String[] args){
        Graph graph = new Graph();
        graph.initGraph();

//        graph.bfs();
        System.out.println("********************************");
        graph.dfs(graph.vertexList.get(0));
    }
}
