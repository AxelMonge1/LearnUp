/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.imp;

import controllers.IModelController;
import dao.IModelDAO;
import dao.imp.CourseDAO;
import exceptions.DaoException;
import exceptions.EntityNotFoundException;
import java.util.List;
import model.Courses;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class CourseController implements IModelController<Courses, ObjectId>{
    private final IModelDAO dao;

    public CourseController() {
        this.dao = new CourseDAO();
    }

    @Override
    public void create(Courses entity) throws DaoException {
        dao.create(entity);
    }

    @Override
    public Courses findById(ObjectId _id) throws EntityNotFoundException {
        return (Courses) dao.findById(_id);
    }

    @Override
    public List<Courses> findAll(int limit) throws EntityNotFoundException {
        return dao.findAll(limit);
    }

    @Override
    public void update(Courses entity) throws DaoException {
        dao.update(entity);
    }

    @Override
    public void deleteById(ObjectId _id) throws EntityNotFoundException, DaoException {
        dao.deleteById(_id);
    }

    @Override
    public void deleteAll() throws DaoException {
        dao.deleteAll();
    }

    @Override
    public List<Courses> findByNombre(String nombre) throws EntityNotFoundException {
        return dao.findByNombre(nombre);
    }
}
