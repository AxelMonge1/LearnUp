/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.imp;

import controllers.IModelController;
import dao.IModelDAO;
import dao.imp.InstructorDAO;
import exceptions.DaoException;
import exceptions.EntityNotFoundException;
import java.util.List;
import model.Instructors;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class InstructorController implements IModelController<Instructors, ObjectId>{
    private final IModelDAO dao;

    public InstructorController() {
        this.dao = new InstructorDAO();
    }

    @Override
    public void create(Instructors entity) throws DaoException {
        dao.create(entity);
    }

    @Override
    public Instructors findById(ObjectId _id) throws EntityNotFoundException {
        return (Instructors) dao.findById(_id);
    }

    @Override
    public List<Instructors> findAll(int limit) throws EntityNotFoundException {
        return dao.findAll(limit);
    }

    @Override
    public void update(Instructors entity) throws DaoException {
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
    public List<Instructors> findByNombre(String nombre) throws EntityNotFoundException {
        return dao.findByNombre(nombre);
    }
}