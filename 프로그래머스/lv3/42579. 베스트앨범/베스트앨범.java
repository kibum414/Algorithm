import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {

        int len = genres.length;
        Map<String, Integer> map = new HashMap<>();

        // 장르별 총 재생횟수
        for (int i = 0; i < len; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 재생횟수 내림차순으로 장르 정렬
        List<String> genreList = new ArrayList<>(map.keySet());
        Collections.sort(genreList, (s1, s2) -> map.get(s2) - map.get(s1));

        List<Integer> idxList = new ArrayList<>();

        for (int i = 0, size = genreList.size(); i < size; i++) {
            String genre = genreList.get(i);

            // 재생횟수 최댓값
            int max = 0;
            // 그 때의 인덱스(고유번호)
            int firstIdx = -1;

            for (int j = 0; j < len; j++) {
                if (genre.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            max = 0;
            int secondIdx = -1;

            for (int j = 0; j < len; j++) {
                if (genre.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }

            idxList.add(firstIdx);
            if (secondIdx != -1) idxList.add(secondIdx);
        }

        return idxList.stream().mapToInt(i -> i).toArray();

    }

}