package project.tests.Parent;

import project.tests.BaseTest;


public class ParentBaseTest extends BaseTest {

    private static String username = "parent";
    private static String password = "parent";

    protected static String MainTitle = "Students of parent parent";
    protected static String classesTitle = "studente 1 uno's Classes";
    protected static String classSettingsTitle = "Class Settings";
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
