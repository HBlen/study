import java.util.*;
import java.math.*;
public class testControlProcess {
    public  static void main(String [] args){

      //终端输入
       /*  Scanner in=new Scanner(System.in);

        System.out.print("How much money do you need to retire? ");
        double goal=in.nextDouble();

        System.out.print("How much money will you contribute every year? ");
        double payment=in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate=in.nextDouble();

        double balance =0;
        int years=0;

        // 1. while statement

        while(balance<goal)
        {
            balance+=payment;
            double interest=balance*interestRate/100;
            balance+=interest;
            years++;
        }
        System.out.println ( years );

    // 2. do/while statement
     String input;
     do {
         balance+=payment;
         double interest=balance*interestRate/100;
         balance+=interest;

         years++;

         System.out.printf("After year %d,your balance is %,.2f%n",years,balance);

         System.out.print("Ready to retire? (Y/N) ");
         input=in.next();
     }while(input.equalsIgnoreCase("N"));
     */
       /*

       //3. for statement

        Scanner in =new Scanner (System.in);

        System.out.print("How many number do you need to draw? ");
        int k=in.nextInt();
        System.out.print("What is the highest number you can draw? ");
        int n=in.nextInt ();

        int lotteryOdds=1;
        for(int i=1;i<=k;i++)
            lotteryOdds=lotteryOdds*(n-i+1)/i;
        System.out.println ( "Your odds are 1 in " + lotteryOdds +" . Good Luck!" );
        */

       //4. big data
        /*
        Scanner in=new Scanner(System.in);
        System.out.print("How many numbers do you need to draw? ");
        int k=in.nextInt();

        System.out.print("Whhat is the highest number you can draw? ");
        int n=in.nextInt();

        BigInteger lotteryOdds=BigInteger.valueOf(1);
        for(int i=1;i<=k;i++)
        lotteryOdds=lotteryOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
        */

        /*
        //4. 数组
        //for each循环
        int[] a=new int[100];
        for (int i=0;i<100;i++)
            a[i]=i;
        for (int element : a)
            System.out.println(element);

        System.out.println(Arrays.toString(a));

        //Java允许创建长度为0的数组
        int[] zeroArray=new int[0];

        //数组拷贝
        //两个变量将引用同一个数组
        int[] luckyNumbers=smallPrimes;
        luckyNumbers[5]=12； //now smallPrimer[5] is also 12

        //对象拷贝到新数组
        int[] copiedLuckyNumbers=Arrays.copyOf(luckyNumbers.length);
        */
        /*
        //5. 命令行参数
        if (args.length==0||args[0].equals ( "-h" ))
            System.out.print ( "Hello," );
        else if(args[0].equals ( "-g" ))
            System.out.print ( "GoodBye," );
        for(int i=1;i<args.length;i++)
            System.out.print ( " "+ args[i] );
        System.out.println ( "!" );
        */
        /*
        //6. 数组排序
        Scanner in=new Scanner ( System.in );

        System.out.print ( "How many numbers do you need to draw? " );
        int k=in.nextInt ();

        System.out.print ( "What is the highest number you can draw? " );
        int n=in.nextInt ();

        int[] numbers=new int[n];
        for (int i=0;i<numbers.length;i++)
            numbers[i]=i+1;

        int[] result=new int[k];
        for(int i=0;i<result.length;i++)
        {
            int r=(int) (Math.random ()*n);

            result[i]=numbers[r];

            numbers[r]=numbers[n-1];
            n--;
        }
        Arrays.sort (result);
        System.out.println ( "Bet the following combination.It'll make you rich!" );
        for(int r:result)
            System.out.println ( r );
            */
        //7. 不规则数组
        final int NMAX=10;

        int[][] odds=new int[NMAX+1][];
           for(int n=0;n<=NMAX;n++)
               odds[n]=new int[n+1];
           for(int n=0;n<odds.length;n++)
            for(int k=0;k<odds[n].length;k++)
            {
                int lotteryOdds=1;
                for(int i=1;i<=k;i++)
                    lotteryOdds=lotteryOdds*(n-i+1)/i;
                odds[n][k]=lotteryOdds;

            }

           for(int[] row :odds)
           {
               for (int odd : row)
                   System.out.printf("%4d",odd);
               System.out.println (  );
           }

    }
}
