package wemakeprice2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
        int num = sc.nextInt();
        ArrayList<Integer> goods = new ArrayList<Integer>();
        for(int i=0; i<num; i++) {
            goods.add(sc.nextInt());
        }
        
        goods.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
        if(goods.get(0) > max) System.out.println(-1);
        
       
        System.out.println();

	}
	
	
}
