import java.util.Iterator;


public class Subset {
        public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		String[] input = new String[k];
		for(int i=0;i<k;i++){            
            input [i] =StdIn.readString(); 
        }
		StdRandom.shuffle(input);
		for (String s: input) {
				StdOut.println(s);
			}
		}
		
	}

