
package com.emergente.dao;

import com.emergente.modelo.Tipo;
import java.util.List;

public interface TipoDAO {
     public void insert(Tipo tipo) throws Exception;

    public void update(Tipo tipo) throws Exception;

    public void delete(int id) throws Exception;

    public Tipo getById(int id) throws Exception;

    public List<Tipo> getAll() throws Exception;   
}
