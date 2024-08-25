package Dao;

import Exception.CriminalException;
import model.Criminal;

public interface Criminaldao {

    public Criminal criminal_data(Criminal criminal) throws CriminalException;
    public Criminal search_data(int criminal_id) throws CriminalException;
    public void delete_criminal_data(int criminal_id) throws CriminalException;
}
