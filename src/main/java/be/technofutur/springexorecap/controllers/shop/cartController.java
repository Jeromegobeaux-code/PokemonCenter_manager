package be.technofutur.springexorecap.controllers;


import be.technofutur.springexorecap.entities.UserEntity;
import be.technofutur.springexorecap.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class cartController {

public final UserRepo userRepo;

@PreAuthorize("isAuthenticated()")
@GetMapping
    public String getCart(Model model, @AuthenticationPrincipal UserEntity user)
{
    return "index";
}

}
