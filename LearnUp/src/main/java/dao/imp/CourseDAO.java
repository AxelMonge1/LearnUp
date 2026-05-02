/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.imp;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import config.MongoClientProvider;
import dao.IModelDAO;
import exceptions.DaoException;
import exceptions.EntityNotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import model.Courses;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class CourseDAO implements IModelDAO<Courses, ObjectId>{
    private final MongoCollection<Courses> col;

    public CourseDAO() {
        this.col = MongoClientProvider.INSTANCE.getCollection("courses", Courses.class);
    }
    
    @Override
    public void create(Courses entity) throws DaoException{
        try{
            if(entity.getId() == null){
                entity.setId(new ObjectId());
            }
            entity.setCreatedAt(Instant.now());
            col.insertOne(entity);
        }catch(MongoException ex){
            throw new DaoException("No se logro insertar el curso");
        }
    }

    @Override
    public Courses findById(ObjectId _id) throws EntityNotFoundException{
        try{
            Courses c = col.find(Filters.eq("_id", _id)).first();
            if(c == null){
                throw new EntityNotFoundException("No existe un curso con el id dado");
            }
            return c;
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro encontrar el curso");
        }
    }

    @Override
    public List<Courses> findAll(int limit) throws EntityNotFoundException {
        try{
            return col.find().limit(limit).into(new ArrayList<>());
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro obtener la lista de cursos");
        }
    }

    @Override
    public void update(Courses entity) throws DaoException {
        try {
            col.updateOne(Filters.eq("_id", entity.getId()), Updates.combine(
                                                             Updates.set("title", entity.getTitle()),
                                                             Updates.set("description", entity.getDescription()),
                                                             Updates.set("category", entity.getCategory()),
                                                             Updates.set("instructorId", entity.getInstructorId()),
                                                             Updates.set("price", entity.getPrice()),
                                                             Updates.set("rating", entity.getRating()),
                                                             Updates.set("tags", entity.getTags()),
                                                             Updates.set("modules", entity.getModules()),
                                                             Updates.set("updatedAt", Instant.now())
            ));
        } catch (MongoException ex) {
            throw new DaoException("No se logro actualizar el curso");
        }
    }

    @Override
    public void deleteById(ObjectId _id) throws EntityNotFoundException, DaoException {
        try {
            var result = col.deleteOne(Filters.eq("_id", _id));
            if(result.getDeletedCount() == 0){
                throw new EntityNotFoundException("No se encontro el curso con el id dado");
            }
        } catch (MongoException ex) {
            throw new DaoException("No se logro eliminar el producto");
        }
    }

    @Override
    public void deleteAll() throws DaoException {
        try {
            var result = col.deleteMany(new Document());
            if(result.getDeletedCount() == 0){
                throw new DaoException("No se logro eliminar los cursos");
            }
        } catch (MongoException ex) {
            throw new DaoException("No se logro eliminar los cursos");
        }
    }

    @Override
    public List<Courses> findByNombre(String nombre) throws EntityNotFoundException {
        try{
            List<Courses> lista = col.find(Filters.regex("title", nombre)).into(new ArrayList());
            return lista;
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro encontrar los cursos");
        }
    }   
}