package workspace;

public class MessageUtil {
  private String message;

  /**
   * 构造方法
   * @param message message to be printed
   */
  public MessageUtil(String message){
    this.message=message;
  }

  public String printMessage(){
    System.out.println(message);
    return message;
  }

}
