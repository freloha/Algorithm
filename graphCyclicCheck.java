import java.io.*;
import java.util.*;

// algorithm complexity : O(v + e) same as DFS complexity

class Graph
{
    private int v;
    private List<List<Integer>> list;
    
    public Graph(int v){
        this.v = v;
        list = new ArrayList<>(v);

        for(int i = 0; i < v; i++){
            list.add(new LinkedList<>());
        }
    }

    // 그래프에 source, destination 추가
    public void Edge(int s, int d){
        list.get(s).add(d);
    }

    //DFS
    private boolean cyclicCheck(int i, boolean[] visit, boolean[] stack){
        if(stack[i]){
            return true;
        }
        if(visit[i]){
            return false;
        }

        visit[i] = true;
        stack[i] = true;

        List<Integer> child = list.get(i);

        for(Integer c : child){
            if(cyclicCheck(c, visit, stack)){
                return true;
            }
        }

        stack[i] = false;

        return false;
    }

    public boolean isCyclic(){
        boolean[] visit = new boolean[v];
        boolean[] stack = new boolean[v];

        for(int i = 0; i < v; i++){
            if(cyclicCheck(i, visit, stack)){
                return true;
            }
        }

        return false;
    } 

    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Graph graph = new Graph(Integer.parseInt(input));
        
        while(br.ready()){
            String[] splitString = br.readLine().split("\\s+");
            int source = Integer.parseInt(splitString[0]);
            int destination = Integer.parseInt(splitString[1]);
            graph.Edge(source, destination);
        }

        if(graph.isCyclic()){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }

    }
}
