package week4;

public class WordBreak {

	public static void main(String[] args) {
		String[] dictionary = { "pear","salmon","foot","prints"};
		String input = "salmonloop";
		System.out.println(wordbreakcheck(dictionary, input));
	}

	private static boolean wordbreakcheck(String[] dictionary, String input) {
		if(input.equals("")||(input==null))
			return false;
		String resultIP=input;
		for (String substrOfinput:dictionary) {
				if (resultIP.contains(substrOfinput)) {
					resultIP=resultIP.replace(substrOfinput, "");
				}
		}
		return resultIP.equals("");
		}
}