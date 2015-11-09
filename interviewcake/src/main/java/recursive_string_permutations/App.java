package recursive_string_permutations;

// https://www.interviewcake.com/question/recursive-string-permutations
// http://www.ericleschinski.com/c/java_permutations_recursion/
public class App {
	public static void main(String[] args) {
		permutation("", "ABC");
	}

	private static void permutation(String prefix, String str) {
		System.out.println("prefix: " + prefix + ", str:" + str);
		
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
//				System.out.println(str.charAt(i));
//						+ " str.charAt(" + i + "): " + str.charAt(i) 
//						+ " str.substring(0," + i + ") " + str.substring(0, i));
				
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1));
		}
	}
}
