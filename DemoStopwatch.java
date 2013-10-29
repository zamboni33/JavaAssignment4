package Assignment4;

public class DemoStopwatch 
{  /* here is a test driver program for the Stopwatch so that you can see
       how it is supposed to work  */
public static void main(String[] args)
{
   final double NANOS_PER_SEC = 1000000000.0;
	
  Stopwatch s = new Stopwatch();
  int i;
  long mytime;
  s.start( );
  int a[ ]=new int [1000];
  for (i=0; i < 1000; i++)
    a[i] = i;
  s.stop();
  mytime=s.getElapsedTime();
  System.out.println("Time elapsed in nanoseconds is: "+ mytime);
  System.out.println("Time elapsed in seconds is: "+ mytime/ NANOS_PER_SEC);

}
}
