package com.w2s.poc.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StackTraceUtils {

    public static String stackTraceToString(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        printStackTrace(throwable, pw);
        return sw.toString();
    }

    public static void printStackTrace(Throwable throwable, PrintWriter pw) {
        throwable.printStackTrace(pw);
    }
}