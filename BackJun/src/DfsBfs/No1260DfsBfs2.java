package DfsBfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1260DfsBfs2 {
	static ArrayList<Integer>[] list;
	static int n;
	static boolean[] check;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		
		list = new ArrayList[n+1];
		
		for(int i=1 ; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m ; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1 ; i<=n ; i++) {
			Collections.sort(list[i]);
		}
		
		check = new boolean[n+1];
		dfs(start);
		System.out.println();
		
		check = new boolean[n+1];
		bfs(start);
		
		sc.close();
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " ");
			for(int y : list[x]) {
				if(!check[y]) {
					check[y] = true;
					queue.add(y);
				}
			}
		}
	}

	public static void dfs(int i) {
		if(check[i]) return;
		
		check[i] = true;
		System.out.println(i+" ");
		
		for(int y : list[i]) {
			if(!check[i]) dfs(y);
		}
	}

}
