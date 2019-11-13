package kakao2017;

/**
 * 컬러링북은 2차원의 정보를 처리한다. 이를 이해하기 위해 1차원 정보를 처리하는 방법을
 * 익힌 후 이를 발전시켜 2차원 정보를 처리해보려고 한다.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ColoringLine {

	
	public static void main(String[] args) {
		int[] testArr = new int[]{0,1, 1, 1, 0,1,1,2,3,2,1,0};
		solution(testArr.length, testArr);

	}
	
	public static int[] solution(int n, int[] line) {
		//영역의 넓이를 갖는 리스트
		List<Integer> landAreas = new LinkedList<Integer>();
		
		int colorNum = -1;	//컬러의 색상
		int x = 0;		//컬러링라인의 idx
		int tempArea =0;
		
		
		while(x < n) {
			//컬러가 다르면
			if(line[x] != colorNum){
				if(tempArea !=0) {
					landAreas.add(tempArea);	//이전 영역의 크기를 리스트에 넣고
					tempArea =0;				//영역 초기화	
				}
				colorNum = line[x];			//컬러를 바꿔주고
										
			}
			
			if(line[x]!=0){
				tempArea++;
			}
			x++;							//위치 이동
		}
			
		//면접의 넓이 순으로 내림차순 정렬
		landAreas.sort(compAreaDesc);
		
		System.out.println(landAreas.toString());
		
		//리스트의 사이즈(영역의 개수), 리스트의 첫번째 값(가장 넓은 영역의 넓이)를 반환
		return new int[]{landAreas.size() , landAreas.get(0)}; 
	 }
	  
	//면적의 넓이순으로 정렬(내림차순)
	static Comparator<Integer> compAreaDesc = new Comparator<Integer>() {
		public int compare(Integer a, Integer b){
			return b- a;
		}
	};
}
