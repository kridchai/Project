public class OneShareMaterial {
  //set variables ------------------------
  private int id;
  private String name;
  private int balance;

  //add methods ------------------------
  //this methods set name Meterial 
  public OneShareMaterial(String buff){
    name = buff;
  }

  //this methods get 
  public int get(int n){
    int temp = 0;
    if (balance >= n){
      balance -= n;
      temp = n;
    }
    else if (balance < n){
      temp = balance;
      balance = 0;
    }
     return temp;  
    
  }

  public void put(int n){
    balance += n;
  }

  public void setBlance(int n){
    balance = n;
  }

  public String getName(){
    return name;
  }


}
