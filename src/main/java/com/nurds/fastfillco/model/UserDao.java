package com.nurds.fastfillco.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * This class is used to access data for the User entity.
 * Repository annotation allows the component scanning support to find and 
 * configure the DAO wihtout any XML configuration and also provide the Spring 
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class UserDao {
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * Save the user in the database.
   */
  public void create(Doctor doctor) {
   entityManager.persist(doctor);
    return;
  }
  public void update(Doctor doctor) {
	   entityManager.merge(doctor);
	    return;
	  }
  public void updateMr(MedicalRep doctor) {
	   entityManager.merge(doctor);
	    return;
	  }
  
  public Doctor getLocation(String label,String userName) {
	  return (Doctor) entityManager.createQuery(
		        "from Doctor d join d.locations loc where d.username = :username and loc.label = :label")
		        .setParameter("username", userName)
		        .setParameter("label", label)
		        .getSingleResult();
  }
 
  public void createMr(MedicalRep mr) {
	   entityManager.persist(mr);
	    return;
	  }
  public void createLocation(Location mr) {
	  System.out.println(mr);
	   entityManager.persist(mr);
	    return;
	  }
  /**
   * Delete the user from the database.
   */
  public void delete(Doctor user) {
    if (entityManager.contains(user))
      entityManager.remove(user);
    else
      entityManager.remove(entityManager.merge(user));
    return;
  }
  
  /**
   * Return all the users stored in the database.
   */
  @SuppressWarnings("unchecked")
  public List<String> getAllDoc() {
    return entityManager.createQuery("select username from Doctor").getResultList();
  }
  
  @SuppressWarnings("unchecked")
  public List<MasterMedication> getMedication() {
    return entityManager.createQuery("from MasterMedication").getResultList();
  }
  
  @SuppressWarnings("unchecked")
  public void putMedication(MasterMedication med) {
    entityManager.persist(med);
  }
  
  @SuppressWarnings("unchecked")
  public List<Doctor> getAll() {
    return entityManager.createQuery("from Doctor").getResultList();
  }
  
  @SuppressWarnings("unchecked")
  public List<String> getAllMr() {
    return entityManager.createQuery("select username from MedicalRep").getResultList();
  }
  
  /**
   * Return the user having the passed email.
   */
  public Doctor login(String username,String password) {
    return (Doctor) entityManager.createQuery(
        "from Doctor where username = :username and password = :password")
        .setParameter("username", username)
        .setParameter("password", password)
        .getSingleResult();
  }

  public MedicalRep loginMr(String username,String password) {
	    return (MedicalRep) entityManager.createQuery(
	        "from MedicalRep where username = :username and password = :password")
	        .setParameter("username", username)
	        .setParameter("password", password)
	        .getSingleResult();
	  }
  public Doctor getDoctor(String username) {
	    return (Doctor) entityManager.createQuery(
	        "from Doctor where username = :username ")
	        .setParameter("username", username)
	        .getSingleResult();
	  }
  
  public Location getLocation(long id) {
	    return (Location) entityManager.createQuery(
	        "from Location where id = :id ")
	        .setParameter("id", id)
	        .getSingleResult();
	  }
  

  public MedicalRep getMr(String username) {
	    return (MedicalRep) entityManager.createQuery(
	        "from MedicalRep where username = :username ")
	        .setParameter("username", username)
	        .getSingleResult();
	  }
	  

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;
  
} // class UserDao
