package week3;

import java.util.Arrays;
//program to find unique triplets adding to a given number 
//taking into consideration an unsorted array
public class UniqueTriplets {

	public static void main(String[] args) {
		int array[]={-1,0,2,1,-1,1,5};
		int sum=0;
		int result[][]=tripletArrayBruteForce(array,sum);
		System.out.print("[");
		for(int i=0;i<result.length;i++){
			System.out.print("[");
			for(int j=0;j<result[i].length;j++){
				if(j==result[i].length-1){	
					System.out.print(result[i][j]);
				}
				else System.out.print(result[i][j]+",");
			}
			if(i==result.length)
				System.out.print("]");
			else
				System.out.print("],");

		}
		System.out.print("]");
	}
	private static int[][] tripletArrayBruteForce(int[] array,int sum){
		int returnArray[][]=new int[array.length][3];
		if(array.length<3)
			return null;
		int n=0;
		for(int i=0;i<array.length;i++){
			for(int j=1;j<array.length;j++){
				for(int k=2;k<array.length;k++){
					if((array[i]+array[j]+array[k])==sum){
						int subArray[]={array[i],array[j],array[k]};
						Arrays.sort(subArray);	
						if(uniqueCheck(returnArray,subArray)){
								returnArray[n++]=subArray;
						}
					}
				}
			}
		}
		return returnArray;
	}
	private static boolean uniqueCheck(int returnArray[][],int subArray[]){
		for(int i=0;i<returnArray.length;i++){
			if(Arrays.equals(returnArray[i], subArray))
				return false;
		}
		return true;
	}
}
