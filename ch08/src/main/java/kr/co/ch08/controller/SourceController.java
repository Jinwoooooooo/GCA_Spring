package kr.co.ch08.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SourceController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/source/admin")
    public String admin() {
        return "/source/admin";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping("/source/manager")
    public String manager() {
        return "/source/manager";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'STAFF')")
    @GetMapping("/source/staff")
    public String staff() {
        return "/source/staff";
    }
}
