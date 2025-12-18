class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch: s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()==ch){
                stack.pop();
            } else{
                stack.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}