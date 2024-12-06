package com.libros.applibros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.libros.applibros.model.LibroFav;
import com.libros.applibros.service.FavoritosService;

public interface FavoritosRepository extends JpaRepository<LibroFav, String> {
    @RestController
    @RequestMapping("/favoritos") // Mapeo del endpoint
    public class FavoritosController {
        private final FavoritosService favoritosService;
    
        public FavoritosController(FavoritosService favoritosService) {
            this.favoritosService = favoritosService;
        }
    
        @PostMapping // Maneja solicitudes POST
        public String agregarFavorito(@RequestBody LibroFav libro) {
            favoritosService.agregarFavorito(libro);
            return "Libro marcado como favorito exitosamente.";
        }
    }
}
