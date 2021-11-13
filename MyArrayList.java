import java.util.*;

public class MyArrayList extends ArrayList<Factory> {
/*  private int ID, lotsize, size = 0, lotDone;
  public int thread;
  private String product;
  private int[] required, remain;
  private OneShareMaterial[] material;

  public MyArrayList(){
    for(int i = 0;i<3;i++){                   
ID = this.get(i).getID();
product = this.get(i).getProduct();
lotsize = this.get(i).getLot();
lotDone = this.get(i).getDone();
}
  }
*/
public void reSet(){
/* copy ข้อมูลลงอาเรของfactoryให้ครบทุกตัว
    แล้วเรียก this.clear()
    แล้วค่อยแอด อาเรของfactoryลง ex this.add(f[i])
  
  */  
                   
   //              a =  [1,2,3] --->a[0]
     //                             this.get(0) 

  //remain ==0                //  Factory[] day 2 = new Factory[this.size]; 
  //remain = require           // day2 = a =  [1,2,3]
                            //  this.clear
                            //  for 
                                    //this.add(day2[i]);





//require=this.get(0).getRequire();
/*for(int i = 0;i<required.length;i++){
   require[i]=this.get(0).getRequire(i);
}
*/
/*Factory[] day2 = new Factory[this.size];
for(int j = 0;j<3;j++){
day2 = (ID,product,lotsize);

}

  this.clear();

for(int i = 0;i<required.length;i++)
    remain[i] = required[i];


this.clear();
for(int k=0;k<day2.length;k++){
  this.add(day2[k]);
}
//return day2[];
*/
  Factory []Next = new Factory[this.size()];
  int n = this.size();
  for(int i = 0;i<this.size();i++){
    Next[i] = new Factory(this.get(i).getID(), this.get(i).getProduct(), this.get(i).getLot(), this.get(i).getSize(), this.get(i).getDone(), this.get(i).getRequire(), this.get(i).getRemain(), this.get(i).getMaterials());

  }
  this.clear();
  for(int i =0;i<n;i++){
    this.add(Next[i]);

  }



}

}