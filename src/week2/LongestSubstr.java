package week2;

public class LongestSubstr {

	public static void main(String[] args) {
		String inputStr="hello,world";
		longestSubstr(inputStr);
	}
	private static void longestSubstr(String inputStr){
		int count=0;
		String tempStr=inputStr;
		String longestSubStr=tempStr;
		int subStrLen=0;
		boolean result=false;
		for(int i=0;i<tempStr.length();i++){
			for(int j=i;j<tempStr.length();j++){
				//System.out.print(tempStr.substring(i,j+1));
				result=isDuplicate(tempStr.substring(i,j+1));
				//System.out.println("----->"+result);
				count++;
				if((result==false)&&(tempStr.substring(i,j+1).length()>subStrLen)){
					subStrLen=tempStr.substring(i,j+1).length();
					longestSubStr=tempStr.substring(i,j+1);
				}
			}
		}
		System.out.println(String.format("longest substring is '%s' and its length is %s and count is %s",longestSubStr,subStrLen,count));
	}
	private static boolean isDuplicate(String tempStr){
		boolean result=false;
		char[] array=tempStr.toCharArray();
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]==array[j])
					result= true;
			}
		}
		return result;
	}

}
