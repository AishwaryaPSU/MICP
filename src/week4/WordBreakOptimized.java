package week4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
@RunWith(value = BlockJUnit4ClassRunner.class)
public class WordBreakOptimized {

//Junit test cases
	@Test 
	public void testValidCaseTrue() {
		String[] dictionary = { "pear", "salmon", "foot", "prints", "footprints", "leave", "you", "sun", "girl",
				"enjoy" };
		String inputstr = "pearyou";
		HashMap<Character, List<String>> hm = createHmap(dictionary);
		boolean result=wordBreakCheck(hm, inputstr);
		assertEquals(true, result);
	}
	@Test(expected = IllegalArgumentException.class) 
	public void testExceptionForSpecialCharacter() {
		String[] dictionary = { "pear", "salmon", "foot", "prints", "footprints", "leave", "you", "sun", "girl",
				"enjoy" };
		String inputstr = "pearyou$$";
		HashMap<Character, List<String>> hm = createHmap(dictionary);
		wordBreakCheck(hm, inputstr);
	}
	@Test 
	public void testValidCaseFalse() {
		String[] dictionary = { "pear", "salmon", "foot", "prints", "footprints", "leave", "you", "sun", "girl",
				"enjoy" };
		String inputstr = "firstclass";
		HashMap<Character, List<String>> hm = createHmap(dictionary);
		boolean result=wordBreakCheck(hm, inputstr);
		assertEquals(false, result);
	}
	@Test 
	public void testEmptyCase() {
		String[] dictionary = { "pear", "salmon", "foot", "prints", "footprints", "leave", "you", "sun", "girl",
				"enjoy" };
		String inputstr = "";
		HashMap<Character, List<String>> hm = createHmap(dictionary);
		boolean result=wordBreakCheck(hm, inputstr);
		assertEquals(false, result);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testForNull() {
		String[] dictionary = { "pear", "salmon", "foot", "prints", "footprints", "leave", "you", "sun", "girl",
				"enjoy" };
		String inputstr = null;
		HashMap<Character, List<String>> hm = createHmap(dictionary);
		wordBreakCheck(hm, inputstr);
	}

	private static boolean wordBreakCheck(HashMap<Character, List<String>> hm, String inputstr) {
		if (inputstr == null)
			throw new IllegalArgumentException();
		if (inputstr.equals(""))
			return false;
		String tempstr = inputstr.toLowerCase();
		//regex for alphabets only
		Pattern validPattern = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = validPattern.matcher(tempstr);
		boolean isSpecialCharacter = matcher.find();
		if (isSpecialCharacter)
			throw new IllegalArgumentException();
		while (!tempstr.equals("")) {
			//boolean flag to indicate successful match
			boolean isPresent = false;
			if (!hm.containsKey(tempstr.charAt(0)))
				return false;
			List<String> listOfWords = hm.get(tempstr.charAt(0));
			for (String value : listOfWords) {
				if (tempstr.contains(value)) {
					tempstr = tempstr.replace(value, "");
					isPresent = true;
				}
			}
			if (isPresent == false)
				return false;
		}
		return tempstr.equals("");
	}

	private static HashMap<Character, List<String>> createHmap(String[] dictionary) {
		HashMap<Character, List<String>> strMap = new HashMap<Character, List<String>>();
		for (int i = 0; i < dictionary.length; i++) {
			if (strMap.containsKey(dictionary[i].charAt(0))) {
				List<String> existingList = strMap.get(dictionary[i].charAt(0));
				existingList.add(dictionary[i].toLowerCase());
				strMap.put(dictionary[i].charAt(0), existingList);
			} else {
				List<String> newlist = new ArrayList<String>();
				newlist.add(dictionary[i].toLowerCase());
				strMap.put((dictionary[i].charAt(0)), newlist);
			}
		}
		return strMap;
	}
}
