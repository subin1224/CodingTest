package subin_Study;

import java.util.Arrays;

public class Lamda {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1);
		for(int n : arr) System.out.print(n+" ");
	}
}
