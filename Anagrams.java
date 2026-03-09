public Anagrams{
  public static void main(String[] args){

    try(BufferedReader file = new BufferedReader(new FIleReader(){
      String text = f.readLine();
      int lines = 0;
      int linenumber= 0;
      while( text != ""){
        linenumber += 1;
        words = text.split();
        for(String w : words){
          String W = w.strip([0123456789(,.,.;:_.!?---)]');
          w = W[:];
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
    }
    catch(IOException e){
      
    }
  }
}
