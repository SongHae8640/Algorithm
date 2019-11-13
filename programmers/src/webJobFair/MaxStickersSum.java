package webJobFair;

import java.util.Arrays;

public class MaxStickersSum {

	public static void main(String[] args) {
		solution(new int[] {12, 12, 12, 12, 12});
		solution(new int[] {12, 80, 14, 22, 100});
	}
	
    public static int solution(int[] sticker) {
        int answer = 0;

        //���� ����� ���� stickers Ȯ��(�� ���� 0���� ��)
        int[] exSticker = new int[sticker.length+2];
        for (int i = 0; i < sticker.length; i++) {
			exSticker[i+1] = sticker[i];
		}
        
        //�� ��ƼĿ�� �߶����� �̵��� ū ���� ����
        int maxBenefitIdx=0;
        int maxSum=0;
        int tempSum;
        for (int j = 0; j < sticker.length; j++) {
        	for (int i = 1; i < exSticker.length-1; i++) {
        		tempSum = exSticker[i-1]+exSticker[i+1];
        		if(tempSum > maxSum) {
        			maxBenefitIdx = i;
        			maxSum = tempSum;
        		}
        	}
        	if(exSticker[maxBenefitIdx-1]>exSticker[maxBenefitIdx+1]) {
        		answer+=exSticker[maxBenefitIdx-1];
        	}else {
        		answer+=exSticker[maxBenefitIdx+1];
        	}
        	exSticker[maxBenefitIdx] = 0;
        	 System.out.println(maxBenefitIdx+","+maxSum);
		}
        
        System.out.println(Arrays.toString(exSticker));
        
        return answer;
    }

}
/*
 * 
���� �׸��� ���� ���ڰ� �����ִ� ��ƼĿ�� �� �ٷ� �پ��ֽ��ϴ�.

image

�� �ٷ� �پ��ִ� ��ƼĿ�� ������ �߶� �ϳ��� �����ϰ� �ͽ��ϴ�. �׷��� ��ƼĿ �� ���� �����ϰ� �ڸ����� ������ �ִ� ��ƼĿ���� ������ �߶�� �մϴ�. ���� ��� �� �׸����� 80�� �����ִ� ��ƼĿ�� �����ϰ� �ڸ��� ������ ���� ������ 12�� 14�� ���� ��ƼĿ�� ���� �κ��� ������ �߶� �� 80�� ���� ��ƼĿ�� �����ڸ��� �ٵ��� �մϴ�. �̶� 12�� 14�� ���� ��ƼĿ�� �� ���� �˴ϴ�.

��ƼĿ�� ���� ���ڰ� �迭 sticker�� �־��� ��, �����ϰ� �߸� ��ƼĿ�� ���� ������ ���� �ִ밡 �ǵ��� ������ ���� ��ȯ�ϴ� �Լ��� �ϼ��� �ּ���.

���ѻ���
��ƼĿ�� ���̴� 1�̻� 100,000 �����Դϴ�.
��ƼĿ�� ���� ���ڴ� 10,000 ������ �ڿ��� �Դϴ�.
����� ��
sticker	result
[12, 12, 12, 12, 12]	36
[12, 80, 14, 22, 100]	180
����� �� ����
����� �� #1
��ƼĿ�� ���� ���ڰ� [12, 12, 12, 12, 12] �� ��� ù ��°, �� ��°, �ټ� ��°�� 12�� ���� ��ƼĿ 3���� �����ϰ� �ڸ��� ���� 36���� �ִ밡 �˴ϴ�.

����� �� #2
��ƼĿ�� ���� ���ڰ� [12, 80, 14, 22, 100] �� ��� 80�� 100�� ���� ��ƼĿ�� �����ϰ� �ڸ��� ���� 180���� �ִ밡 �˴ϴ�.
*/