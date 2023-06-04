package com.sid.CRUD.App.service;

import com.example.generated.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Crudapp;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudappService {

    @Autowired
    private DSLContext dslContext;

    public void insert(Crudapp person) {
        dslContext.insertInto(Tables.CRUDAPP_, Tables.CRUDAPP_.NAME, Tables.CRUDAPP_.AGE).values(person.getName(), person.getAge()).execute();
    }

    public List<Crudapp> read() {
        return dslContext.selectFrom(Tables.CRUDAPP_).fetchInto(Crudapp.class);
    }

    public void update(String name, int newAge) {
        dslContext.update(Tables.CRUDAPP_).set(Tables.CRUDAPP_.AGE, newAge).where(Tables.CRUDAPP_.NAME.eq(name)).execute();
    }

    public void delete(String name) {
        dslContext.deleteFrom(Tables.CRUDAPP_).where(Tables.CRUDAPP_.NAME.eq(name)).execute();
    }
}
