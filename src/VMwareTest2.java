import java.util.Scanner;

public class VMwareTest2 {


	static int countWaysUtil(int n)
    {
		int m=2;
        if (n <= 1)
            return n;
        int res = 0;
        for (int i = 1; i<=m && i<=n; i++)
            res += countWaysUtil(n-i);
        return res;
    }
    // Returns number of ways to reach s'th stair
    static int countWays(int s)
    {
        return countWaysUtil(s+1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =5;
		VMwareTest2 s = new VMwareTest2();
		System.out.println(s.countWays(n));
	}
}
