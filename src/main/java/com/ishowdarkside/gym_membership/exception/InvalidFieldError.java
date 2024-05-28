package com.ishowdarkside.gym_membership.exception;

import java.util.ArrayList;

public class InvalidFieldError {

    private ArrayList<String> errors;
    private String status = "fail";

    public InvalidFieldError(ArrayList<String> errors){

        this.errors = errors;

    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
