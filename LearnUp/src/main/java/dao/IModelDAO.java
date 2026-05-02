/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.DaoException;
import exceptions.EntityNotFoundException;
import java.util.List;

/**
 *
 * @author axelm
 */
public interface IModelDAO<T, ID> {
    void create(T entity) throws DaoException;
    T findById(ID _id) throws EntityNotFoundException;
    List<T> findAll(int limit) throws EntityNotFoundException;
    void update(T entity) throws DaoException;
    void deleteById(ID _id) throws EntityNotFoundException, DaoException;
    void deleteAll() throws DaoException;
    List<T> findByNombre(String nombre) throws EntityNotFoundException;
}
