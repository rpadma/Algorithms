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
public class bubblesort {
    
    public static void main(String args[])
    {
        
        int input[]= getinputarray(args[0]);
        for(int i=0;i<input.length-1;i++)
        {
                for(int j=0;j<input.length-1;j++)
                {
                    if(input[j]>input[j+1])
                    {
                        int rm=input[j];
                        input[j]=input[j+1];
                        input[j+1]=rm;
                    }
                }
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
