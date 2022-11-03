import java.io.*;
import java.util.*;
// Methodos ths dixotomisis, gnwsti kai ws methodos Bolzano.
//  H methodos auti vasizetai stin idea tou diadoxikou
// egkleismou tis rizas, pou psaxnoume se mikrotera upodiastimata 
// tou diastimatos [a,b] mesa sto opoio entopisame tin riza 
public class FindRoots
{
  public static double bisect
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
  // Estw f i sunartisi tis opoias anazitoume tis rizes kai p ena poluwnumo
  // tetoio, wste gia tis sigkekrimenes x, gia tis opoies gnwrizoume tis times 
  // tis f, na isxuei f(x)=p(x). Gia n apofugoume tin argoporia tou algorithou
  // tis dixotomis anaptusoume ton algorithmo esfalmenis thesis (regula falsi).
  public static double regulafalsi
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
  
  public static void main(String args[])throws IOException 
   {  
    // Dilwsi twn pinakwn pou periexoun diastimata kai rizes 
    // gia tis sunartiseis f,g,h,s
    double [][] matrixf = new double[8][3];
    double [][] matrixg = new double[8][3];
    double [][] matrixh = new double[8][3];
    double [][] matrixs = new double[8][3];
    // Auti i anakluklwsi, duo epanalipsewn,tha upologisei tis 
    // rizes gia kathe sunartisi, tha tis eisagei stis antistoixes
    // theseis twn antistoixwn pinakwn kai epita th emfanisei tous pinakes.
    for (int i=0; i<2; i++){
      if (i==0){
          System.out.println("EYRESI RIZWN ME THN METHODO BISECTION");
          System.out.println();
      }
      else{
          System.out.println("EYRESI RIZWN ME THN METHODO REGULA FALSI");
          System.out.println();
      }
      for (int m = 0; m < 8; m++){
          for (int n = 0; n < 2; n++){
                // Eisagoume stis duo prwtes sthles tou kathe pinaka  ta akra twn diastimatwn 
                matrixf[m][n] = m+n-4;
                matrixg[m][n] = m+n-4;
                matrixh[m][n] = m+n-4;
                matrixs[m][n] = m+n-4;
          }
          // Autos o elegxos apofasizei poia methodo euresis rizwn tha xrhsimopoihsoume
          // (bisecton i regular fasli) kai eisaigei to apotelesma tis stn trith sthlh kathe pinaka.
          if( i==0){
            matrixf[m][2]= bisect(new funcF(),matrixf[m][0],matrixf[m][1],100,0.000000000000001);
            matrixg[m][2]= bisect(new funcG(),matrixg[m][0],matrixg[m][1],100,0.000000000000001);
            matrixh[m][2]= bisect(new funcH(),matrixh[m][0],matrixh[m][1],100,0.000000000000001);
            matrixs[m][2]= bisect(new funcS(),matrixs[m][0],matrixs[m][1],100,0.000000000000001);
          }
          else{
            matrixf[m][2]= regulafalsi(new funcF(),matrixf[m][0],matrixf[m][1],100,0.000000000000001);
            matrixg[m][2]= regulafalsi(new funcG(),matrixg[m][0],matrixg[m][1],100,0.000000000000001);
            matrixh[m][2]= regulafalsi(new funcH(),matrixh[m][0],matrixh[m][1],100,0.000000000000001);
            matrixs[m][2]= regulafalsi(new funcS(),matrixs[m][0],matrixs[m][1],100,0.000000000000001);
          } 
      }
      // S auto to simeio exoun upologistei oi pinakes twn sunatisewn,
      // gia tn antistoixh methodo, opote emfanisoume tou pinakes.
      // Kapoies apo tis entoles eksodou aforoun stin morrfopoihsh
      // tis othonis pou th emfanisei to programma.
      System.out.println("Oi rizes tis eksiswsis f(x)=0 sta diastimata [a,b] einai:");
      System.out.println("  a"+"       b"+"       x");
      for ( int m = 0; m < 8; m++) {
           for (int n = 0; n < 3; n++){
                 if (matrixf[m][n]<0){
                     System.out.print(matrixf[m][n]+"    ");
                      if (matrixf[m][n]==-100.0){
                          System.out.print("========> den uparxei riza sto diastima");
                        }
                        }else{System.out.print(" "+matrixf[m][n]+"    ");}                        
               }System.out.println();
          }
      System.out.println();System.out.println();
      System.out.println("Oi rizes tis eksiswsis g(x)=0 sta diastimata [a,b] einai:");
      System.out.println("  a"+"       b"+"       x");
      for ( int m = 0; m < 8; m++) {
           for (int n = 0; n < 3; n++){
                if(matrixg[m][n]<0){
                   System.out.print(matrixg[m][n]+"    ");
                   if (matrixg[m][n]==-100.0){System.out.print("=========>den uparxei riza sto diastima");}
                        }else{System.out.print(" "+matrixg[m][n]+"    ");}
                    }
           System.out.println();
          }
      System.out.println();System.out.println();
      System.out.println("Oi rizes tis eksiswsis h(x)=0 sta diastimata [a,b] einai:");
      System.out.println("  a"+"       b"+"       x");
      for ( int m = 0; m < 8; m++) {
           for (int n = 0; n < 3; n++){
                if(matrixh[m][n]<0){
                    System.out.print(matrixh[m][n]+"    ");
                    if (matrixh[m][n]==-100.0){System.out.print("=========>den uparxei riza sto diastima");}
                        }else{System.out.print(" "+matrixh[m][n]+"    ");}
                    }
           System.out.println();
          }
      System.out.println();System.out.println();
      System.out.println("Oi rizes tis eksiswsis s(x)=0 sta diastimata [a,b] einai:");
      System.out.println("  a"+"       b"+"       x");
      for ( int m = 0; m < 8; m++) {
           for (int n = 0; n < 3; n++){
                if(matrixs[m][n]<0){
                   System.out.print(matrixs[m][n]+"    ");
                   if (matrixs[m][n]==-100.0){ System.out.print("=========>den uparxei riza sto diastima");}                           
                        }else{System.out.print(" "+matrixs[m][n]+"    ");}                        
                    }
           System.out.println();
      }
      System.out.println();
    }
  }
}

