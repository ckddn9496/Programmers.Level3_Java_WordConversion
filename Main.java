public class Main {

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};	//	return 4
//		String[] words = {"hot", "dot", "dog", "lot", "log"};	//	return 0
//		String[] words = {"hot", "dot", "cog", "lot"};	//	return 0
		
		System.out.println(new Solution().solution(begin, target, words));
	}

}
class Solution {
	private static int MAX = 100;
	int answer = MAX;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean exist = false;
        boolean[] visited = new boolean[words.length];
        // 먼저 target과 일치하는 단어가 words에 존재하지 않으면 return 0
        for (String word : words) { 
        	if (word.equals(target)) {
        		exist = true;
        		break;
        	}
        }
        if (!exist)
        	return 0;
        
        answer = dfs(begin, target, words, visited, 0);
        if (answer == MAX)
        	return 0;
        return answer;
    }

	private int dfs(String begin, String target, String[] words, boolean[] visited, int step) {
		// 더 이상 조사할 단어가 없을 때
		if (begin.equals(target))
			return step;
		
		
		if (step > words.length)
			return 0; // 만들지 못함
		
			
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int miscount = 0;
			if (visited[i] == false) { // 거쳐가지 않았음 begin에서 변환 가능한지 검사
				for (int j = 0; j < word.length(); j++) {
					if (begin.charAt(j) != word.charAt(j))
						miscount++;
				}
				if (miscount == 1) {
					visited[i] = true; // 거쳐갈것이다.
					int result = dfs(word, target, words, visited, step+1);
					if (result != 0)
						answer = answer > result ? result : answer;
					visited[i] = false;
				}
			}
		}
		return answer;
	}
}