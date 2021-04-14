package subin;

import java.util.LinkedList;
import java.util.Queue;

public class Bridge {
    public static void main(String[] args) {
        int len = 2;
        int weight = 10;
        int[] truck = {7,4,5,6};
        int answer = solution(len, weight, truck);
        System.out.println(":::MAIN::::" + answer);
    }

    static class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        /*
        https://programmers.co.kr/learn/courses/30/lessons/42583
        return 모든 트럭이 다리를 건너기 위한 최소 사간
        1초에 길이가 1씩 트럭이 움직이며 다리에 있는 트럭들은 weight 을 넘으면 안됨
        먼저 들어간 자료가 먼저 나오는 구조인 FIFO 형식 => Queue 로 풀자
        */
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truck_weights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridge_length) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }


}