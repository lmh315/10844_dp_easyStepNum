package q10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		memo = new int[N + 1][10];
		int i, j, sum = 0;

		memo[1][1] = 1;
		memo[1][2] = 1;
		memo[1][3] = 1;
		memo[1][4] = 1;
		memo[1][5] = 1;
		memo[1][6] = 1;
		memo[1][7] = 1;
		memo[1][8] = 1;
		memo[1][9] = 1;

		for (i = 2; i <= N; i++) {
			memo[i][0] = memo[i - 1][1];
			memo[i][1] = (memo[i - 1][0] + memo[i - 1][2]) % 1000000000;
			memo[i][2] = (memo[i - 1][1] + memo[i - 1][3])  % 1000000000;
			memo[i][3] = (memo[i - 1][2] + memo[i - 1][4]) % 1000000000;
			memo[i][4] = (memo[i - 1][3] + memo[i - 1][5]) % 1000000000;
			memo[i][5] = (memo[i - 1][4] + memo[i - 1][6]) % 1000000000;
			memo[i][6] = (memo[i - 1][5] + memo[i - 1][7]) % 1000000000;
			memo[i][7] = (memo[i - 1][6] + memo[i - 1][8]) % 1000000000;
			memo[i][8] = (memo[i - 1][7] + memo[i - 1][9]) % 1000000000;
			memo[i][9] = memo[i - 1][8];
		}

		for (i = 0; i < 10; i++) {
			sum = (sum + memo[N][i]) % 1000000000;
		}

		System.out.println(sum % 1000000000);
		br.close();
	}
}
