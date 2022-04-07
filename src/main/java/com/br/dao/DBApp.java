package com.br.dao;

public class DBApp {
    public static DBConnection db;

    public static DBConnection getConnection(){

        if(db == null){
            try {
                db = new DBConnection("zfjgczrr", "w3OCd4WUkIzTSPQr8uMbdftKUsmZKxlb", "zfjgczrr", "tuffi.db.elephantsql.com", "5432");
                return db;
            } catch (DataBaseException e) {
                e.printStackTrace();
            }
        }

        return db;
    }

}
