package co.edu.uniquindio.poo.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.time.LocalDate;

public class Biblioteca {

    private String nombre;
    private LinkedList<Bibliotecario> listaBibliotecarios;
    private LinkedList<Libro> listaLibros;
    private HashMap<String, Prestamo> listaPrestamos;
    private HashMap<String, Estudiante> listaEstudiantes;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.listaBibliotecarios = new LinkedList<Bibliotecario>();
        this.listaLibros = new LinkedList<Libro>();
        this.listaPrestamos = new HashMap<String, Prestamo>();
        this.listaEstudiantes = new HashMap<String, Estudiante>();
        ;
    }

    /**
     * AÑADE un bibliotecario a la lista si no existe ya.
     * 
     * @param bibliotecario El bibliotecario a añadir.
     * @return Un mensaje indicando si el bibliotecario fue añadido correctamente o
     *         si ya existía.
     * @throws IllegalArgumentException
     */
    public String añadirBibliotecario(Bibliotecario bibliotecario) throws IllegalArgumentException{
        if (bibliotecario==null){
            throw new IllegalArgumentException("El bibliotecario no puede ser nulo");
        }
        if (listaBibliotecarios.contains(bibliotecario)){
            return "El bibliotecario ya existe";
        }
        listaBibliotecarios.add(bibliotecario);
        return "Bibliotecario añadido correctamente";

    }

    /**
     * ELIMINA un bibliotecario de la lista si existe.
     * 
     * @param bibliotecario El bibliotecario a eliminar.
     * @return Un mensaje indicando si el bibliotecario fue eliminado correctamente
     *         o si no existía.
     * @throws IllegalArgumentException
     */
    public String eliminarBibliotecario(Bibliotecario bibliotecario) throws IllegalArgumentException{
        if (bibliotecario==null){
            throw new IllegalArgumentException("El Bibliotecario no puede ser nulo");
        }
        if(!listaBibliotecarios.contains(bibliotecario)){
            return "El Bibliotecario no existe";
        }
        listaBibliotecarios.remove(bibliotecario);
            return "Bibliotecario eliminado correctamente";
    }

    /**
     *  BUSCA un bibliotecario en la lista.
     * 
     * @param bibliotecarioBuscar El bibliotecario a buscar.
     * @return El bibliotecario encontrado o null si no se encuentra en la lista.
     * @throws IllegalArgumentException
     */
    public Bibliotecario buscarBibliotecario(Bibliotecario bibliotecarioBuscar) throws IllegalArgumentException{
        if (bibliotecarioBuscar==null){
            throw new IllegalArgumentException("El bibliotecario no puede ser nulo");
        }
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            if(bibliotecario.equals(bibliotecarioBuscar))
            return bibliotecarioBuscar;
        }
        return null;
    }

    /**
     * EDITA un bibliotecario existente en la lista reemplazándolo por uno nuevo.
     * 
     * @param bibliotecario      El bibliotecario actual que se desea editar.
     * @param nuevoBibliotecario El nuevo bibliotecario con la información
     *                           actualizada.
     * @return Un mensaje indicando si el bibliotecario fue encontrado y editado o
     *         no.
     */
    public String editarBibliotecario(Bibliotecario bibliotecario, Bibliotecario nuevBibliotecario) {
        String mensaje = "No se encontró el elemento";
        if (buscarBibliotecario(bibliotecario) != null) {
            listaBibliotecarios.set(listaBibliotecarios.indexOf(bibliotecario), nuevBibliotecario);
        }
        return mensaje;
    }

    // CRUD ESTUDIANTE

    /**
     * Añade un estudiante a la lista si no existe ya.
     * 
     * @param estudiante El estudiante a añadir.
     * @return Un mensaje indicando si el estudiante fue añadido correctamente o si
     *         ya existía.
     */
    public String añadirEstudiante(Estudiante estudiante) {
        String mensaje = "Estudiante ya existe";
        if (listaEstudiantes.containsValue(estudiante) == false) {
            listaEstudiantes.put(estudiante.getId(), estudiante);
            mensaje = "Estudiante añadido exitosamente";
        }

        return mensaje;
    }

    /**
     * Elimina un estudiante de la lista si existe.
     * 
     * @param id El ID del estudiante a eliminar.
     * @return Un mensaje indicando si el estudiante fue eliminado correctamente o
     *         si no existía.
     */
    public String eliminarEstudiante(String id) {
        String mensaje = "Estudiante no existe";
        if (listaEstudiantes.get(id) != null) {
            listaEstudiantes.remove(id);
            mensaje = "Estudiante eliminado correctamente";
        }

        return mensaje;
    }

    /**
     * Busca un estudiante en la lista por su ID.
     * 
     * @param id El ID del estudiante a buscar.
     * @return El estudiante encontrado o null si no se encuentra en la lista.
     */
    public Estudiante buscarEstudianteId(String id) {
        return listaEstudiantes.get(id);
    }

    /**
     * Edita un estudiante existente en la lista reemplazándolo por uno nuevo.
     * 
     * @param id              El ID del estudiante actual que se desea editar.
     * @param estudianteNuevo El nuevo estudiante con la información actualizada.
     * @return Un mensaje indicando si el estudiante fue encontrado y editado o no.
     */
    public String editarEstudiante(String id, Estudiante estudianteNuevo) {
        String mensaje = "No se encontró";
        if (buscarEstudianteId(id) != null) {
            listaEstudiantes.put(id, estudianteNuevo);
            mensaje = "Elemento editado correctamente";
        }
        return mensaje;
    }

    // CRUD PRESTAMO


    /**
     * Añade un préstamo a la lista si no existe ya.
     * 
     * @param prestamo El préstamo a añadir.
     * @return Un mensaje indicando si el préstamo fue añadido correctamente o si ya
     *         existía.
     */
    public String añadirPrestamo(Prestamo prestamo, Bibliotecario bibliotecario, Estudiante estudiante) {
        String mensaje = "";
        if (!listaPrestamos.containsValue(prestamo)) {
            listaPrestamos.put(prestamo.getCodigo(), prestamo);
            bibliotecario.getListaPretamos().add(prestamo);
            estudiante.getListaPretamos().add(prestamo);
            
            mensaje = "Prestamo añadido exitosamente";
        }
        return mensaje;
    } 

    /**
     * Elimina un préstamo de la lista si existe.
     * 
     * @param codigo El código del préstamo a eliminar.
     * @return Un mensaje indicando si el préstamo fue eliminado correctamente o si
     *         no existía.
     */
    public String eliminarPrestamo(String codigo, Bibliotecario bibliotecario, Estudiante estudiante) {
        String mensaje = "Prestamo no existe";
        if (listaPrestamos.get(codigo) == null) {
            listaPrestamos.remove(codigo);
            bibliotecario.getListaPretamos().remove(listaPrestamos.get(codigo));
            estudiante.getListaPretamos().remove(listaPrestamos.get(codigo));
            
            mensaje = "Prestamo eliminado correctamente";
        }

        return mensaje;
    }

    /**
     * Busca un préstamo en la lista por su código.
     * 
     * @param codigo El código del préstamo a buscar.
     * @return El préstamo encontrado o null si no se encuentra en la lista.
     */
    public Prestamo buscarPrestamoCodigo(String codigo) {
        return listaPrestamos.get(codigo);
    }

    /**
     * Edita un préstamo existente en la lista reemplazándolo por uno nuevo.
     * 
     * @param codigo        El código del préstamo actual que se desea editar.
     * @param prestamoNuevo El nuevo préstamo con la información actualizada.
     * @return Un mensaje indicando si el préstamo fue encontrado y editado o no.
     */

    public String editarPrestamo(String codigo, Prestamo prestamoNuevo) {
        String mensaje = "No se encontró";
        if (buscarEstudianteId(codigo) != null) {
            listaPrestamos.put(codigo, prestamoNuevo);
            mensaje = "Elemento editado correctamente";
        }
        return mensaje;
    }

     


    //OTROS METODOS
    
    /**
     * busca un libro por su isbn
     * @param isbn
     * @return
     */
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }


    /**
     * busca un libro por su codigo
     * @param codigo
     * @return
     */
    public Libro buscarLibroCodigo(String codigo){
        for (int index = 0; index < listaLibros.size(); index++) {
            String codigoaux = listaLibros.get(index).getCodigo();
            if (codigo.equals(codigoaux)) {
                return listaLibros.get(index);
            }
        }
        return null;
    }

    /**
     * busca un libro por su nombre
     * @param nombre
     * @return
     */
    public Libro buscarLibroNombre(String nombre){
        for (Libro libroaux : listaLibros) {
            if (libroaux.getTitulo().equals(nombre)) {
                return libroaux;
            }
        }
        return null;
    }
    
    /** 3.3 Consultar dado el nombre del Libro la cantidad de préstamos en el cual está incluido, es decir si un Libro está incluido en dos préstamos la respuesta sería 2).
     * @param nombre
     * @return
     */

    public int cantidadPrestamosLibro(String nombre){
        int numeroPrestamos = 0; 
        for (Prestamo prestamo : listaPrestamos.values()) {
            for (DetallePrestamo detalle : prestamo.getListaDetallePrestamos().values()) {
                Libro libro = buscarLibroPorIsbn(detalle.getIsbn());
                if (libro.getTitulo().equalsIgnoreCase(nombre)) {
                    numeroPrestamos++;
                }
            } 
        }
        
        return numeroPrestamos;
    }
    

    public void entregarPrestamo(){
        
    }

    /**
     * 4.4 Consultar datos de un prestamo dado su codigo
     * @param codigoPrestamo
     * @return
     */
    public String datosPrestamoSegunCodigo(String codigoPrestamo){
        Prestamo prestamo = listaPrestamos.get(codigoPrestamo);
        return prestamo.toString();
    }

    /**
     * 4.5 Mostrar la cantidad de prestamos realizados por cada empleado
     */
    public void mostrarCantidadPrestamosCdaBibliotecarios(){
        String mensaje="Bibliotecarios con su respectivo numero de prestamos: \n";
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            int numeroPrestamos = bibliotecario.getListaPretamos().size();
            String nombreBibliotecario = bibliotecario.getNombre();
            mensaje+= nombreBibliotecario +": "+ numeroPrestamos + "\n";
        }

        System.out.println(mensaje);
    }


    /**
     * 5.1 datos del estudiante con mas prestamos(sin importar que libro)
     * @return String con los datos del estudiante con mas prestamos
     */
    public String estudianteMasPrestamos(){
        Estudiante estudianteMasPrestamos = null;
        int numeroMasPrestamos = 0;
        for (Estudiante estudiante : listaEstudiantes.values()) {
            int numeroPrestamos = estudiante.getListaPretamos().size();
            if (numeroPrestamos>numeroMasPrestamos){
                numeroMasPrestamos = numeroPrestamos;
                estudianteMasPrestamos = estudiante;
            }
        }
        if (estudianteMasPrestamos==null){
            return "No existen prestamos";
        }else{
            return (estudianteMasPrestamos.toString());
        }
        
    }

    /**
     * 
     * @param codigoPrestamo
     * @return Total de un prestamo
     */
    public double calcularTotalPrestamo(String codigoPrestamo){
        double total = 0;
        Prestamo prestamoaux = listaPrestamos.get(codigoPrestamo);
        HashMap <String, DetallePrestamo>listaDetalles = prestamoaux.getListaDetallePrestamos();

        for (DetallePrestamo detalle : listaDetalles.values()) {
            double n = detalle.getSubTotal();
            total+= n;
        }
        return total;
    }
    
    /**
     * 5.2 total de dinero recaudado por la empresa
     * @return double total de dinero recaudado por la empresa
     */
    public double dinero(){
        double totalDinero = 0;
        for (Prestamo prestamo : listaPrestamos.values()) {
            double n = prestamo.getTotal();
            totalDinero += n;
        }
        
        return totalDinero;
    }


    /**
     * 5.3 dinero a pagar salarios
     * @return Salario total de todos los bibliotecarios.
     */
    public double pagarSalarios(){
        double salarios= 0;
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            salarios += pagarBibliotecario(bibliotecario);
        }
        return salarios;
    }
 
    /**
     * 
     * @param bibliotecario
     * @return Sueldo de un bibliotecario.
     */
    public double pagarBibliotecario(Bibliotecario bibliotecario){
        int añosAntiguedad = LocalDate.now().getYear() - bibliotecario.getFechaContratacion().getYear();
        double sueldoEmpleado=0;
        for (Prestamo prestamo : bibliotecario.getListaPretamos()) {
            double valorPrestamo = prestamo.getTotal();
            double porcentajeEdadAumento = añosAntiguedad*0.02;
            sueldoEmpleado += (valorPrestamo*0.2)+(valorPrestamo*(porcentajeEdadAumento));
            
        }
        return sueldoEmpleado;
    }



    // **Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Bibliotecario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public void setListaBibliotecarios(LinkedList<Bibliotecario> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }

    public LinkedList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(LinkedList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public HashMap<String, Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(HashMap<String, Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public HashMap<String, Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(HashMap<String, Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}