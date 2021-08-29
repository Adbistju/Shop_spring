package adbistju.system.controllers.user;

import adbistju.system.dtos.oreder.OrderItemDto;
import adbistju.system.models.Cart;
import adbistju.system.services.MasterService;
import adbistju.system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MasterService masterService;

    //http://localhost:8080/user/add?email=NewTestUser%40mail.test&username=test1&password=101
    @GetMapping("/registry")
    public void createNewUser(@RequestParam MultiValueMap<String, String> params) {
        masterService.createUser(params);
    }


}
