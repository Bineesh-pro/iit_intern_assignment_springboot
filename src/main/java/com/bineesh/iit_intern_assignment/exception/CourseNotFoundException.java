package com.bineesh.iit_intern_assignment.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String msg){
        super(msg);
    }
}
