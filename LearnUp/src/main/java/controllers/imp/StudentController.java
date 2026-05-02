/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.imp;

import controllers.IModelController;
import dao.IModelDAO;
import dao.imp.StudentDAO;
import exceptions.DaoException;
import exceptions.EntityNotFoundException;
import java.util.List;
import model.Students;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class StudentController implements IModelController<Students, ObjectId>{
    private final IModelDAO dao;

    public StudentController() {
        this.dao = new StudentDAO();
    }

    @Override
    public void create(Students entity) throws DaoException {
        dao.create(entity);
    }

    @Override
    public Students findById(ObjectId _id) throws EntityNotFoundException {
        return (Students) dao.findById(_id);
    }

    @Override
    public List<Students> findAll(int limit) throws EntityNotFoundException {
        return dao.findAll(limit);
    }

    @Override
    public void update(Students entity) throws DaoException {
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
    public List<Students> findByNombre(String nombre) throws EntityNotFoundException {
        return dao.findByNombre(nombre);
    }
}