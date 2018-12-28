package project.tests.Teacher;

import project.tests.BaseTest;


public class TeacherBaseTest extends BaseTest {

    private static String username = "teacher";
    private static String password = "teacher";

    protected static String addAssignmentTitle= "Add New Assignment";
    protected static String editAssignmentTitle= "Edit Assignment";
    protected static String editGradeTitle= "Edit Grade";
    protected static String classSettingsTitle = "Class Settings";
    protected static String MainTitle = "teacher1 teacher1's Classes";
    protected static String viewAnnouncementsTitle = "View Announcements";
    protected static String studentsTitle = "Students";
    protected static String manageAssignmentTitle = "Manage Assignments";
    protected static String gradesTitle = "Grades";

    protected String getUsername(){
        return username;
    }
    protected String getPassword(){
        return password;
    }

}
