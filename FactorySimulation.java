import java.io.*;
import java.util.*;
public class FactorySimulation {
    public static void main(String[] args){
       
        int check = 0,n=0,nMat,day;
        Scanner Input = null,sc;
        String buff[][] = null;
        String FileName = null ;
        System.out.printf("%s Enter product specification file = ",Thread.currentThread().getName());
        sc = new Scanner(System.in);
        nMat = sc.nextInt();
        
        while(check==0){
            try{
                Input = new Scanner(new File(FileName));
                check = 1;
            }
            catch(Exception e){
                System.out.println("File not found.");
                 System.out.printf("%s Enter product specification file = ",Thread.currentThread().getName());
                Scanner s = new Scanner(System.in);
                FileName = s.next();  
            }
        }
        while(Input.hasNext()){
            String line = Input.nextLine();
            buff[n] = line.split(",");
            n+=1;

        }
        
        Input.close();
        // finish read file
        
         ArrayList<Factory> FactoryAl = new ArrayList<Factory>(2);
        
        for(int i = 0;i<FactoryAl.size();i++){
           Factory f = new Factory(buff[i+1][0],buff[i+1][1],buff[i+1][2]);
           // basis constructor class Factory e.g Factory(1,"Handbag",10)
          /*if(j=0;j<n;j++){
          f.addrequired(buff[i+1][3+j],j);

          }*/
           FactoryAl.add(f);
        }
        int row= buff.length;
        int colum= buff[1].length;
        for(int i = 0;i<FactoryAl.size();i++)
          FactoryAl.get(i).setRequire(buff,row,colum); /// Additional method in factory class
  

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
        
        System.out.printf("%s >>Enter amount of material per day = ",Thread.currentThread().getName());
        nMat = sc.nextInt();
      
        
        System.out.printf("%s >>Enter number of days = ",Thread.currentThread().getName());
        day = sc.nextInt();
        
        for(int i = 0;i<day;i++){
            System.out.printf("%s >>day %d\n",Thread.currentThread().getName(),i+1);
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
        FactoryAl.sort();//Implement comparable 
        for(int i = 0;i<FactoryAl.size();i++)
            FactoryAl.get(i).printSummary();///// Additional method in factory class
        
    
    }
}
