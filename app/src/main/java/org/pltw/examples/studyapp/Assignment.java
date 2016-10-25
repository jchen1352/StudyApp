package org.pltw.examples.studyapp;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Assignment class that stores name and due date.
 */
public class Assignment {

    private String assignmentName;
    private Date dueDate;
    private int month;
    private int day;
    private int year;
    private DateFormat df = DateFormat.getDateInstance();
    private static Calendar c = Calendar.getInstance();

    public Assignment(String name, int month, int day, int year) {
        this.assignmentName = name;
        this.month = month;
        this.day = day;
        this.year = year;
        this.dueDate = convertToDate(month, day, year);
    }

    public Assignment(String name, Date dueDate) {
        this.assignmentName = name;
        this.dueDate = dueDate;
        c.setTime(dueDate);
        this.month = c.get(Calendar.MONTH);
        this.day = c.get(Calendar.DAY_OF_MONTH);
        this.year = c.get(Calendar.YEAR);
    }

    public Assignment(String name, long dueDateMillis) {
        this(name, new Date(dueDateMillis));
    }

    private static Date convertToDate(int month, int day, int year) {
        c.set(year, month, day);
        return c.getTime();
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    @Override
    public String toString() {
        return assignmentName+" "+getDateString();
    }

    public String getDateString() {
        return df.format(dueDate);
    }

    public long getDateMillis() {
        return dueDate.getTime();
    }

    /**
     * CURRENTLY UNUSED
     * Creates new Assignment from input string.
     * @param s The string to be parsed. Is in the same format as the toString method.
     * @return A new Assignment.
     * @throws IllegalArgumentException
     */
    public static Assignment parseAssignment(String s) throws IllegalArgumentException{
        Pattern p = Pattern.compile("([\\w ]*?) (\\d{1,2})-(\\d{1,2})-(\\d{4})");
        Matcher m = p.matcher(s);
        if (m.matches()) {
            String name = m.group(1);
            int month = Integer.parseInt(m.group(2));
            int day = Integer.parseInt(m.group(3));
            int year = Integer.parseInt(m.group(4));
            return new Assignment(name, month, day, year);
        }
        throw new IllegalArgumentException("Cannot parse string to assignment!");
    }
}
