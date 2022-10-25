import java.util.*;

class Solution {

    static Set<Set<String>> answer;
    static String[] userIds, bannedIds;
    static int bLen;

    public int solution(String[] user_id, String[] banned_id) {

        answer = new HashSet<>();
        userIds = user_id;
        bannedIds = banned_id;
        bLen = bannedIds.length;

        dfs(new LinkedHashSet<>());

        return answer.size();

    }

    private static void dfs(Set<String> set) {

        if (set.size() == bLen) {
            if (isBannedId(set)) answer.add(new HashSet<>(set));

            return;
        }

        for (String userId : userIds) {
            if (set.add(userId)) {
                dfs(set);
                set.remove(userId);
            }
        }

    }

    private static boolean isBannedId(Set<String> set) {

        int idx = 0;

        for (String userId : set) {
            String bannedId = bannedIds[idx++];

            if (userId.length() != bannedId.length()) return false;

            for (int i = 0, len = userId.length(); i < len; i++) {
                if (bannedId.charAt(i) == '*') continue;

                if (userId.charAt(i) != bannedId.charAt(i)) return false;
            }
        }

        return true;

    }

}