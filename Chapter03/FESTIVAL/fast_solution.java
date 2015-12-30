import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int cNum = Integer.parseInt(br.readLine());
		for (int i=0; i<cNum; i++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int ol = l;
			int[] cost = new int[n];
			int[] sum_buf = new int[n+1];
			sum_buf[0] = 0;
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				cost[j] = Integer.parseInt(st.nextToken());
				sum_buf[j+1] = sum_buf[j]+cost[j];
			}

			double min = 9999999;

			while (l<=n && l<2*ol){
				int minSum = 9999999;
				for (int j=0; j+l<=n; j++)
					minSum = Math.min(sum_buf[j+l]-sum_buf[j], minSum);
				min = Math.min((Double.parseDouble(divide(minSum, l++, 0).toString())), min);
			}
			System.out.println(String.format("%.8f", min));
		}
		br.close();
	}
	private static StringBuilder divide(int child, int mother, int i) {
		StringBuilder sb = new StringBuilder();
		if (i==1)
			sb.append('.');

		sb.append((child/mother));
		child = (child%mother)*10;
		if (child != 0 && i<8)
			return sb.append(divide(child, mother, i+1));
		else return sb;
	}
}
