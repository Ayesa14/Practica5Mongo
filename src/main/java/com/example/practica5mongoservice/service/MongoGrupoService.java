package com.example.practica5mongoservice.service;

import com.example.practica5mongoservice.model.entity.Grupo;

import java.util.List;

/**
 * Servicio de mongo para el grupo
 */
@Service
public class MongoGrupoService {

    //variable del repositorio
    public final GrupoRepository grupoRepository;

    /**
     * Constructor de la clase
     * @param grupoRepository el repositorio de los grupos
     */
    public MongoGrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    /**
     * Metodo que crea un grupo en la base de datos
     * @param grupoDTO el grupo dto
     */
    public void crearGrupo(GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo(grupoDTO.getId(), grupoDTO.getNome(),
                grupoDTO.getXenero(), grupoDTO.getDataFormacion());
        grupoRepository.save(grupo);

    }

    /**
     * Metodo que devuelve todos los grupos de la base de datos
     *
     * @return la lista de grupos
     */
    public List<Grupo> getListGrupo(){
        List<Grupo> grupos = grupoRepository.findAll();
        if(grupos.isEmpty()){
            return null;
        }
        return grupoRepository.findAll();
    }

    /**
     * Metodo que devuelve un grupo por su id
     * @param id el id del grupo a buscar
     * @return el grupo o nada
     */
    public Grupo getListGrupoById(String id){
        Grupo grupo = grupoRepository.findByid(id);
        if(grupo == null){
            return null;
        }
        return grupoRepository.findByid(id);
    }

    /**
     * Metodo para borrar un grupo por id
     * @param id el is del grupo
     */
    public void deleteByIdService(String id){
        Grupo grupo = grupoRepository.findByid(id);
        if(grupo == null){
            throw new IdExcepcion("Este id no existe para borrar un grupo");
        }
        grupoRepository.deleteById(id);
    }

    /**
     * Metodo para actualizar un grupo por su id
     * @param id el id del grupo
     * @param grupoDTO el grupo con los datos actualizados
     */
    public void updateByIdService(String id, GrupoDTO grupoDTO){
        Grupo grupo = grupoRepository.findByid(id);
        if(grupo == null){
            throw new IdExcepcion("Este id no existe para actualizar un grupo");
        }
        grupo.setNome(grupoDTO.getNome());
        grupo.setXenero(grupoDTO.getXenero());
        grupo.setDataFormacion(grupoDTO.getDataFormacion());
        grupoRepository.save(grupo);
    }
}