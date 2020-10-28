import java.util.Scanner;
import java.util.Stack;

class Vertex 
{
  public char label;
  public boolean isVisited;
  public Vertex(char label) 
  {
     this.label = label;
     isVisited = false;
  }
}

class Graph
{
  private Vertex vertexList[];
  private int adjMat[][];
  private int currVertexIndex;
  private Stack<Integer> stack = new Stack<Integer>();
  
  public Graph(int N)
  {
     vertexList = new Vertex[N];
     adjMat = new int[N][N];
     currVertexIndex = 0;
  }
  
  public void addVertex(char label)
  {
    vertexList[currVertexIndex++] = new Vertex(label);
  }
  
  public void addEdge(int start, int end)
  {
    adjMat[start][end] = 1;
    adjMat[end][start] = 1;
  }
  
  public void displayVertex(int v)
  {
    System.out.print(vertexList[v].label + " ");
  }
  
  public void printVertices()
  {
      for(int index=0;index<currVertexIndex;index++)
      {
          System.out.print(vertexList[index].label+" ");
      }
  }
  
  public int getAdjNonVisitedVertex(int v)
  {
    for(int col = 0; col < currVertexIndex; col++)
    {
      if(adjMat[v][col] == 1 && vertexList[col].isVisited == false) 
      {
        return col;
      }
    }
    return -1;
  }
  
  public void depthFirstSearch()
  {
    vertexList[0].isVisited = true;
    displayVertex(0);
    stack.push(0);
    
    while(!stack.isEmpty()) 
    {    
      int v = getAdjNonVisitedVertex(stack.peek());
      if(v == -1)
      stack.pop();
      else 
      {
         vertexList[v].isVisited = true;
         displayVertex(v);
         stack.push(v);
      }
    }
  }
}

public class Main 
{
  public static void main(String[] args) 
  {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the Number of Vertices: ");
      int N=sc.nextInt();
      Graph graph = new Graph(N);
      System.out.println("Enter the Vertices to be added: ");
      for(int index=1;index<=N;index++)
      {
          char ch=sc.next().charAt(0);
          graph.addVertex(ch);
      }
      System.out.println("The created Vertices are: ");
      graph.printVertices();
      System.out.println();
      System.out.println("Enter the Edges to be added to the Vertices: ");
      for(int index=1;index<=N;index++)
      {
          int U=sc.nextInt(),V=sc.nextInt();
          graph.addEdge(U,V);
      }
      System.out.println("Visited Vertices using DFS are: ");
      graph.depthFirstSearch();
  }
}