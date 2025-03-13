
import java.time.LocalDate;


/**
 * Clase DTO de album
 */
public class AlbumDTO {

    //atributos de clase
    private String id;
    private String grupoID;
    private String titulo;
    private LocalDate dataLanzamento;
    private float puntuacion;


    /**
     * Constructor de la clase
     * @param id el id del album
     * @param grupoID el id del grupo
     * @param titulo el titulo del album
     * @param dataLanzamento la fecha de lanzamiento
     * @param puntuacion la puntuacion del album
     */
    public AlbumDTO(String id, String grupoID, String titulo, LocalDate dataLanzamento, float puntuacion) {
        this.id = id;
        this.grupoID = grupoID;
        this.titulo = titulo;
        this.dataLanzamento = dataLanzamento;
        this.puntuacion = puntuacion;
    }

    public AlbumDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //getter y setter
    public String getGrupoID() {
        return grupoID;
    }

    public void setGrupoID(String grupoID) {
        this.grupoID = grupoID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataLanzamento() {
        return dataLanzamento;
    }

    public void setDataLanzamento(LocalDate dataLanzamento) {
        this.dataLanzamento = dataLanzamento;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }
}