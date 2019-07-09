package study;
import java.time.*;

class Employss_4_3 {
    private static int nextId=1;

    private String name;
    private double salary;
    private int id;

    public Employss_4_3(String n,double s)
    {
        name =n;
        salary=s;
        id=0;

    }
    public String getName()
    {
        return name;
    }
    public double getSalary()
    {
        return salary;
    }
    public int getId()
    {
        return  id;
    }
    public void setId()
    {
        id=nextId;
        nextId++;
    }
    public static int getNextId()
    {
        return nextId;
    }

    public static void  main(String[] args)
    {
        Employss_4_3 e=new Employss_4_3 ( "Harry",50000 );
        System.out.println ( e.getName ()+" "+e.getSalary () );
    }
}

