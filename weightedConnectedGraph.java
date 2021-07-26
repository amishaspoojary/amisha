package main;
import subtsp.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.File;

public class weightedConnectedGraph {
public static void main(String[] args) throws FileNotFoundException {
    int choice=0;

     do  {
       System.out.println(" 1.user wants to visit all the cities and never come back to the source location\n2.user will start from source location and reach destination and come back to source location\n3.file input for 3 cities of travelling sales man\n4.kruskals grph\n0.EXIT\n");
       System.out.println("enter the choice..!\n");
       Scanner sc = new Scanner(System.in);  
       choice=sc.nextInt();
       switch(choice)
       {
       case 4: 
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int a,b;  
         FileInputStream file=new FileInputStream("C:\\Users\\amisha\\Documents\\main\\vertex.txt");        
              //  System.out.println("Enter number of cities: ");  
          Scanner read = new Scanner(file);

        
               a = read.nextInt();  //5
          
              //  System.out.println("Enter number of edges through cities");  
           FileInputStream finput=new FileInputStream("C:\\Users\\amisha\\Documents\\main\\edge.txt"); 
           Scanner r = new Scanner(finput);
 
                b = r.nextInt();  //7
          
       weightedConnectedGraph g = new weightedConnectedGraph(a, b);                  
        for(int d = 0; d < b; d++){  
        FileInputStream file5=new FileInputStream("C:\\Users\\amisha\\Documents\\main\\source.txt");
           // System.out.println("Enter source value for edge["+ ij +"]"); 
           Scanner x = new Scanner(file5);
 
            g.edge[d].src = x.nextInt();  
           FileInputStream file6=new FileInputStream("C:\\Users\\amisha\\Documents\\main\\dest.txt");   
           // System.out.println("Enter destination value for edge["+ ij +"]"); 
           Scanner y = new Scanner(file6);
 
            g.edge[d].dest = y.nextInt();  
            FileInputStream file7=new FileInputStream("C:\\Users\\amisha\\Documents\\main\\cost.txt");  
           // System.out.println("Enter cost for edge["+ij+"]");  
           Scanner z = new Scanner(file7);

            g.edge[d].weight = z.nextInt();  
        }  
          
               g.KruskalMST();

       break;
              case 3:
       int Cost,t[]=new int[10],Tour[][] = new int[10][10];
       BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
       FileInputStream fin=new FileInputStream("C:\\Users\\amisha\\Documents\\main\\demo.txt"); 
      // File file=new File("demo.txt");
       //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       Scanner input = new Scanner(fin);
       for (int k=1; k<=3; k++)
       for (int l=1;l<=3;l++)
		Tour[k][l] = input.nextInt();
      
       File file1=new File("C:\\Users\\amisha\\Documents\\main\\demo1.txt");
       Scanner s = new Scanner(file1);

      for (int k = 1; k <= 3; k++)
        
			t[k] = s.nextInt();


				Cost = travellerSalesman.tspdp( Tour,t, 1, 3);

				System.out.print("shortest path: ");

		
		for (int k = 1; k <= 3; k++)

						System.out.print(t[k] + "->");

				System.out.println("1");

				System.out.println("Minimum Cost: " + Cost);


       break;
          case 2:
   
   
   		Scanner in = new Scanner(System.in);
          //Scanner input = new Scanner(System.in);

			int c[][] = new int[10][10], tour[] = new int[10];

		   int i, j, cost;

            System.out.print("Enter No. of Cities: ");
   
				int n = in.nextInt();

				if (n == 1) {
						System.out.println("Path is not possible!");

						System.exit(0);
		}

		
				System.out.println("Enter the Cost :");

				for (i = 1; i <= n; i++)

			for (j = 1; j <= n; j++)

				c[i][j] = in.nextInt();

		for (i = 1; i <= n; i++)

			tour[i] = i;

				cost = travellerSalesman.tspdp(c, tour, 1, n);

				System.out.print("shortest path: ");

		
		for (i = 1; i <= n; i++)

						System.out.print(tour[i] + "->");

				System.out.println("1");

				System.out.println("Minimum Cost: " + cost);
      break;
	

    default: System.out.println("Invalid choice\n");
             break; 

    case 0:
				            System.exit(0);

				            break;
            

    case 1: 
          
        int v, e;  
                 
                System.out.println("Enter number of cities: ");  
          
        
               v = sc.nextInt();  
          
                System.out.println("Enter number of edges through cities");  
          
                e = sc.nextInt();  
          
       weightedConnectedGraph graph = new weightedConnectedGraph(v, e);                  
        for(int ij = 0; ij < e; ij++){  
            System.out.println("Enter source value for edge["+ ij +"]");  
            graph.edge[ij].src = sc.nextInt();  
              
            System.out.println("Enter destination value for edge["+ ij +"]");  
            graph.edge[ij].dest = sc.nextInt();  
              
            System.out.println("Enter cost for edge["+ij+"]");  
            graph.edge[ij].weight = sc.nextInt();  
        }  
          
               graph.KruskalMST();
               break;


    } 
   
    
   }while(choice!=100); 
}

	   
   class subGraph 	{
		int parent, rank;
	};

	class Edge implements Comparable<Edge>
	{
		int src, dest, weight;
		public int compareTo(Edge compareEdge)
		{
			return this.weight - compareEdge.weight;
		}
	};

	
	public int V, E; 
   	Edge edge[]; 
		 weightedConnectedGraph(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

		int find(subGraph subGraphs[], int i)
	{		
   try{
   
   if (subGraphs[i].parent != i)
			subGraphs[i].parent
				= find(subGraphs, subGraphs[i].parent);

	//	return subGraphs[i].parent;
      }
      catch(ArrayIndexOutOfBoundsException e) {
         System.out.println("The index you have entered is invalid");
	}
   return subGraphs[i].parent;

   }
	//}

  // };
   

		void Union(subGraph subGraphs[], int x, int y)
	{
		int xroot = find(subGraphs, x);
		int yroot = find(subGraphs, y);

				if (subGraphs[xroot].rank
			< subGraphs[yroot].rank)
			subGraphs[xroot].parent = yroot;
		else if (subGraphs[xroot].rank
				> subGraphs[yroot].rank)
			subGraphs[yroot].parent = xroot;

				else {
			subGraphs[yroot].parent = xroot;
			subGraphs[xroot].rank++;
		}
	}

		void KruskalMST()
	{
				Edge result[] = new Edge[V];
	
				int e = 0;
	
				int i = 0;
		for (i = 0; i < V; ++i)
			result[i] = new Edge();

				Arrays.sort(edge);

				subGraph subGraphs[] = new subGraph[V];
		for (i = 0; i < V; ++i)
			subGraphs[i] = new subGraph();

		
		for (int v = 0; v < V; ++v)
		{
			subGraphs[v].parent = v;
			subGraphs[v].rank = 0;
		}

		i = 0; 
      		while (e < V - 1)
		{
						Edge next_edge = edge[i++];

			int x = find(subGraphs, next_edge.src);
			int y = find(subGraphs, next_edge.dest);

						if (x != y) {
				result[e++] = next_edge;
				Union(subGraphs, x, y);
			}
					}

				System.out.println("Following are the edges in "
						+ "the constructed MST");
		int minimumCost = 0;
		for (i = 0; i < e; ++i)
		{
			System.out.println(result[i].src + " -- "
							+ result[i].dest
							+ " == " + result[i].weight);
			minimumCost += result[i].weight;
		}
		System.out.println("Minimum Cost Spanning Tree "
						+ minimumCost);
	}

	
    
}; 
