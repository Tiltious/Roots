public class funcS implements  Function
               {
                  public double eval(double x)
                   {
                       double sin4x=Math.pow(Math.sin(x),4);
                       double sin3x=Math.pow(Math.sin(x),3);
                       double sinx=Math.sin(x);
                       double cos3x=Math.pow(Math.cos(x),3);
                       double cos2x=Math.pow(Math.cos(x),2);
                       double cosx=Math.cos(x);
                       return 100*sin4x*(50*cos3x-9*cos2x-100*cosx+18)+100*sin3x*(200*cos3x-36*cos2x-400*cosx+72)-sinx*(350*cos3x-63*cos2x-700*cosx-126)-1400*cos3x+252*cos2x+2800*cosx-504;
                      }
               }