package com.br.dao;

public class DBBook {

    private DBConnection connection;

    public DBBook() {
        try {
            this.connection = new DBConnection("zfjgczrr", "w3OCd4WUkIzTSPQr8uMbdftKUsmZKxlb", "zfjgczrr", "db.elephantsql.com", "5432");
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
    }



}
