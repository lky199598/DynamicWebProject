package InitClass;

import java.util.Arrays;
import java.util.Random;

public class IntegerInit {
public static void main (String[] args)
{
	Integer[] a = new Integer[6];
	Random rand = new Random();
	for(int i=0; i<a.length; i++)
		a[i] = rand.nextInt(10);
	System.out.println(Arrays.toString(a));
}
}
