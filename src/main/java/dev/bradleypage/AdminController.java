package dev.bradleypage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin/")
    String getPage(){
        return "Congrats, you are admin.";
    }
}
