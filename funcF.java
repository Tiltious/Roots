public class funcF implements  Function
{
      public double eval(double x)
       {
           double k=5*x*Math.sin(x);
           double l=x*Math.cos(x);
           return k-l-Math.E;
          }
}