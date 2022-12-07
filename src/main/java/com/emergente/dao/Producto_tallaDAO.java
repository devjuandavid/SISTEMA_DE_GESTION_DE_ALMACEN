
package com.emergente.dao;

import com.emergente.modelo.Producto_talla;
import java.util.List;

public interface Producto_tallaDAO {
       public void insert(Producto_talla producto_talla) throws Exception;

    public void update(Producto_talla producto_talla) throws Exception;

    public void delete(int id) throws Exception;

    public Producto_talla getById(int id) throws Exception;

    public List<Producto_talla> getAll() throws Exception; 
}
