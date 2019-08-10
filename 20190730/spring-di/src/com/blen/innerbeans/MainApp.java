package com.blen.innerbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

  public static void main(String[] args) {
    //自己新建对象，控制对象生成
//    TextEditor textEditor = new TextEditor();
//    SpellChecker spellChecker = new SpellChecker();
//    textEditor.setSpellChecker(spellChecker);
//    textEditor.spellCheck();

    //IOC 控制反转
    ApplicationContext context = new ClassPathXmlApplicationContext("BeansInner.xml");
    TextEditor te = (TextEditor) context.getBean("textEditor");
    te.spellCheck();
  }
}
