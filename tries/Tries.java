package tries;


public class Tries {

    Tries[] childrean;
    boolean isWord;
    int wordCount;

    public Tries(){
        this.wordCount = 0;
        this.childrean = new Tries[26];
        this.isWord = false;

    }

    public void add(String pattern){
        if(pattern.isEmpty()){
            isWord = true;
            return;
        }

        int index = pattern.charAt(0) - 'a';
        if(childrean[index] == null){
            childrean[index] = new Tries();
        }
        childrean[index].add(pattern.substring(1));
    }

    public boolean isWord(String word){
        if(word.isEmpty()){
            return this.isWord;
        }

        int index = word.charAt(0) - 'a';
        if(childrean[index] == null){
            return false;
        }
        return childrean[index].isWord(word.substring(1));
    }

    public static void main(String[]args){
        Tries tries =  new Tries();
        tries.add("shivam");
        tries.add("animal");
        if(tries.isWord("animal")){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
