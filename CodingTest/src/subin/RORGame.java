package subin;

import java.util.*;

public class RORGame {
	/*
    https://programmers.co.kr/learn/courses/30/lessons/1844
    ROR 게임
    게임 맵의 상태 maps
    캐릭터가 상대팀 진영에 도착 하기 이해 지나가야하는 칸의 개수의 최소값 return
     => BFS 문제 ( 큐를 이용 )
    상대팀 진영에 도착 할 수 없을때는 -1 return
    내 캐릭터는 1,1 에 상대 진영은 n,m 위치 (맵은 nxm) + n, m은 서로 같을수도, 서로 다를 수 도 있음.
    0은 벽이 있는 자리, 1은 벽이 없는 자리

    나 : maps[0][0]
    접근 해야 하는 곳 : maps[maps.length-1][maps[0].length-1]
	 */

	class Position{ //좌표 class
		int x,y;

		public Position(int x, int y){
			super();
			this.x=x;
			this.y=y;
		}

		boolean isValid(int width, int height){ //해당 좌표가 존재하는지 체크
			if(x < 0 || x >= width) return false;
			if(y < 0 || y >= height) return false;
			return true;
		}
	}

	public int solution(int[][] maps) {
		int mapHeight = maps.length;
		int mapWidth = maps[0].length;
		Queue<Position> q = new LinkedList<>();
		int[][] count = new int[mapHeight][mapWidth]; //최단거리를 구하기 위한 변수
		boolean[][] visited = new boolean[mapHeight][mapWidth];  //지나온 길인지 아닌지 확인을 위한 변수

		q.offer(new Position(0,0));
		count[0][0] = 1;
		visited[0][0] = true;

		// 큐에 데이터가 존재할때 까지 반복
		// 먼저 도착하는 쪽이 visited를 true로 바꿔놓았기 때문에 큐는 비어질 수 밖에 없음
		while(!q.isEmpty()){
			Position cur = q.poll();

			int curCount = count[cur.y][cur.x];

			//4가지 경우 (동, 서, 남, 북)
			final int[][] moving = {{0,-1},{0,1},{-1,0},{1,0}};
			for(int i=0; i<moving.length; i++){
				Position moved = new Position(cur.x + moving[i][0], cur.y + moving[i][1]);
				if(!moved.isValid(mapWidth, mapHeight)) continue;
				if(visited[moved.y][moved.x]) continue;
				if(maps[moved.y][moved.x] == 0 ) continue;

				//방문하지 않은 위치 && 벽이 아닌 경우 && x축 범위와 y축 범위를 넘어서지 않을때
				count[moved.y][moved.x] = curCount+1;
				visited[moved.y][moved.x] = true;
				q.offer(moved);
			}
		}

		int answer = count[mapHeight-1][mapWidth-1];
		if(answer==0) return -1;

		return answer;
	}
}
