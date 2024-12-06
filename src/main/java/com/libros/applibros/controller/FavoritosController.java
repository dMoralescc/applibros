package com.libros.applibros.controller;
import com.libros.applibros.model.Libro;
import com.libros.applibros.model.LibroFav;
import com.libros.applibros.model.Usuario;
import com.libros.applibros.request.AddFavoritosRequest;
import com.libros.applibros.service.FavoritosService;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FavoritosController {
    private final FavoritosService favoritosService;

 public FavoritosController(FavoritosService favoritosService) {
        this.favoritosService = favoritosService;
    }

    @PostMapping("/addFavoritos")
    public ResponseEntity<String> agregarFavorito(
         HttpSession session,
         @RequestBody AddFavoritosRequest request) {

         Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return ResponseEntity.status(401).body("Debes iniciar sesión para realizar esta acción");
        }


        if (request.getId() == null || request.getId().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo 'id' es obligatorio.");
        }

        String fechaFav = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // Convertir AddFavoritosRequest a Libro
        LibroFav librofav = new LibroFav();
        librofav.setId(request.getId());
        librofav.setIsbn(request.getIsbn());
        librofav.setIdusuario(usuario.getId_usr());
        librofav.setFechafav(fechaFav);
        librofav.setEstado(0);


        favoritosService.agregarFavorito(librofav);
        return ResponseEntity.ok("Libro marcado como favorito exitosamente.");
    }
}
