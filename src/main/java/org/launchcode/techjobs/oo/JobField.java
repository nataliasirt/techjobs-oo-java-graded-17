package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    private int id;
    private static int nextId = 1;
    private String value;
    // Constructor with no parameters (default constructor) for unique id
    public JobField() {
        this.id = nextId;
        nextId++;
    }
    // parametrized constructor to initialize the value field
    public JobField(String value) {
        this();
        this.value = value;
    }

    public int getId() {
        return id;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField jobField)) return false;
        return getId() == jobField.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
