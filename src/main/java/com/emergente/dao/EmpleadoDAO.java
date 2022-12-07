
package com.emergente.dao;

import com.emergente.modelo.Empleado;
import java.util.List;

public interface EmpleadoDAO {
    public void insert(Empleado empleado) throws Exception;

    public void update(Empleado empleado) throws Exception;

    public void delete(int id) throws Exception;

    public Empleado getById(int id) throws Exception;

    public List<Empleado> getAll() throws Exception;
}
