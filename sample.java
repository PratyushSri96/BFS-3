// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Remove invalid paranthesis
class Solution {
    //Using DFS
    int max;
    List<String> result;
    Set<String> set;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        set = new HashSet<>();
        set.add(s);
        dfs(s);
        return result;     
    }

    private void dfs(String s){
        //base
        if(s.length() < max) return;
        if(isValid(s)){
            if(s.length() > max) {
                result = new ArrayList<>();
                max = Math.max(max, s.length());
            }
             result.add(s);
             return;
        }

        //logic
        for(int k = 0 ; k < s.length();k++){
                    String subString = s.substring(0, k) + s.substring(k+1);
                    if(!set.contains(subString)){
                        set.add(subString);
                        dfs(subString);
                    }
        }

    }

    private boolean isValid(String s){
        int count = 0 ;
        int n = s.length();
        for(int i = 0 ; i < n ; i++ ){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            if(c == '('){
                count++;
            }
            if(c == ')'){
                if(count == 0) return false;
                count --;
            }
        }

        return count == 0;
    }
}

class Solution {
    //Using BFS
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0 ; i < size;i++){
                 String curr = q.poll();
                 if(isValid(curr)){
                     flag = true;
                    result.add(curr);
            }else{
                
                    for(int k = 0 ; k < curr.length();k++){
                    String subString = curr.substring(0, k) + curr.substring(k+1);
                    if(!set.contains(subString)){
                        q.add(subString);
                        set.add(subString);
                    }
                    
                  }
            
                
            }
            }
           

            
              
        }

        return result;

        
    }

    private boolean isValid(String s){
        int count = 0 ;
        int n = s.length();
        for(int i = 0 ; i < n ; i++ ){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            if(c == '('){
                count++;
            }
            if(c == ')'){
                if(count == 0) return false;
                count --;
            }
        }

        return count == 0;
    }
}

//Clone graph
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //using BFS
    Map<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node  == null) return node;
        this.map = new HashMap();
        Queue<Node> q = new LinkedList<>();
        Node nodeCopy = createClone(node);
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i<size;i++){
                 Node curr = q.poll();
                 List<Node> neighbors = curr.neighbors;
                 for(Node neighbor : neighbors){
                    if(!map.containsKey(neighbor)){
                        q.add(neighbor);
                       
                    }
                     Node nCopy = createClone(neighbor);
                    map.get(curr).neighbors.add(nCopy);
                 }

            }
        }

        return nodeCopy;

        
    }

    private Node createClone(Node node){
        if(map.containsKey(node)) return map.get(node);
        Node currCopy = new Node(node.val);
        map.put(node,currCopy);
        return currCopy;

    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //using BFS
    //here I am using size variable to iterate over  each level 
    Map<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node  == null) return node;
        this.map = new HashMap();
        Queue<Node> q = new LinkedList<>();
        Node nodeCopy = createClone(node);
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i<size;i++){
                 Node curr = q.poll();
                 List<Node> neighbors = curr.neighbors;
                 for(Node neighbor : neighbors){
                    if(!map.containsKey(neighbor)){
                        q.add(neighbor);
                       
                    }
                     Node nCopy = createClone(neighbor);
                    map.get(curr).neighbors.add(nCopy);
                 }

            }
        }

        return nodeCopy;

        
    }

    private Node createClone(Node node){
        if(map.containsKey(node)) return map.get(node);
        Node currCopy = new Node(node.val);
        map.put(node,currCopy);
        return currCopy;

    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //using DFS
    Map<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node  == null) return node;
        this.map = new HashMap();
        Node nCopy = createClone(node);
        dfs(node);
        return nCopy;
        
    }

    private void dfs(Node node){
        //base case
        //if(map.containsKey(node)) return;

        //logic
        Node currCopy = createClone(node);
        List<Node> neighbors = node.neighbors;
        for(Node neighbor : neighbors){
            if(!map.containsKey(neighbor)){
                dfs(neighbor);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }

    }

    private Node createClone(Node node){
        if(map.containsKey(node)) return map.get(node);
        Node currCopy = new Node(node.val);
        map.put(node,currCopy);
        return currCopy;

    }
}


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //using DFS
    Map<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node  == null) return node;
        this.map = new HashMap();
        Node nCopy = createClone(node);
        dfs(node);
        return nCopy;
        
    }

    private void dfs(Node node){
        
        //logic
        Node currCopy = createClone(node);
        List<Node> neighbors = node.neighbors;
        for(Node neighbor : neighbors){
            if(!map.containsKey(neighbor)){
                dfs(neighbor);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }

    }

    private Node createClone(Node node){
        if(map.containsKey(node)) return map.get(node);
        Node currCopy = new Node(node.val);
        map.put(node,currCopy);
        return currCopy;

    }
}
