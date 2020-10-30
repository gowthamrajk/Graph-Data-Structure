import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Graph 
{
   static boolean visited[];
   static List<List<Integer>> adjList;
   Graph(int N)
   {
       adjList = new ArrayList<>();
       visited = new boolean[N];
       for (int index=0;index<N;index++)
       {
           adjList.add(index,new ArrayList<>());
       }
   }
   public void addEdge(int source,int dest) 
   {
       adjList.get(source).add(dest);
       adjList.get(dest).add(source);
   }
   public void depthFirstSearch(int start) 
   {
        Stack<Integer> stack=new Stack<>();
        stack.push(start);
        visited[start] = true;
        while(!stack.isEmpty())
        {
            int currVertex=stack.pop();
            System.out.print(currVertex+" ");
            List<Integer> neighbourVertices = adjList.get(currVertex);
            for(Integer vertices:neighbourVertices)
            {
                if(!visited[vertices])
                {
                    stack.push(vertices);
                    visited[vertices] = true;
                }
            }
        }
    }
}
public class Main 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Vertices: ");
        int N=sc.nextInt();
        Graph graph=new Graph(N);
        System.out.println("Enter the Edges of Vertices: ");
        for(int index=1;index<=N;index++)
        {
            int U=sc.nextInt(),V=sc.nextInt();
            graph.addEdge(U,V);
        }
        System.out.println("Enter the starting vertex to be traversed: ");
        int start=sc.nextInt();
        System.out.println("Depth First Search Traversal:");
        graph.depthFirstSearch(start);
    }
}