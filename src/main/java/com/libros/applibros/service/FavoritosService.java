package com.libros.applibros.service;

import org.springframework.stereotype.Service;

import com.libros.applibros.model.Libro;
import com.libros.applibros.repository.FavoritosRepository;

@Service
public class FavoritosService {
    private final FavoritosRepository favoritosRepository;

    public FavoritosService(FavoritosRepository favoritosRepository) {
        this.favoritosRepository = favoritosRepository;
    }

    public void agregarFavorito(Libro libro) {
        favoritosRepository.save(libro); // Reutiliza esta lógica
    }
}