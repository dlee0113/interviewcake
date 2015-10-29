package apple_stocks;

public class App {
	public static void main(String[] args) {
		int[] stock_prices_yesterday = {5, 10, 15, 12, 8, 20};
		
		System.out.println(brute_force(stock_prices_yesterday));
		
		System.out.println(optimized(stock_prices_yesterday));
	}
	
	public static int brute_force(int[] stock_prices_yesterday) {
		int max_profit = 0;
		
		for (int i = 0; i < stock_prices_yesterday.length; i++) {
			for (int j = i; j < stock_prices_yesterday.length; j++) {
				int earlier_price = stock_prices_yesterday[i];
				int later_price = stock_prices_yesterday[j];
				int potential_profit = later_price - earlier_price;
				
				System.out.println(earlier_price + " - " + later_price + " = " + potential_profit);
				
				if (potential_profit > max_profit) {
					max_profit = potential_profit;
				}
			}
		}
		
		return max_profit;
	}
	
	// complexity: O(n) time and O(1) space
	public static int optimized(int[] stock_prices_yesterday) {
		int min_price = stock_prices_yesterday[0];
		int max_profit = stock_prices_yesterday[1] - stock_prices_yesterday[0];
		
		for (int i = 0; i < stock_prices_yesterday.length; i++) {
			if (i == 0) {
				continue;
			}
			
			int current_price = stock_prices_yesterday[i];
			int potential_profit = current_price - min_price;
			
			if (potential_profit > max_profit) {
				max_profit = potential_profit;
			}
			
			if (current_price < min_price) {
				min_price = current_price; 
			}
		}
		
		return max_profit;
	}
}
