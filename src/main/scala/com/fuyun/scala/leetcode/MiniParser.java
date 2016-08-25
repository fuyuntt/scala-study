package com.fuyun.scala.leetcode;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bl05959 on 2016/8/19.
 * https://leetcode.com/problems/mini-parser
 */
public class MiniParser {
    private Pattern pattern = Pattern.compile("\\[|-?\\d+");

    public static void main(String[] args) {
        new MiniParser().deserialize("[-1]");
    }

    public NestedInteger deserialize(String str) {
        if (str.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(str));
        }
        str = str.substring(1, str.length() - 1);
        Matcher matcher = pattern.matcher(str);
        NestedInteger integer = new NestedInteger();
        int cur = 0;
        while (matcher.find(cur)) {
            int start = matcher.start();
            if (str.charAt(start) == '[') {
                int end = findPair(str, start);
                integer.add(deserialize(str.substring(start, end + 1)));
                cur = end + 1;
            } else {
                integer.add(deserialize(matcher.group()));
                cur = matcher.end();
            }
        }
        return integer;
    }

    private int findPair(String str, int start) {
        if (str.charAt(start) != '[') {
            throw new IllegalArgumentException();
        }

        int dep = 1;
        int cur = start;
        while (dep > 0) {
            cur ++;
            if (cur >= str.length()) {
                throw new IllegalArgumentException("not 匹配");
            }
            if (str.charAt(cur) == '[') {
                dep++;
            } else if (str.charAt(cur) == ']') {
                dep--;
            }
        }
        return cur;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {

        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {

        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 1;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {

        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
