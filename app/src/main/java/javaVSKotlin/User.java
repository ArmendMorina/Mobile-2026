package javaVSKotlin;

import org.jetbrains.annotations.NotNull;

import KotlinFund_2.Student;

public class User extends Student {
    public User(@NotNull String studentEmail, @NotNull String studentPassword) {
        super(studentEmail, studentPassword);
    }
}


