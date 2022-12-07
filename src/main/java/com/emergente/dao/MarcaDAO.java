
package com.emergente.dao;

import com.emergente.modelo.Marca;
import java.util.List;

public interface MarcaDAO {
    public void insert(Marca marca) throws Exception;

    public void update(Marca marca) throws Exception;

    public void delete(int id) throws Exception;

    public Marca getById(int id) throws Exception;

    public List<Marca> getAll() throws Exception;    
}
