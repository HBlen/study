package workspace;

import junit.framework.AssertionFailedError;
import junit.framework.TestResult;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import static junit.framework.TestCase.assertTrue;

public class TestJunitResult extends TestResult {
  // add the error
  public synchronized void addError(Test test,Throwable t){
    super.addError((junit.framework.Test) test,t);
  }

  // add the failure
  public synchronized void addFailure(Test test, AssertionFailedError t){
    super.addFailure((junit.framework.Test) test, t);
  }

  @Test
  public void testAdd(){
    int k=1;
    assertTrue(k!=1);
  }

  //表明测试必须停止
  public synchronized void stop(){
  }
}
