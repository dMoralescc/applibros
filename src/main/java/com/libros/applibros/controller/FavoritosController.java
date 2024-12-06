package com.libros.applibros.controller;
import com.libros.applibros.model.Libro;
import com.libros.applibros.request.AddFavoritosRequest;
import com.libros.applibros.service.FavoritosService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FavoritosController {
    private final FavoritosService favoritosService;

 public FavoritosController(FavoritosService favoritosService) {
        this.favoritosService = favoritosService;
    }

    @PostMapping("/addFavoritos")
    public ResponseEntity<String> agregarFavorito(@RequestBody AddFavoritosRequest request) {
        if (request.getId() == null || request.getId().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo 'id' es obligatorio.");
        }

        // Convertir AddFavoritosRequest a Libro
        Libro libro = new Libro();
        libro.setId(request.getId());
        libro.setTitulo(request.getTitulo());
        libro.setSubtitulo(request.getSubtitulo());
        libro.setAutores(request.getAutores());
        libro.setEditorial(request.getEditorial());
        libro.setFechaPublicacion(request.getFechaPublicacion());
        libro.setDescripcion(request.getDescripcion());
        libro.setCategorias(request.getCategorias());
        libro.setPuntuacion(request.getPuntuacion());
        libro.setImagenPortada(request.getImagenPortada());

        favoritosService.agregarFavorito(libro);
        return ResponseEntity.ok("Libro marcado como favorito exitosamente.");
    }
}
