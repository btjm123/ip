package benn.patterns;


public final class InputPattern {
    public static final String ADD_ITEM = "(?i)^\\s*add\\s+(?<description>.+?)\\s*$";
    public static final String LIST = "(?i)^\\s*list\\s*$";
    public static final String MARK_TASK = "(?i)^\\s*mark\\s+(?<index>\\d+)\\s*$";
    public static final String UNMARK_TASK = "(?i)^\\s*unmark\\s+(?<index>\\d+)\\s*$";
    public static final String BYE = "(?i)^\\s*bye\\s*$";
}

