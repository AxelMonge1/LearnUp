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
import model.Instructors;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class InstructorDAO implements IModelDAO<Instructors, ObjectId>{
    private final MongoCollection<Instructors> col;

    public InstructorDAO() {
        this.col = MongoClientProvider.INSTANCE.getCollection("instructors", Instructors.class);
    }
    
    @Override
    public void create(Instructors entity) throws DaoException {
        try{
            if(entity.getId() == null){
                entity.setId(new ObjectId());
            }
            entity.setCreatedAt(Instant.now());
            col.insertOne(entity);
        }catch(MongoException ex){
            throw new DaoException("No se logro insertar el instructor");
        }
    }

    @Override
    public Instructors findById(ObjectId _id) throws EntityNotFoundException {
        try{
            Instructors i = col.find(Filters.eq("_id", _id)).first();
            if(i == null){
                throw new EntityNotFoundException("No existe un instructor con el id dado");
            }
            return i;
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro encontrar el instructor");
        }
    }

    @Override
    public List<Instructors> findAll(int limit) throws EntityNotFoundException {
        try{
            return col.find().limit(limit).into(new ArrayList<>());
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro obtener la lista de instructores");
        }
    }

    @Override
    public void update(Instructors entity) throws DaoException {
        try {
            col.updateOne(Filters.eq("_id", entity.getId()), Updates.combine(
                                                             Updates.set("name", entity.getName()),
                                                             Updates.set("email", entity.getEmail()),
                                                             Updates.set("specialties", entity.getSpecialties()),
                                                             Updates.set("experienceYears", entity.getExperienceYears()),
                                                             Updates.set("bio", entity.getBio()),
                                                             Updates.set("contact", entity.getContact()),
                                                             Updates.set("coursesTaught", entity.getCoursesTaught()),
                                                             Updates.set("updatedAt", Instant.now())
            ));
        } catch (MongoException ex) {
            throw new DaoException("No se logro actualizar el instructor");
        }
    }

    @Override
    public void deleteById(ObjectId _id) throws EntityNotFoundException, DaoException {
        try {
            var result = col.deleteOne(Filters.eq("_id", _id));
            if(result.getDeletedCount() == 0){
                throw new EntityNotFoundException("No se encontro el instructor con el id dado");
            }
        } catch (MongoException ex) {
            throw new DaoException("No se logro eliminar el instructor");
        }
    }

    @Override
    public void deleteAll() throws DaoException {
        try {
            var result = col.deleteMany(new Document());
            if(result.getDeletedCount() == 0){
                throw new DaoException("No se logro eliminar los instructores");
            }
        } catch (MongoException ex) {
            throw new DaoException("No se logro eliminar los instructores");
        }
    }

    @Override
    public List<Instructors> findByNombre(String nombre) throws EntityNotFoundException {
        try{
            List<Instructors> lista = col.find(Filters.regex("name", nombre)).into(new ArrayList());
            return lista;
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro encontrar los instructores");
        }
    }
}