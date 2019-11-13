package kakao2017;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class NewsClustering2 {

/**
 * 정확도 검사 테스트 5에서 기존의 방식은 실패
 * 정확도 검사 테스트 5의 기댓값은 0
 * 	> 어떨때 0이 나오는가? 교집합이 하나도 없을때
 * 
 * 나의 알고리즘에서 교집합이 아닌 경우를 교집합으로 
 * 인식하는 구멍이 있다는것
 * 
 * 신기한건 테스트 15번의 답도 0인데 그건 인식한다는 것...
 * 
 * **
 * 오류의 이유는 둘다 공집합인 경우와, 하나만 공집합인 경우를 처리하는데 있었다.
 * 기존에 둘다 공집합인 경우를 ||연산자를 사용하여서 틀렸었고
 * ||를 &&로 바꿨으나 되지 않아 if 문 안에서 증감 연산을 하지 않았는데 해결이 되었다.
 * 
*/
	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french")); 
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));

	}
	
	
	public static int solution(String str1, String str2) {
		//대문자와 소문자를 같게 인식하기 때문에 이후 계산을 
		//편하게 하기 위해 전부 소문자로 변환시켜준다.
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		//string을 2 length가 되는 array로 바꿔주는 함수를 이용해서
		//각 str에 맞는 String 배열을 선언 및 초기화 한다.
		String [] str1Array = strTo2LenArray(str1);
		String [] str2Array = strTo2LenArray(str2);
		
		//각 각의 길이를 구한다.
		//strTo2LenArray 함수의 리턴된 String 배열의  0번째 값이
		//""으로 나오기 때문에 이를 제외한 길이를 구한다.
		int str1Len =str1Array.length;
		int str2Len =str2Array.length;
		
		//둘다 공집합인 경우에 나눗셈이 정의되 않으니
		//자카드 유사도는 1이고, 리턴되는 값은
		//자카드 유사도에 65536를 곱한 65536이다.
		if(str1Len ==0 &&str2Len ==0) return 65536;
      
		//하나만 공집합인 경우
		//합집합은 0이 아니고, 교집합은 0이기 때문에
		//리턴 값을 0으로 준다.
      	if(str1Len ==0) return 0;
        if(str2Len ==0) return 0;
        
		//LinkedList에 객체를 넣으면 객체의 특정 필드 값을
        //기준으로 정렬이 가능하다는 점을 이용해서 
        // String의 사전순 정렬을 통해서 시간 복잡도를 n^2가 아닌
        // n를 가능하게 한다.
		List<String> str1List=new LinkedList();
		List<String> str2List=new LinkedList();
		
		//String 배열의 0번째 값은 ""이기 때문에 이를 제외하고 LinkedList에 각각 넣어준다.
		for (int i = 1; i < str1Array.length; i++) {
			str1List.add(str1Array[i]);
		}
		for (int i = 1; i < str2Array.length; i++) {
			str2List.add(str2Array[i]);
		}
		
		//사전순 정렬을 위해 LinkedList의 sort를 사용
		//객체의 특정 매개변수를 사용할 때는 comparator를
		//사용하고 이와같이 특정 자료형인 경우에는 null값을 사용
		str1List.sort(null);
		str2List.sort(null);

		//사전순으로 정렬이 끝난 LinkedList를 ArrayList로 변환해 준다.
		//str1List,str2List 변수를 선언 할때 List형으로 선언해주었기 때문에
		//다시 변수를 선언하지 않고 그 변수를 그대로 사용한다.
		//ArrayList는 index로 자료에 접근할 수 있기 때문에
		//각각의 ArrayList의 값들을 비교 하며 원하는 ArrayList의
		//자료에 접근 할 수있기 때문에 ArrayList를 사용하였다.
		str1List=new ArrayList<String>(str1List);
		str2List=new ArrayList<String>(str2List);
		
		//str1List와 str2List의 index 역할을 할 두 변수를 선언 및 초기화
		int str1Idx=0, str2Idx =0;
		
		//각각의 arrayList에 있는 값을 비교 했을 때 의 결과값을 저장할 변수 선언
		int compNum;
		
		//교집합수를 저장할 변수 선언 및 초기화
		int intersectionCnt = 0;
		
		//각 arrayList의 길이를 넘지 않을떄 까지 반복한다. 
		while(str1Idx <str1Len && str2Idx <str2Len){
			//str1의 단어와 str2의 단어를 비교하고 사전적 차이를 compNum에 저장한다.
			compNum = str1List.get(str1Idx).compareTo(str2List.get(str2Idx));
			
			//두 단어가 같을때
			if(compNum ==0){
				intersectionCnt++;	//교집합 수를 증가 시킨다.
				str1Idx++;			//str1List의 다음 값을 가져오기 위해 str1Index를 증가
				str2Idx++;			//str2List의 다음 값을 가져오기 위해 str2Index를 증가
				
			//str1List의 단어가 사전적으로 더 뒤에 있을때
			}else if(compNum >0){
				str2Idx++;//str2List의 다음 값을 가져 오기 위해서 
				
			//str1List의 단어가 사전적으로 더 앞에 있을때
			}else{
				str1Idx++;
			}
		}//위 과정을 반복한다.
		
		//교집합의 크기 나누기 합집합의 크기에 다루기 쉽게 65536를 곱한 정수 값을 반환한다.
		//교집합은 intersectionCnt
		//합집합은 str1과 str2를 통해 만들어진 length가 2인 String 배열의 길이의 합에 교집합수를 빼준 값
		//정의대로 하면 intersectionCnt(교집합) 앞에 double 등을 붙여 형변환하고 
		//최종적으로 int로 다시 변환해야하기 때문에  65536과 intersectionCnt를 먼저 곱하고 합집합으로 나눠준다.
		return 65536*intersectionCnt/(str1Len+str2Len-intersectionCnt);
	}

	//문자열을 2글자씩 끊어서 String 배열을 리턴해 준다. 
	//범용 문자를 제외한 문자는 String 배열에서 제외한다.
	//ex) "abc/de" -> "ab,bc,de"-> {"ab" , "bc","de"}
	public static String[] strTo2LenArray(String str) {
		//String에 있는 각 문자들을 봐야 하기 때문에 char형 배열로 만들어 준다.
		char[] strCharArray = str.toCharArray();
		
		//String 배열로 만들기 전에 단어들을 ","로 구분한 String형 변수 tempStr 선언 및 초기화
		String tempStr = "";
		
		//str의 각 문자를 담고 있는 char 배열을 0부터 길이-1까지 반복시킨다.
		//index가 i와 i+1인 배열의 값을 다루기 때문에
		for (int i = 0; i < strCharArray.length -1 ; i++) {
			//index가 i 인 경우, i+1인 경우 모두 범용 문자(알파벳)인 경우에 tempStr에
			//해당 char 값을 추가한다. (String 과 char가 만나면 자동으로 String으로 형변환)
			//구분은 ","으로 한다.
			if(Character.isLetter(strCharArray[i]) && Character.isLetter(strCharArray[i+1])){
				tempStr+=""+strCharArray[i] +strCharArray[i+1]+",";
			}
		}
		
		//","으로 구분했던 문자열 tempStr을 ","을 기준으로 쪼개서 String 배열로 리턴한다.
		return tempStr.split(",");
	}	  
}
