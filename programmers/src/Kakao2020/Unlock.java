package Kakao2020;

import java.util.Arrays;

/*
 * ��������� Ʃ��� ��� ���������� ������ ������ ������ ������ �����Ǵ� ����� ���� �߰��Ͽ����ϴ�. �׷��� ���� ������ ���캸�� Ư���� ������ �ڹ���� ��� �־��� �� �տ��� Ư���� ������ ����� �Բ� �ڹ��踦 Ǫ�� ����� ���� ������ ���� ������ �ִ� ���̰� �߰ߵǾ����ϴ�.

����ִ� �ڹ���� ���� �� ĭ�� ũ�Ⱑ 1 x 1�� N x N ũ���� ���簢 ���� �����̰� Ư���� ����� ����� M x M ũ���� ���簢 ���� ���·� �Ǿ� �ֽ��ϴ�.

�ڹ��迡�� Ȩ�� �Ŀ� �ְ� ���� ���� Ȩ�� ���� �κ��� �ֽ��ϴ�. ����� ȸ���� �̵��� �����ϸ� ������ ���� �κ��� �ڹ����� Ȩ �κп� �� �°� ä��� �ڹ��谡 ������ �Ǵ� �����Դϴ�. �ڹ��� ������ ��� �κп� �ִ� ������ Ȩ�� ����� �ڹ��踦 ���� �� ������ ���� ������, �ڹ��� ���� �������� ������ ���� �κа� �ڹ����� Ȩ �κ��� ��Ȯ�� ��ġ�ؾ� �ϸ� ������ ����� �ڹ����� ���Ⱑ �������� �ȵ˴ϴ�. ���� �ڹ����� ��� Ȩ�� ä�� ����ִ� ���� ����� �ڹ��踦 �� �� �ֽ��ϴ�.

���踦 ��Ÿ���� 2���� �迭 key�� �ڹ��踦 ��Ÿ���� 2���� �迭 lock�� �Ű������� �־��� ��, ����� �ڹ��踦 ���� ������ true��, �� �� ������ false�� return �ϵ��� solution �Լ��� �ϼ����ּ���.

���ѻ���
key�� M x M(3 �� M �� 20, M�� �ڿ���)ũ�� 2���� �迭�Դϴ�.
lock�� N x N(3 �� N �� 20, N�� �ڿ���)ũ�� 2���� �迭�Դϴ�.
M�� �׻� N �����Դϴ�.
key�� lock�� ���Ҵ� 0 �Ǵ� 1�� �̷���� �ֽ��ϴ�.
0�� Ȩ �κ�, 1�� ���� �κ��� ��Ÿ���ϴ�.
����� ��
key	lock	result
[[0, 0, 0], [1, 0, 0], [0, 1, 1]]	[[1, 1, 1], [1, 1, 0], [1, 0, 1]]	true
 * */
public class Unlock {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}} , new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));

	}
	static int extendLockStart;
	static int extendLockXYEnd;
	static int lockSize;
	static int keySize;
	
    public static boolean solution(int[][] key, int[][] lock) {
    	
        int[][] extendLock = new int[(key.length-1)*2+lock.length][(key.length-1)*2+lock.length];
        lockSize = lock.length;
        keySize = key.length;
        extendLockStart = key.length-1;
        extendLockXYEnd = extendLock.length- keySize;
        System.out.println(extendLockStart +", "+extendLockXYEnd);
       
        
        //lock ä���
        for(int i = 0; i <lock.length ; i++) {
        	for(int j =0 ; j <lock.length ; j++) {
        		extendLock[key.length +i-1][key.length +j-1] = lock[i][j];
        	}
        	
        }
        
        
        //0�� ȸ�� ���¿��� ã��
        int pivotX;
        int pivotY;
        
        for(pivotX =0 ; pivotX < keySize + lockSize -1; pivotX++) {
        	for(pivotY =0 ; pivotY < keySize + lockSize -1; pivotY++) {
        		//�ش� �������� ����
        		if(isOpen(key, extendLock, pivotX, pivotY)) {
        			return true;
        		}
            }
        }
        
        key = rotate90(key);
        //90�� ȸ�� ���¿��� ã��
        for(pivotX =0 ; pivotX < keySize + lockSize -1; pivotX++) {
        	for(pivotY =0 ; pivotY < keySize + lockSize -1; pivotY++) {
        		//�ش� �������� ����
        		if(isOpen(key, extendLock, pivotX, pivotY)) {
        			return true;
        		}
            }
        }
        
        key = rotate90(key);
        //180�� ȸ�� ���¿��� ã��
        for(pivotX =0 ; pivotX < keySize + lockSize -1; pivotX++) {
        	for(pivotY =0 ; pivotY < keySize + lockSize -1; pivotY++) {
        		//�ش� �������� ����
        		if(isOpen(key, extendLock, pivotX, pivotY)) {
        			return true;
        		}
            }
        }
        
        key = rotate90(key);
        //270�� ȸ�� ���¿��� ã��
        for(pivotX =0 ; pivotX < keySize + lockSize -1; pivotX++) {
        	for(pivotY =0 ; pivotY < keySize + lockSize -1; pivotY++) {
        		//�ش� �������� ����
        		if(isOpen(key, extendLock, pivotX, pivotY)) {
        			return true;
        		}
            }
        }

    	return false;
    }
    
    private static boolean isOpen(int[][] key, int[][] extendLock, int pivotX, int pivotY) {
    	int[][] clone = deepCopy(extendLock);
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				clone[i+pivotX][j+pivotY] += key[i][j];
			}
		}
		
//		printArr(clone);
//		System.out.println();
		
		
		boolean isFit =true;
		for(int i=extendLockStart ; i <= extendLockXYEnd ; i++) {
			for(int j=extendLockStart ; j <= extendLockXYEnd ; j++) {
				if(clone[i][j] !=1) {
					return false;
				}
			}
		}
		
		
		
		return isFit;
	}

	private static int[][] deepCopy(int[][] extendLock) {
		int[][] result = new int[extendLock.length][extendLock.length];
	    for (int i = 0; i < extendLock.length; i++) {
	        System.arraycopy(extendLock[i], 0, result[i], 0, extendLock[i].length);
	    }
	    return result;
	}

	private static void printArr(int[][] extendLock) {
		for (int i = 0; i < extendLock.length; i++) {
			System.out.println(Arrays.toString(extendLock[i]));
		}
		
	}

	public static int[][] rotate90(int[][] key){
    	int[][] clone = new int[keySize][keySize];
    	for(int row=0; row <keySize ; row++) {
    		for(int col =0 ; col< keySize ; col++) {
    			clone[col][keySize-1-row] = key[row][col];
    		}
    	}
    	return clone;
    }
}
