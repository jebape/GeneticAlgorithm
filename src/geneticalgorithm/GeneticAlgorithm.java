
package geneticalgorithm;

/*
 * Jesús Ballesteros
 * CS 472 - Artificial Intelligence
 * Assignment 2 - GeneticAlgorithm Class
 * September 25, 2017
 */

public class GeneticAlgorithm 
{

    public static final int MAX_ITERATIONS = 1000;
       
    public static void main(String[] args) 
    {
        Individual x, y;                                // Parent Individuals
        Population original = new Population();         
        original.fillRandomly();                        // Fill population with random Individual content
        
        for(int j=0; j<MAX_ITERATIONS;j++){             // Iterate during MAX_ITERATIONS (1000) times
            Population children = new Population();
            for(int i=0; i<original.getSize()/2; i++){
                // Selecting individuals randomly
                printFirstTime("Selecting individuals for natural selection:",i,j);
                x=original.selection();
                printFirstTime(x,i,j);
                y=original.selection();
                printFirstTime(y,i,j);
                
                // Crossover
                printFirstTime("Performing crossover:",i,j);
                int rand = randomNumGeneration(9);
                Individual child1 = crossover(rand, x, y);
                Individual child2 = crossover(rand, y, x);
                printFirstTime(child1,i,j);
                printFirstTime(child2,i,j);

                // Small Probabilty for mutation (Currently, 100% of probability so mutation is shown for sure in first iteration)
                int prob = 100;                                         
                if(randomNumGeneration(100)<prob){
                    // Mutation
                    printFirstTime("Performing mutation:",i,j);
                    child1.mutate();
                    child2.mutate();
                    printFirstTime(child1,i,j);
                    printFirstTime(child2,i,j);
                }
                // Insert childs to new population
                children.insertInd(child1);
                children.insertInd(child2);
            }
            original = children;                    // Set up new population to be used in next iteration
            Individual best=original.findBest();    // Get best individual by fitness function (highest fit value)
            System.out.println("Gen"+(j+1)+" Best Fitness = "+best.getFit()+" Best individual: "+best);     // Print out results
        }
       
    }
    // printFirstTime method prints out content just during first iteration
    public static void printFirstTime(Object a, int x, int y){
        if(x==0 && y==0)
            System.out.println(a);        
    }

    // crossover of two individuals and returns a child
    public static Individual crossover(int rand, Individual a, Individual b){
        return new Individual(a.getContent().substring(0, rand) + b.getContent().substring(rand, b.getLength()));
    }
    
    // randomNumGeneration generates a random number in between 0 and n
    public static int randomNumGeneration(int n){
        return (int)(Math.random() * n);
    }
    
    
    
}
