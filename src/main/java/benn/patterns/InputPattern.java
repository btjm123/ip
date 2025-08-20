package benn.patterns;


public final class InputPattern {
    public static final String LIST = "(?i)^\\s*list\\s*$";
    public static final String ADD_TODO = "(?i)^\\s*todo\\s+(?<description>.+)\\s*$";
    public static final String ADD_DEADLINE = "(?i)^\\s*deadline\\s+(?<description>.+?)\\s*/by\\s+(?<dateTimeDue>.+)\\s*$";
    public static final String ADD_EVENT = "(?i)^\\s*event\\s+(?<description>.+?)\\s*/from\\s+(?<startDateTime>.+?)\\s*/to\\s+(?<endDateTime>.+)\\s*$";
    public static final String MARK_TASK = "(?i)^\\s*mark\\s+(?<index>\\d+)\\s*$";
    public static final String UNMARK_TASK = "(?i)^\\s*unmark\\s+(?<index>\\d+)\\s*$";
    public static final String BYE = "(?i)^\\s*bye\\s*$";
}

