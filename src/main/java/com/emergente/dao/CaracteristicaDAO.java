package com.emergente.dao;

import com.emergente.modelo.Caracteristica;
import java.util.List;

public interface CaracteristicaDAO {

    public void insert(Caracteristica caracteristica) throws Exception;

    public void update(Caracteristica caracteristica) throws Exception;

    public void delete(int id) throws Exception;

    public Caracteristica getById(int id) throws Exception;

    public List<Caracteristica> getAll() throws Exception;
}
