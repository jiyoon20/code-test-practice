import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        List<List<Integer>> listArray = new ArrayList<>();

        for (int i=0; i<w; i++) {
            listArray.add(new ArrayList<>());
        }

        int count=1;
        int j=0;
        int check_arr = -1;

        while (count <= n) {
            if (j % 2 == 0) {
                for (int k=0; k < w && count <= n; k++) {
                    listArray.get(k).add(count);
                    if (count == num)
                        check_arr = k;
                    count++;
                }
            } else {
                for (int k=w-1; k >= 0 && count <= n; k--) {
                    listArray.get(k).add(count);
                    if (count == num)
                        check_arr = k;
                    count++;
                }
            }
            j++;
        }

        if (check_arr == -1) return -1;
        int index = listArray.get(check_arr).indexOf(num);
        answer = listArray.get(check_arr).size()-index;

        return answer;
    }
}