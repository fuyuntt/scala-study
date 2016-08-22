package com.fuyun.scala;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bl05959 on 2016/8/19.
 * https://leetcode.com/problems/mini-parser
 */
public class MiniParser {
    private Pattern pattern = Pattern.compile("\\[[^\\[\\]]*\\]|-?\\d+");

    public static void main(String[] args) {
        new MiniParser().deserialize("[-1]");
    }

    private NestedInteger deserialize(String str) {
        if (str.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(str));
        }
        str = str.substring(1, str.length() - 1);
        Matcher matcher = pattern.matcher(str);
        NestedInteger integer = new NestedInteger();
        while (matcher.find()) {
            String group = matcher.group();
            integer.add(deserialize(group));
        }
        return integer;
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
