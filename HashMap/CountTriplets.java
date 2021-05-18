import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CountTriplets {

    static void fillMap(HashMap<Long, Long> map, Long val) {
        if(map.containsKey(val)) {
            long n = map.get(val);
            map.put(val,++n);
        } else
            map.put(val, 1L);
    }

    static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        long rhs = 0;
        long lhs = 0;

        HashMap<Long, Long> rhsMap = new HashMap<>();
        HashMap<Long, Long> lhsMap = new HashMap<>();

        //fill rhsMap with all the list values
        for(Long val : arr) {
            fillMap(rhsMap,val);
        }

        for(Long val : arr) {
            long rightCount = 0;
            long leftCount = 0;
            lhs = 0;
            rhs = val*r;
            if(val%r == 0)
                lhs = val/r;

            long curr = rhsMap.get(val);
            rhsMap.put(val,--curr);

            if(rhsMap.containsKey(rhs))
                rightCount = rhsMap.get(rhs);
            
            if(lhsMap.containsKey(lhs))
                leftCount = lhsMap.get(lhs);
            
            count += rightCount*leftCount;
            //put into left
            fillMap(lhsMap,val);
        }
        return count;
    }


    public static void main(String ...arg) {
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(Long.valueOf(3));
        arr.add(Long.valueOf(9));
        arr.add(Long.valueOf(27));
        arr.add(Long.valueOf(3));
        arr.add(Long.valueOf(9));
        arr.add(Long.valueOf(27));
        arr.add(Long.valueOf(9));
        arr.add(Long.valueOf(3));
        System.out.println(countTriplets(arr,3));
    }
}