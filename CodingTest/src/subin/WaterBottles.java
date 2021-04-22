package subin;

public class WaterBottles {
    public static void main(String[] args) {
        int b = 9;
        int e = 3;
        System.out.println("Main::::" + numWaterBottles(b,e));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        /*
        https://leetcode.com/problems/water-bottles/
        numBottles : 처음 물병 갯수
        numExchange : 이 수 만큼 하나의 물이 들어있는 병으로 바꿀 수 있음
        return 총 물이 든 병 갯수
        */
        int answer = numBottles;

        while(true){
            answer+=(numBottles/numExchange);
            numBottles = (numBottles/numExchange) + (numBottles%numExchange);
            if(numBottles<numExchange) break;
        }
        return answer;
    }

}