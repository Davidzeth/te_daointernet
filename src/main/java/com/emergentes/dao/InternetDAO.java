package com.emergentes.dao;

import com.emergentes.modelo.Internet;
import java.util.List;

public interface InternetDAO {
    public void insert(Internet internet) throws Exception;
    public void update(Internet internet) throws Exception;
    public void delete(int id) throws Exception;
    public List<Internet> getAll() throws Exception;
    public Internet getById(int id) throws Exception;
}
