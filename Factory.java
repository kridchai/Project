
public class Factory extends Thread implements Comparable<Factory>{
    private  int ID, lotsize,size = 0,lotDone;
    public int thread;
    private String product;
    private  int[] required,remain;
    private OneShareMaterial[] material;

    public Factory(String id,String product,String lot){
      super(product);
      this.product = product;
      ID = Integer.parseInt(id);
      lotsize=Integer.parseInt(lot);
     
   }

   public Factory(int id,String product,int lot,int size,int done,int[] required,int[] remain,OneShareMaterial[] material){
      super(product);
      this.product = product;
      this.ID = id;
      this.lotsize=lot;
      this.size = size;
      this.lotDone = done;
      this.required = new int[size];
      this.remain = new int[size];
      this.material = new OneShareMaterial[size];
      for(int i = 0;i<size;i++){
        this.required[i] = required[i];
        this.remain[i] = remain[i];
        this.material[i] = material[i];

      }
      /* for(int i = 0;i<size;i++){
         System.out.println( "this require" + this.required[i]);
          System.out.println( "require" + required[i]);
          System.out.println( "this remain "+ this.remain[i]);
          System.out.println( "remain "+ remain[i]);
          // System.out.println( this.material[i] +material[i]);
       
      //  this.remain[i] = remain[i];
       // this.material[i] = material[i];

     }
       */
      

     
   }

   
    public void setRequire(String[][] re,int row,int colum){
      int n=  0;
      required = new int[colum-3];
      material = new OneShareMaterial[colum-3];
      remain = new int[colum-3];
          for(int j=3;j<colum;j++){
              required[n] = lotsize*Integer.parseInt(re[row][j]);//buff มันเป็น stringอะ รับมาแล้วค่อย parseintได้มะ
              n +=1;//ได้ๆ
          }
        
      
   }
    public void setMaterial(OneShareMaterial m){
      material[size] = m;
      size+=1;
   }


    public void printIntro(){
      System.out.printf("Thread %s >> %s factory   %d units per lot   materials per lot =",Thread.currentThread().getName(),product,lotsize);
      for(int i = 0;i<size-1;i++){
        System.out.printf("%3d %s, \n",required[i],material[i].getName());

      }
      System.out.printf("%3d %s\n",required[size-1],material[size-1].getName());

    }
    

    public void setBalance(int n){
      for(int i =0;i<size;i++){
         material[i].put(n);
         System.out.println(""+size);
      }
       

    }
    public void printSummary(){
      System.out.printf("Thread %s  >>Total %s  Lots = %d\n",Thread.currentThread().getName(),product,lotDone);


    }
   public void run(){
     int temp;
     if(isAllZero(remain)){
      for(int i = 0;i<required.length;i++)
          remain[i] = required[i];

       for(int i =0;i<size;i++){
          temp = material[i].get(required[i]);
          remain[i] = remain[i]-temp;
        }
        if(isAllZero(remain)){
          lotDone +=1;
          System.out.printf("Thread %s >> complete Lot %d\n",Thread.currentThread().getName(),lotDone);

        }
        else
           System.out.printf("Thread %s------Fail\n",Thread.currentThread().getName());
     }
     else{
       for(int i =0;i<size;i++){
          temp = material[i].get(remain[i]);
          remain[i] -= temp;
        }
        if(isAllZero(remain)){
          lotDone +=1;
          System.out.printf("Thread %s >> complete Lot %d\n",Thread.currentThread().getName(),lotDone);

        }
        else
           System.out.printf("Thread %s------Fail\n",Thread.currentThread().getName());


     }
     
   }
   

   public boolean isAllZero(int r[]){
     int check = 1; 
     for(int i = 0;i<r.length;i++){
       if(r[i]!=0)
        check = 0;

     }
     if(check==0)
        return false;
     else
        return true;

   }


   public int getID(){
     return ID;
   }
   public String getProduct(){
     return product;
   }

  public int getLot(){
    return lotsize;
  } 
  public int getDone(){
    return lotDone;
  }

  public int getSize(){
    return size;

  }
  
  public int[] getRequire(){
    return required;
  }
  public int[] getRemain(){
   
    return remain;
  }

  public OneShareMaterial[] getMaterials(){
    return material;
  }
    
  //ขาดทำgetที่เหลือกับ setตัวอื่นที่ไม่อยู่ในconstructor
            
 public int compareTo(Factory other) { 
        if (this.lotDone > other.lotDone)
            return 1;
        else if(this.lotDone < other.lotDone)
            return -1;
        else 
            return 0;
        
  }
 
  }  