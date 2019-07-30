package StaticTest;

/**
 * This program demonstrates static methods.
 * @version 1.0
 */
public class StaticTest {
  //fill the staff with three Employee objects
  public static void main (String[] args){
    Employee[] staff = new Employee[3];

    staff[0]=new Employee("zhang",4000);
    staff[1]=new Employee("li",40005);
    staff[2]=new Employee("liu",5999);

    for(Employee e:staff){
      e.setId();
      System.out.println("name= "+e.getName()
          + ",id= "+e.getId()+",salary= "+e.getSalary());
    }
    int n=Employee.getNextId();
    System.out.println("Next available id = "+n);
  }

}
