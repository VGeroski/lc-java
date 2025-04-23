package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem (187): Repeated DNA Sequences
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 * 
 * Given a string s that represents a DNA sequence, 
 * return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * You may return the answer in any order.
 */
public class RepeatedDnaSequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        
        // generate all substrings
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            // add in map, if already exists, update value
            map.put(substring, map.getOrDefault(substring, 0) + 1);
        }

        // extract keys that appeared more than once
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> item : map.entrySet())
            if (item.getValue() > 1) 
                result.add(item.getKey());
        
        return result;
    }

    public static void main(String[] args) {
        String dna1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String dna2 = "AAAAAAAAAAAAA";

        List<String> repeadDnaSeq = findRepeatedDnaSequences(dna1);
        System.out.println("repeated dna seq for first dna:");
        repeadDnaSeq.stream().forEach(i -> System.out.println(i + " "));

        repeadDnaSeq.clear();
        repeadDnaSeq = findRepeatedDnaSequences(dna2);
        System.out.println("repeated dna seq for second dna:");
        repeadDnaSeq.stream().forEach(i -> System.out.println(i + " "));
    }
}