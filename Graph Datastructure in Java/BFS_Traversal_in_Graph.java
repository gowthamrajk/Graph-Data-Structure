import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

class Graph 
{
   static int N;
   static LinkedList<Integer> adjList[];
   Graph(int N)
   {
       this.N=N;
       adjList = new LinkedList[N];
       for (int index=0;index<N;index++)
       {
           adjList[index]=new LinkedList();
       }
   }
   public void addEdge(int U,int V) 
   {
       adjList[U].add(V);
   }
   public void breadthFirstSearch(int vertex) 
   {
        boolean visited[] = new boolean[N];
        Arrays.fill(visited,false);
        LinkedList<Integer> queue = new LinkedList();
        visited[vertex] = true;
        queue.add(vertex);
        while(queue.size()!=0) 
        {
            vertex=queue.poll();
            System.out.print(vertex+" ");
            Iterator<Integer> itr = adjList[vertex].listIterator();
            while(itr.hasNext()) 
            {
                int currVertex=itr.next();
                if(!visited[currVertex]) 
                {
                    visited[currVertex] = true;
                    queue.add(currVertex);
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
        System.out.println("Enter the number of Vertices: ");
        int edges=sc.nextInt();
        System.out.println("Enter the Edges of Vertices: ");
        for(int index=1;index<=edges;index++)
        {
            int U=sc.nextInt(),V=sc.nextInt();
            graph.addEdge(U,V);
        }
        System.out.println("Enter the vertex to be traversed: ");
        int vertex=sc.nextInt();
        System.out.println("Breadth First Search Traversal:");
        graph.breadthFirstSearch(vertex);
    }
}