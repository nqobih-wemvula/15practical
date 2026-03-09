import java.io.*;
import java.util.*;



public anas{
  static String signature( String word){
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return String(chars);
  }
  static int runsystemCommand(String command){
    System.out.println("-"*50 + ">", command);
      try {
            Process process = Runtime.getRuntime().exec(command);
            return process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
}
  public static void main(String[] args){
     if (args.length != 1) {
            System.out.println("Usage: java Anagrams inputfile.\n You gave:\n " + Arrays.toString(args));
            System.exit(1);
        }

        String inputfile = args[0];
        System.out.println("Data file: " + inputfile);

        Map<String, Integer> D = new HashMap<>();
        int linenumber = 0;
        int lines = 0;


    try(BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(inputfile), "latin1"){
         while( String text == file.readLine()!= null){
        linenumber += 1;
       String[] words = text.split("\\s+");
        for(String w : words){
          String W = w.replaceAll([0123456789(,.,.;:_.!?---)]');
          if (!W.isEmpty()) {
                        D.put(W, D.getOrDefault(W, 0) + 1);
                    }
                }
                lines++;
      }
    }
      Map<String, List<String>> A = new HashMap<>();
        for( String w : D.keySet()){
          String a = signature(w);
         A.computeIfAbsent(a, k -> new ArrayList<>().add(w));
          }
          try (BufferedWriter pw = new BufferedWriter(new FileWriter("anagrams"))) {
            for (String key : A.keySet()) {
                List<String> words = A.get(key);
                if (words.size() > 1) {
                    String anagramlist = String.join(" ", words);
                    pw.println(anagramlist + "\\\\");
                    for (int repeat = 0; repeat < words.size() - 1; repeat++) {
                        int space = anagramlist.indexOf(' ');
                        anagramlist = anagramlist.substring(space + 1) + " " + anagramlist.substring(0, space);
                        pw.println(anagramlist + "\\\\");
                    }
                }
            }
        }
runSystemCommand("sort anagrams > anagrams.sorted");
List <Strng> aa = Files.redAllLines(Path.get("anagrams.sorted"));

    try (PrintWriter tex = new PrintWriter(new FileWriter("latex/theAnagrams.tex"))) {
            char letter = 'X';
            for (String lemma : aa) {
                char initial = lemma.charAt(0);
                if (Character.toLowerCase(initial) != Character.toLowerCase(letter)) {
                    letter = initial;
                    tex.printf("%n\\vspace{14pt}%n\\noindent\\textbf{\\Large %s}\\\\*[+12pt]%n", Character.toUpperCase(initial));
                }
                tex.println(lemma);
            }
        }

        runSystemCommand("rm anagrams anagrams.sorted");
    }
}

      
    }
        
    catch(IOException e){
      e.printStackTrace();
    }
   for (String Key : A.keys()){
     List<String> group = entry.getValue();
     if((A[Keys]).length > 1){
       String anagramlist = "";
       for( String word : A[Key]){
         if (anagramlist == ""){
           anagramlist = word;
         }
         else{
           anagramlist += " " + word;
         }
       }
       System.out,println(anagramlist, end = "\\\\\n", File = file);
       for(String r =0 ; r< (A[Key]).length ; r++ ){
         String space = anagramList.find(' ');
         anagramlist = anagramlist[space +1:] + ' ' + anagramlist[: space];
         System.out.println(anagramlist, end = "\\\\\n", File = file);
       }
     }
   }
    file.close();
  }
}
