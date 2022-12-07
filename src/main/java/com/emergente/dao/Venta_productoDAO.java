
package com.emergente.dao;

import com.emergente.modelo.Venta_producto;
import java.util.List;

public interface Venta_productoDAO {
    public void insert(Venta_producto venta_producto) throws Exception;

    public void update(Venta_producto venta_producto) throws Exception;

    public void delete(int id) throws Exception;

    public Venta_producto getById(int id) throws Exception;

    public List<Venta_producto> getAll() throws Exception;   
}
