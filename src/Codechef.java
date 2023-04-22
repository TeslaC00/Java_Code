/* package codechef; // don't place package name! */

import java.util.*;
//import java.lang.*;
//import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-- > 0){
		    int size = scan.nextInt();
		    int arr[] = new int[size];
			int tem[] = new int[1001];
		    for(int i=0; i<size; i++){
                arr[i] = scan.nextInt();
				tem[arr[i]]++;
            }
			Arrays.sort(tem);
		    System.out.println(size-tem[1000]);
		}
		scan.close();
	}
}