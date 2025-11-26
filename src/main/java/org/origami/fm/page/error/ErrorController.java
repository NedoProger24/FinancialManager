package org.origami.fm.page.error;

import org.hibernate.annotations.Fetch;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("//error")
    public String error() {
        return "error";
    }
    @GetMapping("//login?error=true")
    public String loginError() {
        return "login_error";
    }
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access_denied";
    }

}
