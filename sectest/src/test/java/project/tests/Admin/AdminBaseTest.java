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
    protected static String editAnnouncementTitle = "Edit Announcement";
    protected static String editTermTitle = "Edit Term";

    protected String getUsername(){
        return username;
    }
    protected String getPassword(){
        return password;
    }

}
