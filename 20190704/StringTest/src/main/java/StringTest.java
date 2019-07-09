public class StringTest {
    public static final double CM_PER_INCH=2.54;
    public static void main(String[] args) {
        /*
        //1,变量
        int vacationDays=12;
        System.out.println(vacationDays);

        //2. 常量
        // final double CM_PER_INCH=2.54;
        double paperWidth = 8.5;
        double paperHeight = 11;
        System.out.println("Paper size in centimeters: "+paperWidth*CM_PER_INCH+" by "+paperHeight*CM_PER_INCH);

        //3.数学函数与常量
        double  x=4;
        double y=Math.sqrt(x);
        System.out.println(y);
        //1、字符串截取
        String str = "wo shi zhong guo ren";

        //4. 数值之间的相互转换
        int n=123456789;
        float f=n;
        System.out.println(f);

        //5. 强制类型转换
        double xd=9.997;
        int nx=(int) xd;
        System.out.println(nx);
        int nx1 = (int)Math.round ( xd );
        System.out.println(nx1);

        //6. 字符串
        //子串
        String greeting ="Hello";
        String s=greeting.substring(0,3);

         //拼接
        String expletive="Expletive";
        String PG13="deleted";
        String message=expletive+PG13;

        int age =13;
        String rating ="PG"+age;

        System.out.println("The answer is " + rating);
        System.out.println(s);
        System.out.println(message);

        String all=String.join("/","S","M","L","XL");
        System.out.println ( all );

        //不可变字符串
        greeting=greeting.substring ( 0,3 )+"p!";
        System.out.println ( greeting );

        //检查字符串是否相等
        if ("Hello".equals(greeting))
            System.out.println ( greeting );
        else
            System.out.println ( "No" );
        if("Hello".equalsIgnoreCase ("hello"))
            System.out.println ( "Yes" );

        String greeting="Hello"; //initialize greeting to a string
        if(greeting=="Hello")
            System.out.println ("Yse");
        else
            System.out.println ( "No" );

        if(greeting.substring ( 0,3 )=="Hel")
            System.out.println ("Yse");
        else
            System.out.println ( "No" );


        // 7.  空串，空串是一个Java对象，长度为0，内容为空，null表示目前没有任何对象与该变量关联,null 那个对象没有内存空间，没有地址
        // 空字符串有内存空间 值为空
        String str="";
        //检查是否是空串
        if(((String) str).length ()==0) // or  if(str.equals(""))
            System.out.println ("Yse");
        else
            System.out.println ( "No" );

         //  检查是否为 null
        String strNull=null;
        System.out.println ( str.length () );
        System.out.println ( strNull.length () );
        if(strNull==null)
            System.out.println ("Yse");
        else
            System.out.println ( "No" );

        //8. 码点与字符单元
        //代码单元数量,length返回的是采用 UTF-16 编码表示的给定字符串所需要的代码单元数量。
        String greeting ="Hello";
        int n=greeting.length ();
        //实际长度，即码点数量
        int cpCount=greeting.codePointCount(0,greeting.length());
        // 返回位置n的代码单元，charAt方法返回的是指定位置处的代码单元，而非我们所认为的字符。
        char first=greeting.charAt(0);
        char last=greeting.charAt(3);
        // 得到第i个码点，码点（ code point ) 是指与一个编码表中的某个字符对应的代码值
        int index=greeting.offsetByCodePoints(0,3);
        int cp=greeting.codePointAt(index);


        //===============翻转字符串================
        String greeting ="Hel0";
        //codePoints讲字符串变为int 数组
        int[] strCodePoints=greeting.codePoints().toArray();
        for (int index=strCodePoints.length-1;2*index+1-strCodePoints.length>0;index--) {
            int temp;
            temp = strCodePoints[index];
            strCodePoints[index] = strCodePoints[strCodePoints.length - index-1];
            strCodePoints[strCodePoints.length - index-1]=temp;

        }

        //码点数组转换为字符串
        String str=new String(strCodePoints,0,strCodePoints.length);
        System.out.println ( str);
      //9. String API
     //一个 API 的注释都以形如 java.lang.String 的类名开始。(java.lang 包的重要性将在第 4 章给出解释„) 类名之后是一个或多个方法的名字、解释和参数描述。
*/
        //10 构建字符串
        //构建一个空的字符串构建器
        StringBuilder builder =new StringBuilder();
        //调用append添加内容
        builder.append("end");
        char charAppend='d';
        builder.append(charAppend);
        String complementString=builder.toString ();


    }
}
