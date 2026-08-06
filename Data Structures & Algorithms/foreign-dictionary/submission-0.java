class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character ,Integer> nodes = new HashMap<>();
        HashMap<Integer ,Character> map = new HashMap<>();



        int n = 0;
        for(String word : words){
            for(char ch : word.toCharArray()){
                if(nodes.get(ch) == null){
                    nodes.put(ch ,n);
                    map.put(n++ ,ch);
                }
            }
        }

        System.out.println(nodes);
        System.out.println(map);

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int indegree[] = new int[n];

        for(int i = 1; i < words.length; i++){
            String s1 = words[i - 1];
            String s2 = words[i];

            if(s1.length() > s2.length() && s1.startsWith(s2)){
                return "";
            }

            for(int j = 0; j < Math.min(s1.length() ,s2.length()); j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    int u = nodes.get(s1.charAt(j));
                    int v = nodes.get(s2.charAt(j));
                    if(!graph.get(u).contains(v)){
                        graph.get(u).add(v);
                        indegree[v]++;
                    }
                    break;
                }
            }
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                que.offer(i);
            }
        }

        StringBuffer res = new StringBuffer();

        while(!que.isEmpty()){
            int node = que.poll();
            res.append(map.get(node));

            for(int adj : graph.get(node)){
                indegree[adj]--;
                if(indegree[adj] == 0){
                    que.offer(adj);
                }
            }
        }

        return res.length() == n ? res.toString() : "";


    }
}
