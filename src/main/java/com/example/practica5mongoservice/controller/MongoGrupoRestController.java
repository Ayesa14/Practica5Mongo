package com.example.practica5mongoservice.controller;


import com.example.practica5mongoservice.model.dto.GrupoDTO;
import com.example.practica5mongoservice.model.entity.Grupo;
import com.example.practica5mongoservice.service.MongoGrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar las operaciones CRUD sobre los documentos de "Grupo" en la base de datos MongoDB.
 * Este controlador interactúa con el servicio MongoGrupoService para realizar operaciones de creación, lectura, actualización y eliminación (CRUD).
 */
@RestController
@RequestMapping("/Practica5MongoService/grupo")
public class MongoGrupoRestController {

    public final MongoGrupoService mongoGrupoService;

    /**
     * Constructor para inicializar el controlador con el servicio correspondiente.
     *
     * @param mongoGrupoService Servicio para interactuar con la colección de grupos en MongoDB.
     */
    public MongoGrupoRestController(MongoGrupoService mongoGrupoService) {
        this.mongoGrupoService = mongoGrupoService;
    }

    /**
     * Metodo para crear un nuevo documento de tipo "Grupo" en MongoDB.
     *
     * @param grupoDTO El objeto de tipo GrupoDTO que contiene los datos del grupo a crear.
     * @return ResponseEntity con el estado de la operación y un mensaje correspondiente.
     */
    @PostMapping("/crear")
    public ResponseEntity<String> crearDocumentoMongo(@RequestBody GrupoDTO grupoDTO) {
        try{
            mongoGrupoService.crearGrupo(grupoDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Documento creado correctamente");
    }

    /**
     * Metodo para listar todos los grupos almacenados en MongoDB.
     *
     * @return ResponseEntity con la lista de grupos o un error en caso de fallo.
     */
    @GetMapping("/listar")
    public ResponseEntity<List<Grupo>> listarGruposMongo(){
        try{
            List<Grupo> grupoList = mongoGrupoService.getListGrupo();
            if(grupoList.isEmpty()){
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok().body(grupoList);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * Metodo para obtener un grupo específico de la base de datos MongoDB, identificado por su ID.
     *
     * @param id El identificador único del grupo que se desea obtener.
     * @return ResponseEntity con el grupo correspondiente o un error en caso de fallo.
     */
    @GetMapping("/listar/{id}")
    public ResponseEntity<Grupo> listarGruposMongoByID(@PathVariable String id){
        try{
            Grupo grupo = mongoGrupoService.getListGrupoById(id);
            if(grupo == null){
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok().body(grupo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * Metodo para eliminar un grupo de la base de datos MongoDB mediante su ID.
     *
     * @param id El identificador único del grupo que se desea eliminar.
     * @return ResponseEntity con el estado de la operación y un mensaje correspondiente.
     */
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarDocumentoMongo(@PathVariable String id){
        try{
            mongoGrupoService.deleteByIdService(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Documento eliminado correctamente");
    }

    /**
     * Metodo para actualizar los datos de un grupo en la base de datos MongoDB.
     *
     * @param id El identificador único del grupo que se desea actualizar.
     * @param grupoDTO El objeto de tipo GrupoDTO con los nuevos datos del grupo.
     * @return ResponseEntity con el estado de la operación y un mensaje correspondiente.
     */
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarDocumentoMongo(@PathVariable String id, @RequestBody GrupoDTO grupoDTO){
        try{
            mongoGrupoService.updateByIdService(id, grupoDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Documento actualizado correctamente");
    }

}