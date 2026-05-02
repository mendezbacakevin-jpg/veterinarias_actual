package com.cibertec.veterinaria.api.controller;

import com.cibertec.veterinaria.api.dto.usuario.UsuarioRequestDto;
import com.cibertec.veterinaria.api.dto.usuario.UsuarioResponseDto;
import com.cibertec.veterinaria.data.entity.Usuario;
import com.cibertec.veterinaria.domain.service.interfaces.IAuthService;
import com.cibertec.veterinaria.domain.service.interfaces.IEmailService;
import com.cibertec.veterinaria.domain.service.interfaces.IUsuarioService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/seguridad")
public class UsuarioController {

    // 🔹 ATRIBUTOS (AQUÍ VAN)
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IEmailService emailService;
    @Autowired
    private IAuthService authService;




    // 🔹 MOSTRAR REGISTRO (opcional)
    @GetMapping("/registrarUsuario")
    public String mostrarRegistro() {
        return "login2";
    }

    // 🔹 REGISTRAR USUARIO
    @PostMapping("/registrarUsuario")
    public String registrarUsuario(@RequestParam String username,
                                   @RequestParam String email,
                                   @RequestParam String password,
                                   Model model) {

        Usuario nuevo = new Usuario();
        nuevo.setUsername(username);
        nuevo.setEmail(email);
        nuevo.setPassword(password);
        usuarioService.actualizar(nuevo);
/*
        try {
            emailService.sendWelcomeEmail(email, username);
        } catch (MessagingException e) {
            model.addAttribute("mensaje", "Usuario registrado, pero falló el correo.");
            return "login";
        }*/

        model.addAttribute("mensaje", "Usuario registrado correctamente.");
        return "usuario registrado";
    }

    // 🔹 LOGIN modi
    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDto> login(@RequestBody UsuarioRequestDto request) {

        // 🔹 Llamas al service (ya no trabajas con entity aquí)
        UsuarioResponseDto usuario = authService.login(request);

        return ResponseEntity.ok(usuario);
    }

    // 🔹 LOGOUT
    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "principal";
    }

    // 🔹 PERFIL
    @GetMapping("/perfil")
    public String mostrarPerfil(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "principal";
        }

        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    // 🔹 ACTUALIZAR PERFIL
    @PostMapping("/actualizarPerfil")
    public String actualizarPerfil(@RequestParam String email,
                                   @RequestParam String password,
                                   HttpSession session,
                                   RedirectAttributes redirectAttributes) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");



        if (usuario != null) {
//            usuario.setEmail(email);
//            usuario.setPassword(password);
//            usuarioService.actualizar(usuario);
            usuarioService.actualizarPerfil(usuario,email,password);

            redirectAttributes.addFlashAttribute("mensaje", "Perfil actualizado correctamente.");
        }

        return "redirect:/perfil";
    }

    // 🔹 ENVIAR CORREO
    @PostMapping("/enviar-correo")
    public ResponseEntity<String> enviarCorreo(@RequestBody Map<String, Object> datos) {
        try {
            emailService.enviarCorreoDeCompra(datos);
            return ResponseEntity.ok("Correo enviado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al enviar correo");
        }
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


