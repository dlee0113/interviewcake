package find_in_ordered_set;

// https://www.interviewcake.com/question/find-in-ordered-set
// http://algorithms.tutorialhorizon.com/binary-search/
public class App {
	public Boolean Search(int low, int high, int number, int[] arrA) {
		if (low > high) {
			return false;
		}
		int mid = (high + low) / 2;
		
		if (arrA[mid] == number)
			return true;
		else if (arrA[mid] > number)
			return Search(low, mid - 1, number, arrA);
		else
			return Search(mid + 1, high, number, arrA);
	}

	public static void main(String args[]) {
		int[] a = { 2, 5, 8, 10, 14, 44, 77, 78, 99 };
		int number = 99;
		
		App b = new App();
		System.out.println("The " + number + " present in array a ??? :"+ b.Search(0, a.length - 1, number, a));
		number = 76;
		System.out.println("The " + number + " present in array a ??? :"+ b.Search(0, a.length - 1, number, a));
	}
}
