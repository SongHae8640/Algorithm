package webJobFair;

import java.util.Arrays;

public class MaxStickersSum {

	public static void main(String[] args) {
		solution(new int[] {12, 12, 12, 12, 12});
		solution(new int[] {12, 80, 14, 22, 100});
	}
	
    public static int solution(int[] sticker) {
        int answer = 0;

        //편한 계산을 위해 stickers 확장(양 끝에 0으로 둠)
        int[] exSticker = new int[sticker.length+2];
        for (int i = 0; i < sticker.length; i++) {
			exSticker[i+1] = sticker[i];
		}
        
        //각 스티커를 잘랐을때 이득이 큰 값을 구함
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
다음 그림과 같이 숫자가 적혀있는 스티커가 한 줄로 붙어있습니다.

image

한 줄로 붙어있는 스티커를 가위로 잘라 하나씩 보관하고 싶습니다. 그러나 스티커 한 개를 깨끗하게 자르려면 인접해 있는 스티커들을 가위로 잘라야 합니다. 예를 들어 위 그림에서 80이 적혀있는 스티커를 깨끗하게 자르고 싶으면 먼저 양쪽의 12와 14가 적힌 스티커의 점선 부분을 가위로 잘라낸 후 80이 적힌 스티커의 가장자리를 다듬어야 합니다. 이때 12와 14가 적힌 스티커는 못 쓰게 됩니다.

스티커에 적힌 숫자가 배열 sticker로 주어질 때, 깨끗하게 잘린 스티커에 적힌 숫자의 합이 최대가 되도록 숫자의 합을 반환하는 함수를 완성해 주세요.

제한사항
스티커의 길이는 1이상 100,000 이하입니다.
스티커에 적힌 숫자는 10,000 이하의 자연수 입니다.
입출력 예
sticker	result
[12, 12, 12, 12, 12]	36
[12, 80, 14, 22, 100]	180
입출력 예 설명
입출력 예 #1
스티커에 적힌 숫자가 [12, 12, 12, 12, 12] 인 경우 첫 번째, 세 번째, 다섯 번째의 12가 적힌 스티커 3개를 깨끗하게 자르면 합이 36으로 최대가 됩니다.

입출력 예 #2
스티커에 적힌 숫자가 [12, 80, 14, 22, 100] 인 경우 80과 100이 적힌 스티커를 깨끗하게 자르면 합이 180으로 최대가 됩니다.
*/