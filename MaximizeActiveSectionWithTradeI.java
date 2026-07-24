import java.util.*;

public class MaximizeActiveSectionWithTradeI {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = (int) s.chars().filter(c -> c == '1').count();

        List<Integer> zeroGroups = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (!zeroGroups.isEmpty() && i > 0 && s.charAt(i - 1) == '0') {
                    zeroGroups.set(zeroGroups.size() - 1, zeroGroups.get(zeroGroups.size() - 1) + 1);
                } else {
                    zeroGroups.add(1);
                }
            }
        }

        int maxZeroMerge = 0;
        for (int i = 0; i < zeroGroups.size() - 1; i++) {
            maxZeroMerge = Math.max(maxZeroMerge, zeroGroups.get(i) + zeroGroups.get(i + 1));
        }
        return totalOnes + maxZeroMerge;
    }

    public static void main(String[] args) {
        MaximizeActiveSectionWithTradeI sol = new MaximizeActiveSectionWithTradeI();
        System.out.println(sol.maxActiveSectionsAfterTrade("01"));      //1
        System.out.println(sol.maxActiveSectionsAfterTrade("0100"));    //4
        System.out.println(sol.maxActiveSectionsAfterTrade("1000100")); //7
        System.out.println(sol.maxActiveSectionsAfterTrade("01010"));   //4
    }
}
