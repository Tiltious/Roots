
public class Bisection {
	public double bisection
	  (
	    Function f, 
	    double a, 
	    double b, 
	    int maxIteration, 
	    double tolerance
	  ) 
	  {
	    double dx = b - a;
	    int i = 0;
	    double x = 0;
	    // Prwtarxikos elegxos uparksis tis rizas
	    if (f.eval(a) * f.eval(b) > 0){
	        return -100;}                   
	    else{
	        while (i <  maxIteration)
	        {  
	            // Xwrizoume to [a,b] se [a,x]&[x,b], opou x to meso tou [a,b]
	            if (Math.abs(dx) < tolerance){
	                   return x;}
	            x = (a + b) / 2;
	            // Elegxoume se poio apo ta duo vrisketai i riza.
	            // Thetoume to meso ws deksio akro tou diastimatos, 
	            // an vrisketai deksia,h ws aristero.
	              if(f.eval(a) * f.eval(x) <= 0){
	                 b = x;
	                 dx = b - a;
	                }else{
	                a = x;
	                dx = b - a;
	            }   
	            // Epanalamavanoume tin diadikasia mexris otou 
	            // i apostasi twn akrwn tou diastimatos na einai mikroteri 
	            // apo enan arithmo kata proseggisi (15 pshfiwn) miden.
	            i++;}
	    }
	    return x;
	  }
}
