/*
Given a binary matrix of size N x M. The task is to find the distance of nearest 1 in the matrix for each cell. The distance is calculated as |i1 – i2| + |j1 – j2|, where i1, j1 are the row number and column number of the current cell and i2, j2 are the row number and column number of the nearest cell having value 1.
Input
The first line contains two integers N and M, denoting the number of rows and columns of the matrix. Next N lines contain M integers either 0 or 1.

1 <= T <= 20
1 <= N, M <= 500
Each element of matrix is either 0 or 1
It is guaranteed that there is at least one 1 present in the input.
Output
Print N lines. Each line containing M integers denoting the distance from nearest 1.


*/


import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Nearest_One {
	public static void main (String[] args)throws IOException {
                      // Your code here
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String [] a=br.readLine().split(" ");
	int row=Integer.parseInt(a[0]);
	int col=Integer.parseInt(a[1]);
	int arr[][] =new int[row][col];
	int res[][]=new int [row][col];
	Queue<Pair> q=new LinkedList<>();
	for(int i=0;i<row;i++){
		String [] b=br.readLine().split(" ");
		for(int j=0;j<col;j++){
           arr[i][j]=Integer.parseInt(b[j]);
		   if(arr[i][j]==1){
			   res[i][j]=0;
			   q.add(new Pair(i,j));
		   }
		   else {
			   res[i][j]=-1;
		   }
		}
	}
	
	while(!q.isEmpty()){
		Pair p=q.remove();
		Pair[] check={
			new Pair(p.i-1,p.j-0),
            new Pair(p.i-0,p.j-1),
			new Pair(p.i+1,p.j+0),
			new Pair(p.i+0,p.j+1),
		};
		for (int i=0;i<4;i++){
			Pair c=check[i];
			if(isValid(c,row,col)&&res[c.i][c.j]==-1){
				res[c.i][c.j]=  res[p.i][p.j]+1;
				q.add(c);
			}
		}
	}
	for(int i=0;i<row;i++){
		for(int j=0;j<col;j++){
			System.out.print(res[i][j]+" ");
		}
		System.out.println();
	}
   

	}

	static class Pair{
		int i;
		int j;
		Pair(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
  




/// valid  function
	static boolean isValid(Pair p,int n,int m){
		int i=p.i;
		int j=p.j;
		if(i>=0&&i<n&&j>=0&&j<m){
			return true ;
		}
		return false;
	}
}