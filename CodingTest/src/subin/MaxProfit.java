package subin;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        /*
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        DP - Easy
        return 최대 이익
        가격이 최소인 날에 사고 -> 그나마 가격이 최대인 날에 팔아야 함
        만약 최대 이익을 못내면 상황이면 return 0

        - 내가 푼 방법
        1) 이중 for문 => Time Limit
        int profit = 0;
        for(int i=0; i<prices.length;i++){
            int buy = prices[i];
            for(int j=i+1; j<prices.length; j++){
                int sell = prices[j];
                profit = Math.max(sell-buy, profit);
            }
        }
        return profit;
         */

        //2) 이중 for문을 안쓰고 풀어보기 => 2ms
        int profit = 0;
        int buy = prices[0];
        for(int i=0; i<prices.length; i++){
            buy = Math.min(buy, prices[i]);
            profit = Math.max(prices[i]-buy, profit);
        }
        return profit;

        //3) Solution ... 나랑 한거랑 차이가 없는데 Math.max 때문에 성능차이가 나는듯 ?
        /*
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
        */
    }

}
