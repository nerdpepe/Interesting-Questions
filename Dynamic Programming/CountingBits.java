public class CountingBits {
    int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        for(int i = 1; i<=n; i++) {
            ans[i] = (i%2==0)?(ans[i/2]):(ans[i/2] + 1);
            System.out.println(i + " - " +ans[i]);
        }
        return ans;
    }

    public static void main(String ... arg) {
        CountingBits c = new CountingBits();
        int[] ans = c.countBits(32);
        System.out.print(ans);
    }
}