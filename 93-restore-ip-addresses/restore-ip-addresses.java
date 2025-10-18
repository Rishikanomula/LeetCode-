class Solution {
    public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    backtrack(s, 0, new ArrayList<>(), result);
    return result;
}

private void backtrack(String s, int start, List<String> path, List<String> result) {
    if (path.size() == 4) {
        if (start == s.length()) {
            result.add(String.join(".", path));
        }
        return;
    }

    for (int end = start + 1; end <= s.length() && end <= start + 3; end++) {
        String segment = s.substring(start, end);
        if (isValid(segment)) {
            path.add(segment);
            backtrack(s, end, path, result);
            path.remove(path.size() - 1);
        }
    }
}

private boolean isValid(String segment) {
    if (segment.length() > 1 && segment.startsWith("0")) return false;
    int val = Integer.parseInt(segment);
    return val >= 0 && val <= 255;
}
}