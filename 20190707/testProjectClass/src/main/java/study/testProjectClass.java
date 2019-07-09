package study;


/**
 * @author Blen
 */

public class testProjectClass {
    public static void main(String[] args)
    {

        /*
        //1. 打印日历
        LocalDate date=LocalDate.now();
        int month = date.getMonthValue ();
        int today = date.getDayOfMonth ();

        date =date.minusDays (today-1);
        DayOfWeek weekday =date.getDayOfWeek ();
        int value=weekday.getValue ();

        System.out.println ( "Mon Tue Wed Thu Fri Sat Sun" );
        for(int i=1;i<value;i++)
            System.out.print(" ");
        while(date.getMonthValue ()==month)
        {
            System.out.printf("%3d",date.getDayOfMonth ());
            if(date.getDayOfMonth ()==today)
                System.out.print("*");
            else
                System.out.print(" ");
            date =date.plusDays ( 1 );
            if(date.getDayOfWeek ().getValue ()==1)
                System.out.println();

        }
            if(date.getDayOfWeek ().getValue ()!=1)
                System.out.println (  );
               */

       Employee[] staff =new Employee[3];

        staff[0]=new Employee ( "Cal",75000,1987,12,15 );
        staff[1]=new Employee ( "Harry",50000,1989,10,1 );
        staff[2]=new Employee ( "Tony",40000,1990,3,15 );
        for(Employee e:staff)
            e.raiseSalary ( 5 );

        for(Employee e:staff)
            System.out.println ( "name= "+e.getName ()+",salary="+e.getSalary ()+",hireDay="+e.getHireday () );
    }
}
