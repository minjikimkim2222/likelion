package org.filterTest.filterexam4.filter;


import org.filterTest.filterexam4.entity.User;

public class UserContext {
    private static final ThreadLocal<User> USER_THREAD_LOCAL =
            new ThreadLocal<>();

    public static void setUser(User user){
        USER_THREAD_LOCAL.set(user);
    }

    public static User getUser(){
        return USER_THREAD_LOCAL.get();
    }

    public static void clear(){
        USER_THREAD_LOCAL.remove();
    }
}
