

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Rohit
 */
public class selectionsort {
    
   public static void main(String args[])
   {
        int input[]= getinputarray(args[0]);
   
        int[] temp=new int[input.length];
        
        for(int i=0;i<input.length;i++)
        {
            int min=input[i];
            int position=i;
            for(int j=i+1;j<input.length;j++)
            {
   
                if(min>input[j]){
                    
                    min=input[j];
                    position=j;
                    
                }                
            }
            
            int t=input[i];
            input[i]=min;
            input[position]=t;
            
           
        }
        
        
        System.out.println(Arrays.toString(input));

   
   
   }
   
   
   
   
     public static int[] getinputarray(String filename)
    {
        
        String inputfilepath=filename;
         ArrayList<String> temp=new ArrayList<String>();
        
    int count=0;
try {
    BufferedReader in = new BufferedReader(new FileReader(inputfilepath));
    String str;
    while ((str = in.readLine()) != null)
    {
        temp.add(str);
        count++;
    }
    in.close();
} catch (IOException e) {
   
}

int input[]=new int[count];

for(int i=0;i<count-1;i++)
{
    input[i]=Integer.parseInt(temp.get(i));
} 


return input;

    }
    
}
