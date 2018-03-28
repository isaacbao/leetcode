package io.github.isaacbao;

import io.github.isaacbao.leetcode.GroupAnagrams;
import io.github.isaacbao.leetcode.Permute2;
import io.github.isaacbao.leetcode.Rotate;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"abc","cba","ccca","aacba","dsfsd","aac","bba","acb","bac","accc"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
//        StringBuilder s1 = new StringBuilder("33300");
//        StringBuilder s2 = new StringBuilder("5994");
//        System.out.println(new MultiplyStrings().plus(s2,s1));
    }
}