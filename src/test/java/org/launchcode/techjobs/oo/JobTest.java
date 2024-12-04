package org.launchcode.techjobs.oo;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    //TASK 4
    //test verifies that each Job object created with empty constructor get unique Id.
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }
    //check if full constructor correctly sets all fiels and types
@Test
    public void testJobConstructorSetsAllFields() {
    Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    //check if testJob1 is instance of Job
    assertTrue(testJob1 instanceof Job);
    //check name field etc
    assertEquals("Product tester", testJob1.getName());
    // check employer field
    assertTrue(testJob1.getEmployer() instanceof Employer);
    assertEquals("ACME", testJob1.getEmployer().getValue());

    assertTrue(testJob1.getLocation() instanceof Location);
    assertEquals("Desert", testJob1.getLocation().getValue());

    assertTrue(testJob1.getPositionType() instanceof PositionType);
    assertEquals("Quality control", testJob1.getPositionType().getValue());

    assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);
    assertEquals("Persistence", testJob1.getCoreCompetency().getValue());
}
//checks jobs with the same field values but different ids are not equal
@Test
        public void testJobsForEquality(){
        Job job1 = new Job ("Web Developer", new Employer("Google"), new Location("St. Louis"), new PositionType("Software Engineer"), new CoreCompetency("Java"));
        Job job2 = new Job ("Web Developer", new Employer("Google"), new Location("St. Louis"), new PositionType("Software Engineer"), new CoreCompetency("Java"));

        assertFalse(job1.equals(job2));
    }
    //TASK 5
    //test verifies that the string representation of a Job object starts and ends with a new line.
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString(); //to store the result in jobString var
        assertEquals(System.lineSeparator(), jobString.substring(0, System.lineSeparator().length())); //extracts the first character of jobString
        assertEquals(System.lineSeparator(), jobString.substring(jobString.length() - System.lineSeparator().length())); //extracts the last character of jobString
    }
    //check correct formatting of fields
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedOutput = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: Product tester" + System.lineSeparator() +
                "Employer: ACME" + System.lineSeparator() +
                "Location: Desert" + System.lineSeparator() +
                "Position Type: Quality control" + System.lineSeparator() +
                "Core Competency: Persistence" + System.lineSeparator();
        assertEquals(expectedOutput, job.toString());
    }
    //test to handle empty fields
    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
        String expectedOutput = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: Data not available" + System.lineSeparator() +
                "Employer: Data not available" + System.lineSeparator() +
                "Location: Data not available" + System.lineSeparator() +
                "Position Type: Data not available" + System.lineSeparator() +
                "Core Competency: Data not available" + System.lineSeparator();
        assertEquals(expectedOutput, job.toString());
    }
}


