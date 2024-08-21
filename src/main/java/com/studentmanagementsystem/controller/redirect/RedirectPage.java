package com.studentmanagementsystem.controller.redirect;

import com.studentmanagementsystem.controller.*;
import com.studentmanagementsystem.entity.Address;
import com.studentmanagementsystem.entity.Users;
import com.studentmanagementsystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class RedirectPage {

    @Autowired
    private AddressService addressController;

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
    //Login
    private String loginPage = "auth/login/index";

    //Sign up
    private String signUpPage = "auth/signup/index";

    //indexPage
    private String homePage = "index";

    //Admin Dashboard Page
    private String adminDashboardPage = "dashboard/admin";

    //Address Page
    private String adminAddressPage = "address";

    //Class Room Page
    private String adminClassroomPage = "classroom";

    //Homework Page
    private String adminHomeworkPage = "homework";

    //Parent Page
    private String adminParentPage = "parent";

    //Report Page
    private String adminReportPage = "report";

    //Admin School
    private String adminSchoolPage = "school";

    //Student Page
    private String adminStudentPage = "student";

    //Subject Page
    private String adminSubjectPage = "subject";

    //Teacher Page
    private String adminTeacherPage = "teacher";
    @Autowired
    private UserController userController;


    @GetMapping(value = {"", "/", "index", "homepage"})
    public String indexPage(Model model){
        model.addAttribute("FaceBook","");
        model.addAttribute("Instagram","https://www.instagram.com/adityakalambe01/");
        model.addAttribute("LinkedIn","https://www.linkedin.com/in/adityakalambe/");
        model.addAttribute("GitHub","https://github.com/adityakalambe01/StudentManagementSystem");
        model.addAttribute("MailId","mailto:adityakalambe20@gmail.com");

        model.addAttribute("copyright","@ "+LocalDate.now().getYear()+" Student Management System. All rights reserved.");
        return homePage;
    }

    @GetMapping("/login-page")
    public String loginPage(
            @RequestParam(required = false, defaultValue = "user", value = "role") String role,
            Model model
    ){
        model.addAttribute("roleSignInMessage",
                ((char)(role.charAt(0)-32))+role.substring(1)+"'s"+" Sign In");
        return loginPage;
    }

    @GetMapping("/sign-up-page")
    public String signUpPage(){
        return signUpPage;
    }

    @PostMapping("/create-new-user")
    public String signUpUser( Users users, String confirm_password, Model model){
        if (users.getPassword().equals(confirm_password)){
            if (userController.save(users) != null)
                return loginPage;
            System.out.println(users.getEmailId()+" is already exists!");
        }
        model.addAttribute("firstName",users.getFirstName());
        model.addAttribute("middleName",users.getMiddleName());
        model.addAttribute("lastName",users.getLastName());
        model.addAttribute("emailId", users.getEmailId());
        model.addAttribute("phoneNumber", users.getPhoneNumber());
        System.out.println(users);

        return signUpPage;
    }

    @PostMapping(value = "/user-sign-in")
    public String userSignIn(Users users, Model model){
        Map<String, Object> user = userController.login(users);
        if ( user!= null){
            return homePage;
        }
        return loginPage;
    }

    @GetMapping("welcome")
    public String welcome(Model model){

        return "welcome";
    }

    @GetMapping(value = "admin-dashboard")
    public String adminDashboard(Model model){
        return adminDashboardPage;
    }

    @GetMapping(value = "school-dashboard")
    public String schoolDashboard(Model model){
        return null;
    }

    @GetMapping(value = "teacher-dashboard")
    public String teacherDashboard(Model model){
        return null;
    }

    @GetMapping(value = "student-dashboard")
    public String studentDashboard(Model model){
        return null;
    }



    /*
    *
    * Address
    *
    * */
    public Address saveAddress(Address browserAddress){
        return addressController.save(browserAddress);
    }

    public Address updateAddress(Integer id, Address updatedBrowserAddress){
        return addressController.updateAddress(id, updatedBrowserAddress);
    }

    public Address deleteAddress(Integer id){
        return addressController.deleteById(id);
    }

    public Address deleteAddress(Integer id, Address address){
        return addressController.updateAddress(id, address);
    }




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

    @GetMapping("test")
    public String test(Model model){
        return "xxx";
    }
}
