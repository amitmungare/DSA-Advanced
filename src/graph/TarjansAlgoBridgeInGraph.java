package graph;

import java.util.ArrayList;

public class TarjansAlgoBridgeInGraph {

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
    }

    public static void main(String[] args) {

        int v=5;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        boolean vis[] = new boolean[v];
        int dt[] = new int[v];
        int lowdt[] = new int[v];


        for (int i=0; i<v; i++){
            if(vis[i]==false){
                bridge(graph, i, vis, dt, lowdt, -1, v, 0);
            }
        }
    }

    private static void bridge(ArrayList<Edge>[] graph, int curr, boolean[] vis, int[] dt, int[] lowdt, int par, int v, int time) {

        vis[curr]=true;
        dt[curr] = lowdt[curr] = time++;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(e.dest==par)continue;
            else if(vis[e.dest])lowdt[curr]=Integer.min(lowdt[curr], dt[e.dest]);
            else{
                bridge(graph, e.dest, vis, dt, lowdt, curr, v, time);
                lowdt[curr]=Integer.min(lowdt[curr], lowdt[e.dest]);
                if(dt[curr]<lowdt[e.dest]) System.out.println(curr +" ----> "+e.dest);
            }
        }
    }
}












