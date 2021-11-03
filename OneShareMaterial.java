public class OneShareMaterial {
  //set variables ------------------------
  private String name;
  private int balance;

  //add methods ------------------------
  //this methods set name Meterial 
  public OneShareMaterial(String buff){
    name = buff;
  }

  //this methods get 
  public  synchronized int get(int n){
    int temp = 0;
    if (balance >= n){
      balance -= n;
      temp = n;
    }
    else if (balance < n){
      temp = balance;
      balance = 0;
    }
     System.out.printf("Thread %s >> Get %3d %s    balance = %3d %s\n",Thread.currentThread().getName(),temp,name,balance,name);
     return temp;  
    
  }

  public void put(int n){
    balance += n;
     System.out.printf("Thread %s >> Put %3d %s    balance = %3d %s\n",Thread.currentThread().getName(),n,name,balance,name);
  }

  public void setBlance(int n){
    balance = n;
  }

  public String getName(){
    return name;
  }


}
