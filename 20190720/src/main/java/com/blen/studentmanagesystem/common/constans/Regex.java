package com.blen.studentmanagesystem.common.constans;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Regex {

    public static final long ID_MAX = Long.MAX_VALUE;

    public static final long CODE_MAX = Long.MAX_VALUE;

    public static final String NAME = "[a-zA-Z0-9]{1,30}";

    public static final String SEX = "[a-zA-Z0-9]{1,10}";

    public static final String CALSSNAME = "[a-zA-Z0-9]{1,10}";

    public static final String GRADE = "^[0-9.]{1,4}";


}
