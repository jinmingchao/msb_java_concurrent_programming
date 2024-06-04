package algorithm.algorithem;

import java.util.LinkedList;
import java.util.List;

/**
 *  https://www.bilibili.com/video/BV1bk4y1a7nF/?spm_id_from=333.788&vd_source=7ea1d4e1771c4e856c2a18bfc07f729a
 *  华为面试 日志: 首次上报日志最多积分
 *
 */
public class App_20240422 {

        public int solution() {
            int[] logSequence = new int[]{1,98,1};
            int len = logSequence.length;
            int[] dp = new int[len];
            dp[0] = logSequence[0];
            int max = dp[0], sum = dp[0];
            List<Integer> deductedScoreList = new LinkedList<>();

            for (int i = 1; i < len; i++) {
                sum += logSequence[i];
                if(sum >= 100) {
                    sum = 0;
                    continue;
                }

                int deductedScore = 0;
                int multiplier = 0;
                deductedScoreList.add(logSequence[i]);

                for (int idx = deductedScoreList.size() - 1; idx >= 0; idx--) {
                    deductedScore += deductedScoreList.get(idx) + multiplier++;
                }

//                dp[i] = sum -

            }

            return -1;
        }

}
