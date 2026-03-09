
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class anas {

    // Create signature (sorted letters)
    public static String signature(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Run system command
    public static int runSystemCommand(String command) {
        System.out.println("---------------------------------------------------> " + command);
        try {
            Process process = Runtime.getRuntime().exec(command);
            return process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static <e> void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Anas inputfile.\n You gave:\n " + Arrays.toString(args));
            System.exit(1);
        }

        String inputfile = "C:\\Users\\nqobi\\Downloads\\joyce1922_ulysses.text";
        System.out.println("Data file: " + inputfile);

        Map<String, Integer> D = new HashMap<>();
        int linenumber = 0;
        int lines = 0;

        
        try (BufferedReader file = new BufferedReader(new FileReader(inputfile))
                 {
            String text;
            while ((text = file.readLine()) != null) {
                linenumber++;
                String[] words = text.split("\\s+");
                for (String w : words) {
                    // Strip digits and punctuation
                    String W = w.replaceAll("[0-9\\(\\)\\.,;:_.!?\\-\\[\\]]", "");
                    if (!W.isEmpty()) {
                        D.put(W, D.getOrDefault(W, 0) + 1);
                    }
                }
                lines++;
            }

        } ;catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        
        Map<String, List<String>> A = new HashMap<>();
        for (String w : D.keySet()) {
            String a = signature(w);
            A.computeIfAbsent(a, k -> new ArrayList<>()).add(w);
        }

        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("anagrams"))) {
            for (String key : A.keySet()) {
                List<String> words = A.get(key);
                if (words.size() > 1) {
                    String anagramlist = String.join(" ", words);
                    bw.write(anagramlist + "\\\\");
                    bw.newLine();
                    for (int repeat = 0; repeat < words.size() - 1; repeat++) {
                        int space = anagramlist.indexOf(' ');
                        anagramlist = anagramlist.substring(space + 1) + " " + anagramlist.substring(0, space);
                        bw.write(anagramlist + "\\\\");
                        bw.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        runSystemCommand("sort anagrams > anagrams.sorted");

        List<String> aa = Collections.emptyList();
        try {
            aa = Files.readAllLines(Paths.get("anagrams.sorted"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        try (BufferedWriter tex = new BufferedWriter(new FileWriter("latex/theAnagrams.tex"))) {
            char letter = 'X';
            for (String lemma : aa) {
                char initial = lemma.charAt(0);
                if (Character.toLowerCase(initial) != Character.toLowerCase(letter)) {
                    letter = initial;
                    tex.write("\n\\vspace{14pt}\n\\noindent\\textbf{\\Large "
                            + Character.toUpperCase(initial) + "}\\\\*[+12pt]\n");
                }
                tex.write(lemma);
                tex.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        runSystemCommand("rm anagrams anagrams.sorted");
    }
                 }
