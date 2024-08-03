package com.studentmanagementsystem.controller.redirect;

import com.studentmanagementsystem.controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RedirectPage {

    @Autowired
    private AddressController addressController;

    @Autowired
    private ClassroomController classroomController;

    @Autowired
    private HomeworkController homeworkController;

    @Autowired
    private ParentController parentController;

    @Autowired
    private ReportController reportController;

    @Autowired
    private SchoolController schoolController;

    @Autowired
    private StudentController studentController;

    @Autowired
    private SubjectController subjectController;

    @Autowired
    private TeacherController teacherController;

    /*
    *
    * Pages redirect
    *
    * */

    //indexPage
    private static String homePage = "index";

    //Admin Dashboard Page
    private static String adminDashboardPage = "dashboard";
    //Address Page
    private static String adminAddressPage = "address";

    //Class Room Page
    private static String adminClassroomPage = "classroom";

    //Homework Page
    private static String adminHomeworkPage = "homework";

    //Parent Page
    private static String adminParentPage = "parent";

    //Report Page
    private static String adminReportPage = "report";

    //Admin School
    private static String adminSchoolPage = "school";

    //Student Page
    private static String adminStudentPage = "student";

    //Subject Page
    private static String adminSubjectPage = "subject";

    //Teacher Page
    private static String adminTeacherPage = "teacher";


    public String indexPage(){
        return homePage;
    }

    /*
    *
    * Address
    *
    * */


    /*
    *
    * Class Room
    *
    * */

    /*
    *
    * Homework
    *
    * */

    /*
    *
    * Parent
    *
    * */

    /*
    *
    * Report
    *
    * */

    /*
    *
    * School
    *
    * */

    /*
    *
    * Student
    *
    * */

    /*
    *
    * Subject
    *
    * */

    /*
    *
    * Teacher
    *
    * */

}
