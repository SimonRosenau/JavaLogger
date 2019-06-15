package de.rosenau.simon.logger;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * Author: Simon Rosenau
 * Date: 15.06.2019
 * Time: 00:59
 */

public class Logger extends PrintStream {

    public static void initialize() {
        System.setOut(new Logger(System.out, new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss")));
    }

    // ==========================================================================================

    private SimpleDateFormat format;

    public Logger(PrintStream stream, SimpleDateFormat format) {
        super(stream);
        this.format = format;
    }

    private StackTraceElement getStackTraceElement() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[3];
    }

    private String formatPrefix(StackTraceElement element) {
        return "[" + format.format(new Date()) + "] [" + Thread.currentThread().getName() + "] " + element.getClassName() + "." + element.getMethodName() + "() - " + element.getFileName() + ":" + element.getLineNumber() + ": ";
    }

    @Override
    public void println(int x) {
        super.println(formatPrefix(getStackTraceElement()) + x);
    }

    @Override
    public void println(char x) {
        super.println(formatPrefix(getStackTraceElement()) + x);
    }

    @Override
    public void println(long x) {
        super.println(formatPrefix(getStackTraceElement()) + x);
    }

    @Override
    public void println(float x) {
        super.println(formatPrefix(getStackTraceElement()) + x);
    }

    @Override
    public void println(char[] x) {
        super.println(formatPrefix(getStackTraceElement()) + new String(x));
    }

    @Override
    public void println(double x) {
        super.println(formatPrefix(getStackTraceElement()) + x);
    }

    @Override
    public void println(Object x) {
        super.println(formatPrefix(getStackTraceElement()) + x);
    }

    @Override
    public void println(String x) {
        super.println(formatPrefix(getStackTraceElement()) + x);
    }

    @Override
    public void println(boolean x) {
        super.println(formatPrefix(getStackTraceElement()) + x);
    }

    @Override
    public void println() {
        super.println(formatPrefix(getStackTraceElement()));
    }

    @Override
    public PrintStream printf(String format, Object... args) {
        return super.printf(formatPrefix(getStackTraceElement()) + format, args);
    }

    @Override
    public PrintStream printf(Locale l, String format, Object... args) {
        return super.printf(l, formatPrefix(getStackTraceElement()) + format, args);
    }

}
