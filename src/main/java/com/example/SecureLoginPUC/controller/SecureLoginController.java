package com.example.SecureLoginPUC.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SecureLoginPUC.config.UserConfig;
import com.example.SecureLoginPUC.service.PasswordRecoveryService;
import com.example.SecureLoginPUC.service.SendEmailService;
import com.example.SecureLoginPUC.service.UserService;

@Controller
public class SecureLoginController {

    private final UserConfig userConfig;
    private final SendEmailService sendEmailService;
    private final UserService userService;
    private final PasswordRecoveryService passwordRecoveryService;

    public SecureLoginController(
            UserConfig userConfig,
            SendEmailService sendEmailService,
            UserService userService,
            PasswordRecoveryService passwordRecoveryService) {

        this.userConfig = userConfig;
        this.sendEmailService = sendEmailService;
        this.userService = userService;
        this.passwordRecoveryService = passwordRecoveryService;
    }

    /*
     * ============================================================
     * HOME
     * ============================================================
     */

    @GetMapping("/home")
    public String home(
            Authentication authentication,
            Model model) {

        System.out.println(
                "Usuário logado: " + authentication.getName());

        model.addAttribute(
                "usuario",
                authentication.getName());

        return "home";
    }

    /*
     * ============================================================
     * LOGIN
     * ============================================================
     */

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /*
     * ============================================================
     * ERROR
     * ============================================================
     */

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    /*
     * ============================================================
     * ADMIN
     * ============================================================
     */

    @GetMapping("/admin")
    public String admin(
            Authentication authentication,
            Model model) {

        System.out.println(
                "Administrador logado: " + authentication.getName());

        model.addAttribute(
                "usuario",
                authentication.getName());

        return "admin";
    }

    /*
     * ============================================================
     * CADASTRO
     * ============================================================
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("cpf") String cpf,
            @RequestParam("rg") String rg,
            @RequestParam("endereco") String endereco,
            @RequestParam("instituicao") String instituicao,
            @RequestParam("senha") String senha) {

        // Aqui você pode adicionar lógica para salvar os dados do usuário, por exemplo:
        // userService.saveUser(new User(nome, email, cpf, rg, endereco, instituicao, senha));

        // Redirecionar ou exibir uma mensagem de sucesso
        System.out.println("Registro: Redirecionado para a página de login.");
        return "redirect:/login"; // Após o registro, redirecionar para a página de login
    }

    @GetMapping("/recoverpassword")
    public String recoverpassword() {
        return "recoverpassword";
    }

    @PostMapping("/recoverpassword")
    public String handleRecoverPassword(
            @RequestParam("email") String email) {
        System.out.println("Recuperação de E-mail: Redirecionado para a página de login.");
        return "redirect:/login"; // Após a recuperação de senha, redirecionar para a página de login
    }

    @GetMapping("/recoverpasswordsms")
    public String recoverpasswordsms() {
        return "recoverpasswordsms";
    }

    @PostMapping("/recoverpasswordsms")
    public String handleRecoverPasswordsms(
            @RequestParam("sms") String sms) {
        System.out.println("Recuperação de SMS: Redirecionado para a página de login.");
        return "redirect:/login"; 
    }

}
