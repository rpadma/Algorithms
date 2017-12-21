/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Rohit
 */
public class insertionsort {
    
    public static void main(String args[])
    {
        
        int input[]=getinputarray(args[0]);
        
        
        for(int i=0;i<input.length-1;i++)
        
        {
            int k=i+1;
            int temp=input[k];
            
            while(k>0&& input[k-1]>temp)
            {
                
                input[k]=input[k-1];
                k=k-1;
            }
            
            input[k]=temp;
            
           
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
