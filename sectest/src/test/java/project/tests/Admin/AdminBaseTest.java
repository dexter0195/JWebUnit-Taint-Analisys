package project.tests.Admin;

import project.tests.BaseTest;


public class AdminBaseTest extends BaseTest {

    protected static String username = "schoolmate";
    protected static String password = "schoolmate";

    protected static String MainTitle = "";
    protected static String addAttendanceTitle = "Add New Attendance Record";
    protected static String addAnnouncementTitle = "Add New Announcement";
    protected static String addUserTitle = "Add New User";
    protected static String addTermTitle = "Add New Term";
    protected static String addTeacherTitle = "Add New Teacher";
    protected static String addStudentTitle = "Add New Student";
    protected static String addSemesterTitle = "Add New Semester";
    protected static String addClassTitle = "Add New Class";
    protected static String addParentTitle = "Add New Parent";
    protected static String editAnnouncementTitle = "Edit Announcement";
    protected static String editTermTitle = "Edit Term";
    protected static String editTeacherTitle = "Edit Teacher";
    protected static String editSemesterTitle = "Edit Semester";
    protected static String editStudentTitle = "Edit Student";
    protected static String editUserTitle = "Edit User";
    protected static String editParentTitle = "Edit Parent";
    protected static String manageSchoolTitle = "Manage School Information";

    protected String getUsername(){
        return username;
    }
    protected String getPassword(){
        return password;
    }

}
