package com.blen.studentmanagesystem.common.i18n;

import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class LocalMessageResource {
  private static ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

  static {
    messageSource.setFallbackToSystemLocale(false);
    messageSource.setBasenames(
        "classpath:/i18n/messages_base",
        "classpath:/i18n/messages_param_validation"
    );
    messageSource.setDefaultEncoding("UTF-8");
  }

  private static final String NOT_TRANSLATED = " (NT)";

  public static String getMessage(String code) {
    try {
      return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    } catch (NoSuchMessageException e) {
      return code + NOT_TRANSLATED;
    }
  }

  public static String getMessage(String code, Object... args) {
    try {
      return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    } catch (NoSuchMessageException e) {
      return code + NOT_TRANSLATED;
    }
  }

  public static String getMessageIfPresent(String code, Object... args) {
    try {
      return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    } catch (NoSuchMessageException e) {
      return null;
    }
  }
}
