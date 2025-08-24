package benn.patterns;


import java.util.regex.Pattern;

public final class TaskStoragePattern {
    public static final Pattern TODO = Pattern.compile("^\\s*T\\s*\\|\\s*(?<done>[01])\\s*\\|\\s*(?<description>[^|]+)\\s*$");
    public static final Pattern DEADLINE = Pattern.compile("^\\s*D\\s*\\|\\s*(?<done>[01])\\s*\\|\\s*(?<description>[^|]+)\\s*\\|\\s*(?<by>[^|]+)\\s*$");
    public static final Pattern EVENT = Pattern.compile("^\\s*E\\s*\\|\\s*(?<done>[01])\\s*\\|\\s*(?<description>[^|]+)\\s*\\|\\s*(?<from>[^|]+)\\s*\\|\\s*(?<to>[^|]+)\\s*$");
}
