package com.madhan.restapp.repoimpl;

import com.madhan.restapp.model.Supplier;
import com.madhan.restapp.repo.SupplierRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SupplierRepoImpl implements SupplierRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Supplier supplier) {
        try {
            entityManager.persist(supplier);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save supplier", e);
        }
    }

    @Override
    public Supplier findById(Long supplierId) {
        try {
            return entityManager.find(Supplier.class, supplierId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find supplier by ID", e);
        }
    }

    @Override
    public Supplier findByUsername(String username) {
        try {
            TypedQuery<Supplier> query = entityManager.createQuery(
                "SELECT s FROM Supplier s WHERE s.username = :username", Supplier.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Failed to find supplier by username", e);
        }
    }

    @Override
    public void update(Supplier supplier) {
        try {
            entityManager.merge(supplier);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update supplier", e);
        }
    }

    @Override
    public void delete(Long supplierId) {
        try {
            Supplier supplier = entityManager.find(Supplier.class, supplierId);
            if (supplier != null) {
                entityManager.remove(supplier);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete supplier", e);
        }
    }

    @Override
    public List<Supplier> findAll() {
        try {
            TypedQuery<Supplier> query = entityManager.createQuery("SELECT s FROM Supplier s", Supplier.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to find all suppliers", e);
        }
    }
}
