package todo;

/**
 * Clase que da un id a un usuario
 * @Author: Andres Alvarez, Sebastian Vidal
 * @Version: 1.0
 * @Since: 19/06/2024
 */
public record Id (String id)  {
    /**
     * Compara el id con otro id
     * @param id Id a comparar
     * @return boolean True si son iguales, False si no
     */
    public boolean compareId(Id id){
        return this.id.equals(id.id());
    }
}
