
package geneticalgorithm;

/*
 * Jesús Ballesteros
 * CS 472 - Artificial Intelligence
 * Assignment 2 - Individual Class
 * September 25, 2017
 */

public class Population {
    
    public final int MAX_POPULATION = 200;
    
    private int size;
    private Individual[] individuals;
    
    // Constructor initializes an empty population
    public Population(){
        this.individuals  = new Individual[this.MAX_POPULATION];
        this.size = 0;
        
    }
    
    //Getter for size
    public int getSize(){
        return this.size;
    }
    
    // insertInd adds an individual to the population if there is space
    public void insertInd(Individual i){
        if(this.size<this.MAX_POPULATION){
            this.individuals[this.size]=i;
            this.size++;
        }
        else
            System.out.println("Insertion Error");
    }
    
    // fillRandomly fills an entire populaton with random individual content
    public void fillRandomly(){
        for(int i=0;i<this.MAX_POPULATION; i++){
            this.individuals[i] = new Individual();
        }
        this.size=this.MAX_POPULATION;
    }
    
    // findBest resturns best individual of the populaton by the fitness function (highest fit value) 
    public Individual findBest(){
        int max=0;
        int index=0;
        for (int i = 1; i < this.individuals.length; i++)
        {
            if (this.individuals[i].getFit() > max)
            {
                max =  this.individuals[i].getFit();
                index = i;
            }
        }
        return this.individuals[index];
        
    }
    
    // selection finds a random individual in the population
    public Individual selection(){
        return this.individuals[randomNumGeneration(200)];
    }
    // randomNumGeneration generates a random number in between 0 and n 
    private static int randomNumGeneration(int n){
        return (int)(Math.random() * n);
    }
    
}
