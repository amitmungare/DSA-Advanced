package graph;

public class Edge {

    int src;
    int dest;
    int weight;

    public Edge(int s, int d){
        this.src=s;
        this.dest=d;
    }

    public Edge(int s, int d, int w){
        this.src=s;
        this.dest=d;
        this.weight=w;
    }
}
