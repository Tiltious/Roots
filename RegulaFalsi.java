
public class RegulaFalsi {
	public double regulafalsi
	  (
	    Function f, 
	    double a, 
	    double b, 
	    int maxIteration, 
	    double tolerance
	  ) 
	  {
	    int i = 0;
	    double x = 0;
	    // Prwtarxikos elegxos uparkshs ths rizas
	    if (f.eval(a) * f.eval(b) > 0){
	        return -100;}                   
	    else{
	        while (i <  maxIteration)
	        {  
	            // Xwrizoume to [a,b] se [a,x]&[x,b],opou x tha einai
	            // to shmeio tomhs tou polwnumou paremvolhs,pou pernaei
	            // apo ta simeia (a,f(a)),(b,f(b)), kai tou aksona xx'.
	            if (Math.abs(f.eval(x)) < tolerance){
	                   return x;}
	            x = (a*f.eval(b)-b*f.eval(a))/(f.eval(b)-f.eval(a));
	            // Elegxoume se poio apo ta duo vrisketai h riza.
	            // Thetoume to x deksio akro tou neou diasthmatos, 
	            // an vrisketai deksia,h ws aristero.
	              if(f.eval(a) * f.eval(x) <= 0){
	                 b = x;
	                 }else{
	                 a = x;
	            }   
	            // Epanalamavanoume thn diadikasia mexris otou 
	            // i apostasi twn akrwn tou diasthmatos na einai mikroteri 
	            // apo enan aritmo kata prosegghsh (15 pshfiwn) mhden.
	            i++;}
	    }
	    return x;
	  }
}
