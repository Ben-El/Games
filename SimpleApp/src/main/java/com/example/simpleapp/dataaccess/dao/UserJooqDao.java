package com.example.simpleapp.dataaccess.dao;

import com.example.simpleapp.dataaccess.entities.User;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import java.util.List;

@Repository
public class UserJooqDao {
    private final DSLContext dslContext;
    private static final String USERS_TABLE = "users";

    @Autowired
    public UserJooqDao(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<User> getAllUsers() {
        return dslContext.select().from(USERS_TABLE).fetchInto(User.class);
    }

    public List<String> getAllSurnames() {
        return dslContext.select(field("surname")).from(USERS_TABLE).fetchInto(String.class);
    }

    public void insertUser(User user) {
        dslContext.insertInto(table(USERS_TABLE))
                .columns(field("id"), field("name"), field("surname"))
                .values(user.getId(), user.getName(), user.getSurname())
                .execute();
    }
}