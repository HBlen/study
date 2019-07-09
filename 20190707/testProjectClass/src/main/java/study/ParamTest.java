package study;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.time.LocalDate;

public class ParamTest {
/*
    public static void main(String[] args)
    {
        //test1: 方法不改变基本类型参数
        System.out.println ( "Testing tripleValue:" );
        double percent=10;
        System.out.println ( "Before: percent="+percent );
        tripleValue ( percent );
        System.out.println ( "After :percent="+percent );

        //test2: 可以改变对象参数的状态
        System.out.println ( "\nTesting tripleSalary:" );
        EmployeeParam harry=new EmployeeParam ( "Harry",50000 );
        System.out.println ( "Before: salary="+harry.getSalary () );
        tripleSalary ( harry );
        System.out.println ( "After: salary="+harry.getSalary () );

        //test3: 方法不能让对象参数引用一个新建对象
        System.out.println ( "\n Testing swap:" );
        EmployeeParam a=new EmployeeParam ( "Alice",70000 );
        EmployeeParam b=new EmployeeParam ( "Bob",60000 );
        System.out.println ( "Before: a="+a.getName () );
        System.out.println ( "before: b="+b.getName () );
        swap ( a,b );
        System.out.println ( "After: a="+a.getName () );
        System.out.println ( "After: b="+b.getName () );





    }

    public static  void tripleValue(double x)
    {
        x=3*x;
        System.out.println ( "End of method: x="+x );
    }

    public  static  void tripleSalary(EmployeeParam x)
    {
        x.raiseSalary ( 200 );
        System.out.println ( "End of method : salary="+x.getSalary () );
    }

    public static void swap(EmployeeParam x,EmployeeParam y)
    {
        EmployeeParam temp=x;
        x=y;
        y=temp;
        System.out.println ( "End of method: x="+x.getName () );
        System.out.println ( "End of method: y="+x.getName () );
    }
    class EmployeeParam
    {
        private String name;
        private double salary;

        public EmployeeParam(String n,double s)
        {
            name =n;
            salary=s;

        }
        public String getName()
        {
            return name;
        }
        public double getSalary()
        {
            return salary;
        }
        public void raiseSalary(double   byPercent)
        {
            double raise =salary*byPercent/100;
            salary+=raise;
        }
    }
*/

}
