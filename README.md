# Programmers.Level3_Java_WordConversion
Programmers DFS/BFS Level3_WordConversion

문자열 begin부터 문자열 배열 words 속의 단어들을 징검다리 역할로 이용하며 한단어씩 변환해가며 target까지 만들어 낼수 있는지, 있다면 step수를 return 만들 수 없다면 0을 return하는 문제였다.

최솟값을 구하기 위해 ```static int MAX = 100; int answer = MAX``` 선언, 가능한 모든 조합을 DFS로 만들어 target에 다다르면 step수를 return, 다다르지 못하면 MIN으로 두었다.

모든 경우를 검사하였는데 answer == MAX일 경우 0을 return하여 구현하였다.

다른 풀이들을 보았을 때 queue를 이용한 BFS방식으로 접근하여 문제를 푼 경우도 있었다. words의 길이가 50이하로 제한되어있지 않고 더 크다면 검사하는 경우의 수는 나의 코드가 더 많기 때문에 BFS방식의 접근이 더 좋아보였다.

BFS는 가장 먼저 target과 일치하도록 변경했을 때의 step수가 최소이기 때문에 loop를 멈춰 시간이 절약됬다. 

* BFS
```java
  Queue<Node> q = new LinkedList<>();


  boolean[] visit = new boolean[n];
  q.add(new Node(begin, 0));

  while(!q.isEmpty()) {
      Node cur = q.poll();
      if (cur.next.equals(target)) {
          ans = cur.step;
          break;
      }

      for (int i=0; i<n; i++) {
          if (!visit[i] && canConvert(cur.word, words[i])) {
              visit[i] = true;
              q.add(new Node(words[i], cur.step + 1));
          }
      }
  }

```
