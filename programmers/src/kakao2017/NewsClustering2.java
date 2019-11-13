package kakao2017;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class NewsClustering2 {

/**
 * ��Ȯ�� �˻� �׽�Ʈ 5���� ������ ����� ����
 * ��Ȯ�� �˻� �׽�Ʈ 5�� ����� 0
 * 	> ��� 0�� �����°�? �������� �ϳ��� ������
 * 
 * ���� �˰��򿡼� �������� �ƴ� ��츦 ���������� 
 * �ν��ϴ� ������ �ִٴ°�
 * 
 * �ű��Ѱ� �׽�Ʈ 15���� �䵵 0�ε� �װ� �ν��Ѵٴ� ��...
 * 
 * **
 * ������ ������ �Ѵ� �������� ����, �ϳ��� �������� ��츦 ó���ϴµ� �־���.
 * ������ �Ѵ� �������� ��츦 ||�����ڸ� ����Ͽ��� Ʋ�Ⱦ���
 * ||�� &&�� �ٲ����� ���� �ʾ� if �� �ȿ��� ���� ������ ���� �ʾҴµ� �ذ��� �Ǿ���.
 * 
*/
	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french")); 
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));

	}
	
	
	public static int solution(String str1, String str2) {
		//�빮�ڿ� �ҹ��ڸ� ���� �ν��ϱ� ������ ���� ����� 
		//���ϰ� �ϱ� ���� ���� �ҹ��ڷ� ��ȯ�����ش�.
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		//string�� 2 length�� �Ǵ� array�� �ٲ��ִ� �Լ��� �̿��ؼ�
		//�� str�� �´� String �迭�� ���� �� �ʱ�ȭ �Ѵ�.
		String [] str1Array = strTo2LenArray(str1);
		String [] str2Array = strTo2LenArray(str2);
		
		//�� ���� ���̸� ���Ѵ�.
		//strTo2LenArray �Լ��� ���ϵ� String �迭��  0��° ����
		//""���� ������ ������ �̸� ������ ���̸� ���Ѵ�.
		int str1Len =str1Array.length;
		int str2Len =str2Array.length;
		
		//�Ѵ� �������� ��쿡 �������� ���ǵ� ������
		//��ī�� ���絵�� 1�̰�, ���ϵǴ� ����
		//��ī�� ���絵�� 65536�� ���� 65536�̴�.
		if(str1Len ==0 &&str2Len ==0) return 65536;
      
		//�ϳ��� �������� ���
		//�������� 0�� �ƴϰ�, �������� 0�̱� ������
		//���� ���� 0���� �ش�.
      	if(str1Len ==0) return 0;
        if(str2Len ==0) return 0;
        
		//LinkedList�� ��ü�� ������ ��ü�� Ư�� �ʵ� ����
        //�������� ������ �����ϴٴ� ���� �̿��ؼ� 
        // String�� ������ ������ ���ؼ� �ð� ���⵵�� n^2�� �ƴ�
        // n�� �����ϰ� �Ѵ�.
		List<String> str1List=new LinkedList();
		List<String> str2List=new LinkedList();
		
		//String �迭�� 0��° ���� ""�̱� ������ �̸� �����ϰ� LinkedList�� ���� �־��ش�.
		for (int i = 1; i < str1Array.length; i++) {
			str1List.add(str1Array[i]);
		}
		for (int i = 1; i < str2Array.length; i++) {
			str2List.add(str2Array[i]);
		}
		
		//������ ������ ���� LinkedList�� sort�� ���
		//��ü�� Ư�� �Ű������� ����� ���� comparator��
		//����ϰ� �̿Ͱ��� Ư�� �ڷ����� ��쿡�� null���� ���
		str1List.sort(null);
		str2List.sort(null);

		//���������� ������ ���� LinkedList�� ArrayList�� ��ȯ�� �ش�.
		//str1List,str2List ������ ���� �Ҷ� List������ �������־��� ������
		//�ٽ� ������ �������� �ʰ� �� ������ �״�� ����Ѵ�.
		//ArrayList�� index�� �ڷῡ ������ �� �ֱ� ������
		//������ ArrayList�� ������ �� �ϸ� ���ϴ� ArrayList��
		//�ڷῡ ���� �� ���ֱ� ������ ArrayList�� ����Ͽ���.
		str1List=new ArrayList<String>(str1List);
		str2List=new ArrayList<String>(str2List);
		
		//str1List�� str2List�� index ������ �� �� ������ ���� �� �ʱ�ȭ
		int str1Idx=0, str2Idx =0;
		
		//������ arrayList�� �ִ� ���� �� ���� �� �� ������� ������ ���� ����
		int compNum;
		
		//�����ռ��� ������ ���� ���� �� �ʱ�ȭ
		int intersectionCnt = 0;
		
		//�� arrayList�� ���̸� ���� ������ ���� �ݺ��Ѵ�. 
		while(str1Idx <str1Len && str2Idx <str2Len){
			//str1�� �ܾ�� str2�� �ܾ ���ϰ� ������ ���̸� compNum�� �����Ѵ�.
			compNum = str1List.get(str1Idx).compareTo(str2List.get(str2Idx));
			
			//�� �ܾ ������
			if(compNum ==0){
				intersectionCnt++;	//������ ���� ���� ��Ų��.
				str1Idx++;			//str1List�� ���� ���� �������� ���� str1Index�� ����
				str2Idx++;			//str2List�� ���� ���� �������� ���� str2Index�� ����
				
			//str1List�� �ܾ ���������� �� �ڿ� ������
			}else if(compNum >0){
				str2Idx++;//str2List�� ���� ���� ���� ���� ���ؼ� 
				
			//str1List�� �ܾ ���������� �� �տ� ������
			}else{
				str1Idx++;
			}
		}//�� ������ �ݺ��Ѵ�.
		
		//�������� ũ�� ������ �������� ũ�⿡ �ٷ�� ���� 65536�� ���� ���� ���� ��ȯ�Ѵ�.
		//�������� intersectionCnt
		//�������� str1�� str2�� ���� ������� length�� 2�� String �迭�� ������ �տ� �����ռ��� ���� ��
		//���Ǵ�� �ϸ� intersectionCnt(������) �տ� double ���� �ٿ� ����ȯ�ϰ� 
		//���������� int�� �ٽ� ��ȯ�ؾ��ϱ� ������  65536�� intersectionCnt�� ���� ���ϰ� ���������� �����ش�.
		return 65536*intersectionCnt/(str1Len+str2Len-intersectionCnt);
	}

	//���ڿ��� 2���ھ� ��� String �迭�� ������ �ش�. 
	//���� ���ڸ� ������ ���ڴ� String �迭���� �����Ѵ�.
	//ex) "abc/de" -> "ab,bc,de"-> {"ab" , "bc","de"}
	public static String[] strTo2LenArray(String str) {
		//String�� �ִ� �� ���ڵ��� ���� �ϱ� ������ char�� �迭�� ����� �ش�.
		char[] strCharArray = str.toCharArray();
		
		//String �迭�� ����� ���� �ܾ���� ","�� ������ String�� ���� tempStr ���� �� �ʱ�ȭ
		String tempStr = "";
		
		//str�� �� ���ڸ� ��� �ִ� char �迭�� 0���� ����-1���� �ݺ���Ų��.
		//index�� i�� i+1�� �迭�� ���� �ٷ�� ������
		for (int i = 0; i < strCharArray.length -1 ; i++) {
			//index�� i �� ���, i+1�� ��� ��� ���� ����(���ĺ�)�� ��쿡 tempStr��
			//�ش� char ���� �߰��Ѵ�. (String �� char�� ������ �ڵ����� String���� ����ȯ)
			//������ ","���� �Ѵ�.
			if(Character.isLetter(strCharArray[i]) && Character.isLetter(strCharArray[i+1])){
				tempStr+=""+strCharArray[i] +strCharArray[i+1]+",";
			}
		}
		
		//","���� �����ߴ� ���ڿ� tempStr�� ","�� �������� �ɰ��� String �迭�� �����Ѵ�.
		return tempStr.split(",");
	}	  
}
