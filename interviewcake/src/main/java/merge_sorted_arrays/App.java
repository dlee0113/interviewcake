package merge_sorted_arrays;

import java.util.Arrays;

// https://www.interviewcake.com/question/merge-sorted-arrays
public class App {
	public static void main(String[] args) {
		int[] my_list = { 3, 4, 6, 10, 11, 15 };
		int[] alices_list = { 1, 5, 8, 12, 14, 19 };
		int[] merged_list = merge_lists(my_list, alices_list);
		
		System.out.println("my_list: " + Arrays.toString(my_list));
		System.out.println("alices_list: " + Arrays.toString(alices_list));
		System.out.println("merged_list: " + Arrays.toString(merged_list));
	}
	
	public static int[] merge_lists(int[] my_list, int[] alices_list) {
		int[] merged_list = new int[my_list.length + alices_list.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < my_list.length && j < alices_list.length) {
			if (my_list[i] < alices_list[j]) {
				merged_list[k] = my_list[i];
				i++;
			}
			else {
				merged_list[k] = alices_list[j];
				j++;
			}
			
			k++;
		}
		
		while (i < my_list.length) {
			merged_list[k] = my_list[i];
			i++;
			k++;
		}
		
		while (j < alices_list.length) {
			merged_list[k] = alices_list[j];
			j++;
			k++;
		}
		
		return merged_list;
	}
}
