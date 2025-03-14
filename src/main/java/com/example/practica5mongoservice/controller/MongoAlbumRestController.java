package com.example.practica5mongoservice.controller;


import com.example.practica5mongoservice.model.dto.AlbumDTO;
import com.example.practica5mongoservice.model.entity.Album;
import com.example.practica5mongoservice.service.MongoAlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase rest controller de albumes
 */
@RestController
@RequestMapping("/Practica5MongoService/album")
public class MongoAlbumRestController {

    //servicio de albumes
    private final MongoAlbumService mongoAlbumService;

    /**
     * Constructor de la clase
     * @param mongoAlbumService el servicio de albumes
     */
    public MongoAlbumRestController(MongoAlbumService mongoAlbumService) {
        this.mongoAlbumService = mongoAlbumService;
    }

    /**
     * Metodo post para crear el album
     * @param albumDTO el abum dto
     * @return un mensaje indicando si se creo o no el album
     */
    @PostMapping("/crear")
    public ResponseEntity<String> crearAlbumController(@RequestBody AlbumDTO albumDTO) {
        try{
            mongoAlbumService.crearAlbum(albumDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album creado correctamente");
    }

    /**
     * Metodo para borrar el album de la base de datos
     * @param id el is del album
     * @return un mensaje indicando si se borro o no el album
     */
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarAlbumController(@PathVariable String id) {
        try{
            mongoAlbumService.deleteAlbumById(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album borrado correctamente");
    }

    /**
     * Metodo para listar un album por id
     * @param id el id del album
     * @return un objeto album
     */
    @GetMapping("/listar/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable String id) {
        try{
            Album album = mongoAlbumService.getAlbumsById(id);
            if(album == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(album);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * Metodo para listar todos los albumes
     * @return la lista de albumes
     */
    @GetMapping("/listar")
    public ResponseEntity<List<Album>> getAlbums() {
        try{
            List<Album> albumList = mongoAlbumService.getAllAlbums();
            if(albumList == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(albumList);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * Metodo para actualizar un album de la base de datos
     * @param id el is a buscar en la base
     * @param albumDTO el album dto
     * @return un mensaje indicando si se actualizó o no el album
     */
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarAlbumByIdController(@PathVariable String id, @RequestBody AlbumDTO albumDTO) {
        try{
            mongoAlbumService.updateAlbumByIdService(id, albumDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album actualizado correctamente");
    }
}