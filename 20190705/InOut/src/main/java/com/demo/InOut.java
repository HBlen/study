package com.demo;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;  // 当使用的类不是定义在基本 java.lang 包中时， 一定要使用 import 指示字将相应的包加载进来。

public class InOut {
    public static void main(String[] args)throws IOException
    {
        /*
    //1. 读取输入
    //构造Scanner对象，并与"标准输入流"System.in关联
    Scanner in=new Scanner(System.in);
        System.out.print("What's is your name?");
    String name=in.nextLine();  //nextLine 方法将输入一行。
    String firstName=in.next(); // 读取一个单词(以空白 符作为分隔符

        System.out.print("How old are you?");
    int age=in.nextInt ();  //读取整数，nextDouble 读取浮点数
*/
        /*
        //2. 读取密码
        Console cons=System.console();
        String username=cons.readLine ("User name: ");
        char[] passwd=cons.readPassword("Password: ");
*/
        /*
        // 3. 格式化输出
        int x=10000;
        System.out.printf("%d",x);
        System.out.println("");
        System.out.printf("%d%<x",x);

        String name="han";
        int age=28;
        String message =String.format("Hello,%s. Next year,you'll be %d",name,age);

        System.out.printf("%1$s %2$tb %2$te,%2$tY","Due date:",new Date ());
        System.out.printf("%s %tB %<te, %<tY","Due date:",new Date());
        */
/*
        //4. 文件输入与输出
        String dir = System.getProperty("user.dir");  //工程路径
        Scanner in=new Scanner(Paths.get("myfile.txt"),"UTF-8");
        PrintWriter out =new PrintWriter("myfile.txt","UTF-8");
*/
    }
}
