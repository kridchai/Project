import java.io.*;
import java.util.*;
public class FactorySimulation {
    public static void main(String[] args){
       
       int check = 0,n=0,nMat,day;
        Scanner Input = null;
        String[][] buff = new String[10][] ;
        String[][] tan = new String[10][10];
        String FileName = "this" ;
        System.out.printf("Thread %s >> Enter product specification file = ",Thread.currentThread().getName());
        Scanner sc = new Scanner(System.in);
        FileName = sc.next();
          
        while(check==0){
            
            try{
                Input = new Scanner(new File(FileName));
                check = 1;
           
            }
            
            catch(FileNotFoundException e){
      
                System.out.println("File not found.");
                 System.out.printf("Thread %s >> Enter product specification file = ",Thread.currentThread().getName());
                Scanner s = new Scanner(System.in);
                FileName = s.next();  
            }
      
              
        }
        while(Input.hasNext()){
            String line = Input.nextLine();
            buff[n] = new String[line.split(",").length];
            buff[n] =line.split(",");
            for(int i = 0;i<buff[n].length;i++)
              buff[n][i] = buff[n][i].trim();
           // tan[n]=buff[n];
           // System.out.printf("%s",buff[n][0]);
            //System.out.println();
            n+=1;
            }
       
        //Scanner sc = new Scanner(System.in);
       // nMat = sc.nextInt(); 
         
        
       
        // finish read file
       // System.out.printf("%s",buff[n][0]);
        // System.out.println();
         
         ArrayList<Factory> FactoryAl = new ArrayList<Factory>();
        
        
        int count = 1;
        for(int i = 0;i<n-1;i++){
           Factory f = new Factory(buff[count][0],buff[count][1],buff[count][2]);
           FactoryAl.add(f);
           count+=1;
        }
      //  int row= n;
        int colum= buff[1].length;
        for(int i = 0;i<FactoryAl.size();i++)
          FactoryAl.get(i).setRequire(buff,i+1,colum); /// Additional method in factory class
  

        OneShareMaterial[] m = new OneShareMaterial[buff[0].length];
        for(int i = 0;i<buff[0].length;i++){
            m [i] = new OneShareMaterial(buff[0][i]); // basis constructor class material e.g OneShareMaterial("button")
        }
        
        for(int i = 0;i<FactoryAl.size();i++){
            for(int j = 0;j<m.length;j++)
                FactoryAl.get(i).setMaterial(m[j]);   /// Additional method in factory class
        }
        
        for(int i = 0;i<FactoryAl.size();i++)
           FactoryAl.get(i).printIntro();   /// Additional method in factory class need output like line3-5 in pdf file
        
        System.out.printf("Thread %s >>Enter amount of material per day = ",Thread.currentThread().getName());
        nMat = sc.nextInt();
      
        
        System.out.printf("Thread %s >>Enter number of days = ",Thread.currentThread().getName());
        day = sc.nextInt();
        
        for(int i = 0;i<day;i++){
            System.out.printf("Thread %s >>day %d\n",Thread.currentThread().getName(),i+1);
            for(int j = 0;j<FactoryAl.size();i++)
                FactoryAl.get(j).setBalance(nMat);/// Additional method in both factory class and Material class
            System.out.println();
            for(int j = 0;j<FactoryAl.size();i++)
                FactoryAl.get(j).start();
                            
            for(int j = 0;j<FactoryAl.size();j++){
                try{FactoryAl.get(j).join();}
                catch (InterruptedException e) { }
                //FactoryAl.reset() Implement this method later by sub
        
            } 
        }
        
        System.out.printf("%s >>Summary\n",Thread.currentThread().getName());
        //FactoryAl.sort();//Implement comparable 
        for(int i = 0;i<FactoryAl.size();i++)
            FactoryAl.get(i).printSummary();///// Additional method in factory class
        
    
    }
}

