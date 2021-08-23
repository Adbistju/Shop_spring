package adbistju.system.controllers.testController.session;


//@RestController
//@RequestMapping("/session")
//public class SessionController {
//    private OrderService orderService;
//    private UserService userService;
//
//    private Cart cart;
//
//    @Autowired
//    public SessionController(OrderService orderService, UserService userService, Cart cart) {
//        this.orderService = orderService;
//        this.userService = userService;
//        this.cart = cart;
//    }
//
//    @GetMapping("/getitem") ///{value}
//    public ArrayList<String> getItemArrayList(Principal principal){
//        System.out.println("null");
//        User user = userService.findByUsername(principal.getName()).get();
//        orderService.findAllByUser(user);
////        System.out.println(userService.findByUsername(value).get());
////        User user = userService.findByUsername(value).get();
//        System.out.println("tututut");
//        return cart.getItems();
//    }

//    @GetMapping("/get/{value}")
//    public void getSessionList(@PathVariable("value") String value){
//        cart.addItem(value);
//    }

//    @GetMapping("/get/delete/{value}")
//    public void DeleteSessionList(@PathVariable("value") String value){
//        cart.deleteItem(value);
//    }

//    @GetMapping("/auth_page")
//    public String auth_page(){
//        return "auth_page";
//    }
//
//    @GetMapping("/admin")
//    public String admin(){
//        return "admin";
//    }
//}
