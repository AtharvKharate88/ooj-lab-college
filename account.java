

public class account {
    private int accountNo;
    private int balance;
    public void read(int n,int b){
        accountNo=n;
        balance=b;
    }
    
    public void dis(){
        System.out.println("accountNo:" + accountNo);
        System.out.println("balance:B" + balance);
    }
   public static void main(String[] args) {
       account a1=new account();
       account a2=new account();
       a1.read(1,1000);
       a2.read(2,5000);
       a1.dis();
       a2.dis();
       


   }
}
