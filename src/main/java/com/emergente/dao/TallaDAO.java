package com.emergente.dao;

import com.emergente.modelo.Talla;
import java.util.List;

public interface TallaDAO {

    public void insert(Talla talla) throws Exception;

    public void update(Talla talla) throws Exception;

    public void delete(int id) throws Exception;

    public Talla getById(int id) throws Exception;

    public List<Talla> getAll() throws Exception;
}
