package subtsp;
import java.io.*;
import java.util.Scanner;

public class travellerSalesman {
	 static  public  int tspdp(int c[][],  int tour[], int start,
					int n)
	{

		int mintour[] = new int[10], temp[] = new int[10],
			mincost = 999, ccost, i, j, k;
 
try{
		if (start == n - 1)
      return (c[tour[n - 1]][tour[n]]
					+ c[tour[n]][1]);
		


	}
   catch(ArrayIndexOutOfBoundsException e) {
         System.out.println("The index you have entered is invalid");
   	
         }
   


					

		
		for (i = start + 1; i <= n; i++)

		{

			for (j = 1; j <= n; j++)

				temp[j] = tour[j];

			temp[start + 1] = tour[i];

			temp[i] = tour[start + 1];

			if ((c[tour[start]][tour[i]]
				+ (ccost = tspdp(c, temp, start + 1, n)))
				< mincost)

			{

				mincost = c[tour[start]][tour[i]] + ccost;

				for (k = 1; k <= n; k++)

					mintour[k] = temp[k];
			}
		}

				for (i = 1; i <= n; i++)

			tour[i] = mintour[i];

				return mincost;
	}
   }
   

	