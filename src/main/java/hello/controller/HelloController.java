//package hello.controller;
//
//import hello.entity.User;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import service.UserService;
//
//import javax.inject.Inject;
//
//@RestController
//public class HelloController {
//    private UserService userService;
//
//    @Inject
//    public HelloController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping("/")
//    public User index() {
//        return this.userService.getUserById(1);
//    }
//
//}