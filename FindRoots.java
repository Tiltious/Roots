import java.io.*;
import java.util.*;
// Methodos ths dixotomisis, gnwsti kai ws methodos Bolzano.
//  H methodos auti vasizetai stin idea tou diadoxikou
// egkleismou tis rizas, pou psaxnoume se mikrotera upodiastimata 
// tou diastimatos [a,b] mesa sto opoio entopisame tin riza 
public class FindRoots
{  
  // Estw f i sunartisi tis opoias anazitoume tis rizes kai p ena poluwnumo
  // tetoio, wste gia tis sigkekrimenes x, gia tis opoies gnwrizoume tis times 
  // tis f, na isxuei f(x)=p(x). Gia n apofugoume tin argoporia tou algorithou
  // tis dixotomis anaptusoume ton algorithmo esfalmenis thesis (regula falsi).  
  public static void main(String args[])throws IOException 
   {  
    // Dilwsi twn pinakwn pou periexoun diastimata kai rizes 
    // gia tis sunartiseis f,g,h,s
    double [][] matrixf = new double[8][3];
    double [][] matrixg = new double[8][3];
    double [][] matrixh = new double[8][3];
    double [][] matrixs = new double[8][3];
    Bisection bismethod = new Bisection();
    RegulaFalsi regmethod = new RegulaFalsi();
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
            matrixf[m][2]= bismethod.bisection(new funcF(),matrixf[m][0],matrixf[m][1],100,0.000000000000001);
            matrixg[m][2]= bismethod.bisection(new funcG(),matrixg[m][0],matrixg[m][1],100,0.000000000000001);
            matrixh[m][2]= bismethod.bisection(new funcH(),matrixh[m][0],matrixh[m][1],100,0.000000000000001);
            matrixs[m][2]= bismethod.bisection(new funcS(),matrixs[m][0],matrixs[m][1],100,0.000000000000001);
          }
          else{
            matrixf[m][2]= regmethod.regulafalsi(new funcF(),matrixf[m][0],matrixf[m][1],100,0.000000000000001);
            matrixg[m][2]= regmethod.regulafalsi(new funcG(),matrixg[m][0],matrixg[m][1],100,0.000000000000001);
            matrixh[m][2]= regmethod.regulafalsi(new funcH(),matrixh[m][0],matrixh[m][1],100,0.000000000000001);
            matrixs[m][2]= regmethod.regulafalsi(new funcS(),matrixs[m][0],matrixs[m][1],100,0.000000000000001);
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

