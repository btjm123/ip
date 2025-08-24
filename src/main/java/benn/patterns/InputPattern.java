package benn.patterns;

import java.util.regex.Pattern;

public final class InputPattern {
    private static final String DATE = "(?:0[1-9]|[12][0-9]|3[01])/(?:0[1-9]|1[0-2])/\\d{4}";
    private static final String TIME = "(?:[01]\\d|2[0-3]):[0-5]\\d";
    private static final String DATETIME = DATE + "\\s+" + TIME;

    public static final Pattern LIST = Pattern.compile("(?i)^\\s*list\\s*$");
    public static final Pattern ADD_TODO = Pattern.compile("(?i)^\\s*todo\\s+(?<description>.+)\\s*$");
    public static final Pattern ADD_DEADLINE = Pattern.compile("(?i)^\\s*deadline\\s+(?<description>.+?)\\s*/by\\s+(?<dateTimeDue>" + DATETIME + ")\\s*$");
    public static final Pattern ADD_EVENT = Pattern.compile("(?i)^\\s*event\\s+(?<description>.+?)\\s*/from\\s+(?<startDateTime>" + DATETIME + ")\\s*/to\\s+(?<endDateTime>" + DATETIME + ")\\s*$");
    public static final Pattern MARK_TASK = Pattern.compile("(?i)^\\s*mark\\s+(?<index>\\d+)\\s*$");
    public static final Pattern UNMARK_TASK = Pattern.compile("(?i)^\\s*unmark\\s+(?<index>\\d+)\\s*$");
    public static final Pattern DELETE_TASK = Pattern.compile("(?i)^\\s*delete\\s+(?<index>\\d+)\\s*$");
    public static final Pattern BYE = Pattern.compile("(?i)^\\s*bye\\s*$");
}


