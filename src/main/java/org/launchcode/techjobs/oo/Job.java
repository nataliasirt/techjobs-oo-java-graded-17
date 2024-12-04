package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    // Constructor with no parameters (default constructor)
public Job(){
        id = nextId;
        nextId++;
}
    // Constructor with parameters
public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
   this();
    this.name = name;
    this.employer = employer;
    this.location = location;
    this.positionType = positionType;
    this.coreCompetency = coreCompetency;
}
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    //2 Job objects are considered equal only if their id fields are the same.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    //ensures that objects with the same id have the same hash code. same id = same hash code
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        if (name == null && employer == null && location == null && positionType == null && coreCompetency == null) {
            return "OOPS! This job does not seem to exist.";
        }
        return System.lineSeparator() +
                "ID: " + id + System.lineSeparator() +
                "Name: " + (name != null && !name.isEmpty() ? name : "Data not available") + System.lineSeparator() +
                "Employer: " + (employer != null && employer.toString() != null && !employer.toString().isEmpty() ? employer : "Data not available") + System.lineSeparator() +
                "Location: " + (location != null && location.toString() != null && !location.toString().isEmpty() ? location : "Data not available") + System.lineSeparator() +
                "Position Type: " + (positionType != null && positionType.toString() != null && !positionType.toString().isEmpty() ? positionType : "Data not available") + System.lineSeparator() +
                "Core Competency: " + (coreCompetency != null && coreCompetency.toString() != null && !coreCompetency.toString().isEmpty() ? coreCompetency : "Data not available") + System.lineSeparator();
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
