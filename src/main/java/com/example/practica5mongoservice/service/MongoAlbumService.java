package com.example.practica5mongoservice.service;


import com.example.practica5mongoservice.model.entity.Album;

import java.util.List;

/**
 * Servicio para manejar las operaciones relacionadas con los álbumes en la base de datos MongoDB.
 * Este servicio interactúa con el repositorio de álbumes y el repositorio de grupos para realizar operaciones CRUD.
 */
@Service
public class MongoAlbumService {

    //atributos de clase
    private final AlbumRepository albumRepository;
    private final GrupoRepository grupoRepository;

    /**
     * Constructor para inicializar el servicio con los repositorios correspondientes.
     *
     * @param albumRepository Repositorio para interactuar con la colección de álbumes en MongoDB.
     * @param grupoRepository Repositorio para interactuar con la colección de grupos en MongoDB.
     */
    public MongoAlbumService(AlbumRepository albumRepository, GrupoRepository grupoRepository) {
        this.albumRepository = albumRepository;
        this.grupoRepository = grupoRepository;
    }

    /**
     * Metodo para crear un nuevo álbum en MongoDB.
     * Verifica que el ID del grupo proporcionado exista antes de crear el álbum.
     *
     * @param albumDTO Objeto que contiene los datos del álbum a crear.
     * @throws IdExcepcion Si el ID del grupo no es válido.
     */
    public void crearAlbum(AlbumDTO albumDTO) {
        if(!getIdGrupo(albumDTO.getGrupoID())){
            throw new IdExcepcion("Este id no pertenece a un grupo para ser creado");
        }
        Album album = new Album(albumDTO.getId(), albumDTO.getGrupoID(), albumDTO.getTitulo(),
                albumDTO.getDataLanzamento(), albumDTO.getPuntuacion());
        albumRepository.save(album);
    }

    /**
     * Metodo para eliminar un álbum de MongoDB por su ID.
     *
     * @param id El identificador único del álbum a eliminar.
     */
    public void deleteAlbumById(String id) {
        Album album = albumRepository.findByid(id);
        if(album == null){
            throw new IdExcepcion("Este id no pertenece a un album para ser borrado");
        }
        albumRepository.deleteById(id);
    }

    /**
     * Metodo para obtener un álbum de MongoDB por su ID.
     *
     * @param id El identificador único del álbum a recuperar.
     * @return El álbum correspondiente al ID proporcionado.
     */
    public Album getAlbumsById(String id){
        Album album = albumRepository.findByid(id);
        if(album == null){
            return null;
        }
        return albumRepository.findByid(id);
    }

    /**
     * Metodo para obtener todos los álbumes almacenados en MongoDB.
     *
     * @return Una lista con todos los álbumes.
     */
    public List<Album> getAllAlbums(){
        List<Album> albums = albumRepository.findAll();
        if(albums.isEmpty()){
            return null;
        }
        return albumRepository.findAll();
    }

    /**
     * Metodo para actualizar los datos de un álbum en MongoDB por su ID.
     *
     * @param id El identificador único del álbum a actualizar.
     * @param albumDTO Objeto que contiene los nuevos datos del álbum.
     * @throws IdExcepcion Si el ID proporcionado no pertenece a un álbum existente.
     */
    public void updateAlbumByIdService(String id, AlbumDTO albumDTO) {
        Album album = albumRepository.findByid(id);
        if(album != null){
            album.setTitulo(albumDTO.getTitulo());
            album.setData_lanzamento(albumDTO.getDataLanzamento());
            album.setPuntuacion(albumDTO.getPuntuacion());
            albumRepository.save(album);
        }
        else{
            throw new IdExcepcion("Este id no pertenece a un album");
        }
    }

    /**
     * Metodo privado para verificar si el ID de un grupo es válido en la base de datos.
     *
     * @param id El identificador del grupo a verificar.
     * @return true si el ID pertenece a un grupo existente, false en caso contrario.
     */
    private boolean getIdGrupo(String id){
        List<Grupo> grupoList = grupoRepository.findAll();
        for (Grupo grupo : grupoList) {
            if(id.equals(grupo.getId())){
                return true;
            }
        }
        return false;
    }

}