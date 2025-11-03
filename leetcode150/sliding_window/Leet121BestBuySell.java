package sliding_window;

public class Leet121BestBuySell {

    public static void main(String[] args) {
        Leet121BestBuySell solution = new Leet121BestBuySell();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int max = 0;

        for(int i=0;i<prices.length;i++) {
            if(prices[i]<low) {
                low = prices[i];
            }
            max = Math.max(prices[i]-low,max);
        }

        return max;
    }
}