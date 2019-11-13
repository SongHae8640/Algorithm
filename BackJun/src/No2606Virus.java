import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No2606Virus {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int[] computers = new int[Integer.parseInt(st.nextToken())+1];
		for (int i = 1; i < computers.length; i++) {
			computers[i] = i;
		}
		
		//노드 입력
		int nodeCount = Integer.parseInt(br.readLine());
		//System.out.println(nodeCount);
		for (int i = 0; i < nodeCount; i++) {
			String startNode = br.readLine();
			System.out.println(startNode +", "+i);
		}
		
		

	}
	
	public static int getComputers(int[] computers, int x) {
		if(computers[x] == x) return x;
		return getComputers(computers, computers[x]);
	}
	
	public static void unionComputers(int[] computers, int x, int y) {
		x = getComputers(computers, x);
		y = getComputers(computers, y);
		
		//더 작은 값으로 부모 노드 설정
		if(x < y) {
			computers[y] = x;
		}else {
			computers[x] = y;
		}
	}
	
	public static boolean isSameComputers(int[] computers, int x, int y) {
		if(computers[x] == computers[y]) return true;
		return false;
	}

}
