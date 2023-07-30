package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {



    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,1));
    }

    public static void printGraph(ArrayList<Edge> graph[]){
        for (int g=0; g< graph.length; g++){
            System.out.print(g+" : ");
            for(int i=0; i<graph[g].size(); i++){
                Edge e = graph[g].get(i);
                System.out.print(e.dest+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int v=6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        boolean[] vis =new boolean[v];
        boolean[] rs =new boolean[v];
        boolean check=false;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<v; i++){
            if(!vis[i]){
                topoSort(graph, vis,i, stack);
            }
        }
//        System.out.println(check);

        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    private static void topoSort(ArrayList<Edge>[] graph, boolean[] vis, int curr, Stack<Integer> stack) {

        vis[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) topoSort(graph, vis, e.dest,stack);
        }
        stack.push(curr);
    }


    private static boolean cycDeteUnDirectedGraph(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par){
        vis[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(e.dest!= par && vis[e.dest])return true;
            else if(!vis[e.dest]){
                if(cycDeteUnDirectedGraph(graph, vis, e.dest, curr))return true;
            }
        }
        return false;
    }

    private static boolean cycDeteDirectedGraph(ArrayList<Edge>[] graph, boolean[] vis, int curr, boolean[] rs){

        vis[curr]=true;
        rs[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rs[e.dest])return true;
            else if(!vis[e.dest]){
                if(cycDeteDirectedGraph(graph, vis, e.dest, rs))return true;
            }
        }
        rs[curr]=false;
        return false;
    }

    private static void allPaths(ArrayList<Edge>[] graph, boolean[] vis, int curr, String path, int trg) {

        if(curr==trg){
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[curr].size(); i++){
            vis[curr]=true;
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) allPaths(graph, vis, e.dest, path+" "+e.dest, trg);
            vis[curr]=false;
        }

    }

    private static void bfs(ArrayList<Edge>[] graph, boolean[] vis, int ii) {

        Queue<Integer> q = new LinkedList<>();
        q.add(ii);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }


    private static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) dfs(graph, vis, e.dest);
        }
    }


}
