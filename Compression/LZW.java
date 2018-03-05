

import javax.management.StringValueExp;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;


public class LZW {

   static HashMap<String,Integer> hmap=new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        // reading input arguments
        String filename=args[0];
        int enclength=Integer.parseInt(args[1]);

        // Reading data from input file
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String temp ="";
        String st;
        while ((st = br.readLine()) != null)
            temp=temp+st;


        // passing file data to encode
        String res=compress(temp,enclength);

        // converting integers to binary format
        String bin=convertStringtoBinary(res,enclength);

        // writing the binary data to lzw file.
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filename+".lzw"), "utf-8"));
            writer.write(bin);
        } catch (IOException ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }



        // converting the binary from lzw to integers.
        String str=convertBinarytoString(bin);

        // decoding the binary to string
        String decodestring=decompress(str);

        // writing the string to output file
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filename+"_decoded.txt"), "utf-8"));
            writer.write(decodestring);
        } catch (IOException ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }


    }

    // method to generate the binary string from file data - encoding
    public static String compress(String uncompressed,int length) {
        int dictSize = (int)Math.pow(2,8)-1;

        for(int i=0;i<256;i++)
        {
            char a=(char)i;
            String temp=String.valueOf(a);
            hmap.put(temp,i);
        }

        HashSet<String> setdata =new HashSet<String>();
        String res=" ";
        String t="";
        String [] strarr=uncompressed.split("");
        for(int i=0;i<strarr.length;i++)
        {

             if(!setdata.contains(t+strarr[i]))
             {
                setdata.add(t+strarr[i]);

                if(hmap.get(t+strarr[i])==null)
                {
                    res=res+" "+(++dictSize);
                    hmap.put(t+strarr[i],dictSize);
                }
                else
                {
                    res=res+" "+hmap.get(t+strarr[i]).toString();
                }

                 t="";
             }
             else
             {

         t+=strarr[i];

             }

        }

        return res;

    }

    // method to decode the binary string to input string
    public static String decompress(String u) {

        HashMap<String,String > fhmap=getdata();



        String[] strarr=u.split(" ");
        String res="";
        for(int i=0;i<strarr.length;i++)
        {
           if(fhmap.containsKey(strarr[i]))
            {
                res+=fhmap.get(strarr[i]);
            }
        }

        return res;
    }

    // converting hashmap key value to value key pair.
    public static HashMap<String,String> getdata()
    {
        HashMap<String,String > finalhmap=new HashMap<String, String>();

        for(String key:hmap.keySet())
        {
            finalhmap.put(String.valueOf(hmap.get(key)),key);
        }

        return finalhmap;
    }


    // method to convert string to 16 bit binary number
    public static String convertStringtoBinary(String str,int length)
    {


        String [] strarr=str.trim().split(" ");
        String result="";
        int[] arr=new int[strarr.length];
        String sixteenZeroes="0000000000000000";

        for(int i=0;i<strarr.length;i++)
        {

           String bin= Integer.toBinaryString(Integer.valueOf(strarr[i].trim()));

         bin= sixteenZeroes.substring(0, length-bin.trim().length()).concat(bin);
          result=result+" "+bin;
        }

        return result;
    }

    // method to convert 16 bit binary to string
    public static String convertBinarytoString(String str)
    {
        String res="";
        String [] strarr=str.trim().split(" ");
        for(int i=0;i<strarr.length;i++)
        {

  res=res+" "+Integer.parseInt(strarr[i],2);
        }

        return res;
    }

}
