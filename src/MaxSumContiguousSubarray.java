import java.util.ArrayList;
import java.util.List;

public class MaxSumContiguousSubarray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int maxSubArray(final List<Integer> A) {
        int max=Integer.MIN_VALUE;
        int sum=0;

        for (int i=0; i<A.size(); i++) {
            sum=A.get(i);
            for (int j=i+1; j<A.size(); j++) {
                sum+=A.get(j);
                if (sum>=max) max=sum;
            }
        }
        if (sum>max) max = sum;
        return max;
    }

    public static void main(String args[]) {
        List<Integer> A = new ArrayList<>();

        A.add(-500);

        System.out.println(maxSubArray(A));
    }
}
