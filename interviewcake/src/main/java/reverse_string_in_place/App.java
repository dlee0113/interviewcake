package reverse_string_in_place;

// https://www.interviewcake.com/question/reverse-string-in-place
public class App {
	public static void main(String[] args) {
		String input = "abcde";
		
		char[] charArray = input.toCharArray();
		
		int i = 0;
		int j = charArray.length - 1;
		
		while (i < j) {
			char tmp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = tmp;
			
			i++;
			j--;
		}
		
		System.out.println(String.valueOf(charArray));
	}
}
