package Dao;

import Exception.CrimeException;
import model.Crime;

public interface Crimedao {

    public Crime crime_data(Crime crime) throws CrimeException;
    public void update_crime_status(int crime_id, String status) throws CrimeException;
    public void search_crime_report(int crime_id) throws CrimeException;
    public void generate_monthly_report(int month) throws CrimeException;
}
