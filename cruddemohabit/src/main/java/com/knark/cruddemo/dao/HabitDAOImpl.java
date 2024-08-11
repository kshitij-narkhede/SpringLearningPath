package com.knark.cruddemo.dao;

import com.knark.cruddemo.entity.Habit;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HabitDAOImpl implements HabitDAO {

    private final EntityManager entityManager;

    @Autowired
    public HabitDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Habit habit) {
        entityManager.persist(habit);
    }
}
