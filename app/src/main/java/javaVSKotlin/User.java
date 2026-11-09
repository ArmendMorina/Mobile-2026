package javaVSKotlin;

import org.jetbrains.annotations.NotNull;

public class User {
    private final String studentEmail;
    private final String studentPassword;

    public User(@NotNull String studentEmail, @NotNull String studentPassword) {
        this.studentEmail = studentEmail;
        this.studentPassword = studentPassword;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }
}

