import com.example.AD.mongoService.model.entity.Grupo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la clase de grupos
 */
@Repository
public interface GrupoRepository extends MongoRepository<Grupo, String> {

    //busqueda de grupo por id
    Grupo findByid(String id);

}