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
import model.Students;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class StudentDAO implements IModelDAO<Students, ObjectId>{
    private final MongoCollection<Students> col;

    public StudentDAO() {
        this.col = MongoClientProvider.INSTANCE.getCollection("students", Students.class);
    }

    @Override
    public void create(Students entity) throws DaoException {
        try{
            if(entity.getId() == null){
                entity.setId(new ObjectId());
            }
            entity.setCreatedAt(Instant.now());
            col.insertOne(entity);
        }catch(MongoException ex){
            throw new DaoException("No se logro insertar el estudiante");
        }
    }

    @Override
    public Students findById(ObjectId _id) throws EntityNotFoundException {
        try{
            Students s = col.find(Filters.eq("_id", _id)).first();
            if(s == null){
                throw new EntityNotFoundException("No existe un estudiante con el id dado");
            }
            return s;
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro encontrar el estudiante");
        }
    }

    @Override
    public List<Students> findAll(int limit) throws EntityNotFoundException {
        try{
            return col.find().limit(limit).into(new ArrayList<>());
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro obtener la lista de estudiantes");
        }
    }

    @Override
    public void update(Students entity) throws DaoException {
        try {
            col.updateOne(Filters.eq("_id", entity.getId()), Updates.combine(
                                                             Updates.set("name", entity.getName()),
                                                             Updates.set("email", entity.getEmail()),
                                                             Updates.set("enrolledCourses", entity.getEnrolledCourses()),
                                                             Updates.set("interests", entity.getInterests()),
                                                             Updates.set("settigs", entity.getSettings()),
                                                             Updates.set("updatedAt", Instant.now())
            ));
        } catch (MongoException ex) {
            throw new DaoException("No se logro actualizar el estudiante");
        }
    }

    @Override
    public void deleteById(ObjectId _id) throws EntityNotFoundException, DaoException {
        try {
            var result = col.deleteOne(Filters.eq("_id", _id));
            if(result.getDeletedCount() == 0){
                throw new EntityNotFoundException("No se encontro el estudiante con el id dado");
            }
        } catch (MongoException ex) {
            throw new DaoException("No se logro eliminar el estudiante");
        }
    }

    @Override
    public void deleteAll() throws DaoException {
        try {
            var result = col.deleteMany(new Document());
            if(result.getDeletedCount() == 0){
                throw new DaoException("No se logro eliminar los estudiantes");
            }
        } catch (MongoException ex) {
            throw new DaoException("No se logro eliminar los estudiantes");
        }
    }

    @Override
    public List<Students> findByNombre(String nombre) throws EntityNotFoundException {
        try{
            List<Students> lista = col.find(Filters.regex("name", nombre)).into(new ArrayList());
            return lista;
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro encontrar los estudiantes");
        }
    }   
}