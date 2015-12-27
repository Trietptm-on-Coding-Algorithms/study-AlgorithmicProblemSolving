import java.util.Scanner;

public class Main {
    public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		while (c-- > 0) {
			int n = sc.nextInt();
			int l = sc.nextInt();

			Integer[] num = new Integer[n+1];
			num[0] = 0;
			for (int i = 1; i <= n; i++)
				num[i] = num[i-1] + sc.nextInt();

			double min = 101;
			for (int i = l; i <= n; i++)
				for (int j = i; j <= n; j++) {
					double a = (num[j] - num[j - i]) * 1.0 / i;
					if (min > a) min = a;
				}

	        System.out.println(min);
		}

		sc.close();
	}
}
