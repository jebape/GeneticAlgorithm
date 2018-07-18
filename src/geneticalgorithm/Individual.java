
package geneticalgorithm;

/*
 * Jesús Ballesteros
 * CS 472 - Artificial Intelligence
 * Assignment 2 - Individual Class
 * September 25, 2017
 */

public class Individual{
    
    public  final int SIZE = 8;
    
    private int[] content = new int[SIZE];
    private int fit;
    
    // Constructor initializes the individual with Random Content
    public Individual(){
        
        for(int i=0; i<this.SIZE; i++){
            int rand = randomNumGeneration(10);
            this.content[i]= rand;
        }
        this.fit=fitness();
        
    }
    
    // Constructor initializes the individual with a Specified Content
    public Individual(String cont){
        int c;
        for(int i=0; i<this.SIZE; i++){
            c=Character.getNumericValue(cont.charAt(i));
            this.content[i]=c;
        }
        this.fit=this.fitness(); 
    }
    
    // Fit Getter
    public int getFit(){
        return this.fit;
    }
    
    // setSingleNum method sets an specified content of the individual
    public void setSingleNum(int n, int index){
        this.content[index] = n;
        this.fit = this.fitness();
    }
    
    // fitness method adds the contents of the individual
    public int fitness(){
        int sum = 0;
        for(int i=0; i<this.SIZE;i++){
            sum += this.content[i];
        }
        return sum;
    }
    
    // getContent method obtains all content as a String without format (e.g. 45987214)
    public String getContent(){
        String s="";
        for(int i=0; i<this.SIZE; i++){
            s=s+this.content[i];
        }      
        return s;
    }
    // mutate method changes randmly one content of the individual
    public void mutate(){
        setSingleNum(randomNumGeneration(10), randomNumGeneration(8));
    }
    
    // getLength method get the current size of the individual
    public int getLength(){
        return this.SIZE;
    }
    
    // toString obtains the individual's content formated (e.g. [ 1 2 5 1 5 4 8 3 ])
    @Override
    public String toString(){
        String s="[ ";
        for(int i=0; i<this.SIZE; i++){
            s+=this.content[i]+" ";
        }        
        s+="]";
        return s;
    }
    
    // randomNumGeneration generates a random number in between 0 and n
    private static int randomNumGeneration(int n){
        return (int)(Math.random() * n);
    }
}
