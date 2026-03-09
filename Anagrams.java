import java.io.*;
import java.util.*;





public Anagrams{
  static void signature(word){
    return ''.join(sorted(word));
  }
  static void System(command){
    System.out.println("-"*50 + ">", command);
      String s = system(command);
    return s;
  }
  public static void main(String[] args){

    try(BufferedReader file = new BufferedReader(new FIleReader(){
      String text = file.readLine();
      int lines = 0;
      int linenumber= 0;
      while( text != ""){
        linenumber += 1;
       String[] words = text.split();
        for(String w : words){
          w = w.strip([0123456789(,.,.;:_.!?---)]');
          w = w[:];
          if( w : D){
            D[W] += 1;
          }
          else{
            D[W] = 1;
          }
        }
        text = file.readLine();
        lines = += 1;
      
      }
        file.close();
        String[] A = { }
        for(w : D){
          String a = signature(w);
          if( a != A){
            A[a] = [w];
          }
            else{
              A[a].append(w);
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
         System.out.printl
       }
     }
   }
  }
}
