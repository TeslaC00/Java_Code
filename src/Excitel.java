import java.io.*;
import java.util.*;
import java.text.*;
class Excitel{
    public static void main(String []args) throws IOException{
     
        if(args.length == 0){
            System.out.println("ERROR!! PLease Give The Path To a File");
        }  else {
            
            BufferedReader reader = null;
            try{
             reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            } catch(FileNotFoundException e){
             System.out.println("Some Error Has Ocurred!!!");   
            }
            
            String readLine = reader.readLine();
            StringTokenizer st;
            double time = 0.0;
            double mb = 0.0;
            while(readLine!=null){
                
                st = new StringTokenizer(readLine);
                
                    st.nextToken();
                    st.nextToken();
                    st.nextToken();
                    st.nextToken();
                    st.nextToken();
                    time = time + Double.parseDouble(st.nextToken());
                    mb = mb + Double.parseDouble(st.nextToken());
                readLine = reader.readLine();
            }
            
            DecimalFormat df = new DecimalFormat("#.##");
            time = Double.parseDouble(df.format(time/60));
            mb = Double.parseDouble(df.format(mb/1024));
           
            System.out.println("Time => " + time + " hours");
            System.out.println("Usage => " + mb + " GB(s)");
            
            
            if(reader!=null){
                reader.close();
            }
            
        }
        
    }

} 