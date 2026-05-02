/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package app;

import config.MongoClientProvider;
import controllers.imp.InstructorController;
import model.Instructors;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class LearnUp {

    public static void main(String[] args) {
        MongoClientProvider.INSTANCE.init();
        InstructorController controller = new InstructorController();

        try {
            //create
            Instructors nuevo = new Instructors();
            nuevo.setName("Alan Turing"); 
            controller.create(nuevo);
            ObjectId idAsignado = nuevo.getId();
            System.out.println("Instructor registrado con exito. ID: " + idAsignado);
            //findById
            Instructors buscado = controller.findById(idAsignado);
            System.out.println("Datos recuperados: " + buscado.getName());
            //update
            if (buscado != null) {
                buscado.setName("Pepe");
                controller.update(buscado);
                System.out.println("El instructor ha sido modificado.");
            }
            //FindAll
            System.out.println("Catalogo actual de instructores:");
            controller.findAll(100).forEach(i -> 
                System.out.println(" - Nombre: " + i.getName()+ " Id: " + i.getId())
            );
            //deleteById
            controller.deleteById(idAsignado);
            System.out.println("Registro eliminado del sistema.");

        } catch (Exception e) {
            System.err.println("Error en el sistema de control: " + e.getMessage());
        }
    }
}
