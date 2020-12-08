import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int [] numbers1 = {2,1,3,4,1};
        sol.Solution(numbers);

        int [] numbers2 = {2,1,3,4,1};
        sol.Solution(numbers2);
    }
}

// 주어진 numbers에서 서로다른 인덱스에 있는 두 개의 수를 뽑아 더해서
// 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<Integer>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // 정렬후 array로 리턴
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
