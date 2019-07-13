package project.tests.Student;

import project.tests.BaseTest;


public class StudentBaseTest extends BaseTest {

    private static String username = "student";
    private static String password = "student";

    protected static String MainTitle = "";
    protected static String classSettingsTitle = "Class Settings";
    protected static String classMainTitle = "studente 1 uno's Classes";
    protected static String ViewAssignmentTitle = "View Assignments";
    protected static String ViewGradesTitle = "View Grades";
    protected static String viewAnnouncementsTitle = "View Announcements";

    protected String getUsername(){
        return username;
    }
    protected String getPassword(){
        return password;
    }

}
