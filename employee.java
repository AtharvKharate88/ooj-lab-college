public class employee {
    int empid;
    String name;
    int salary;
    public employee(){
        this.empid=1;
        this.name="";
        this.salary=0;
    }
    public employee(int i,String n,int s){
        this.empid=i;
        this.name=n;
        this.salary=s;
    }
    public void dis(){
        System.out.println("employee id:"+empid);
        System.out.println("name of employee:"+name);
        System.out.println("salary of employee:"+salary);
    }
    public static void main(String[] args) {
        employee e1=new employee(1,"atharv",100000);
        e1.dis();
    }
}
