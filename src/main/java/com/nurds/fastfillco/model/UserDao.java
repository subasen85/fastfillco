package com.nurds.fastfillco.model;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

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
	@Autowired
	private Environment env;
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
 
  public boolean isMrRepExist(String username) {
		Long count = (Long) entityManager.createQuery(
		        "SELECT  COUNT (*) from MedicalRep where LOWER(username) = :username")
		        .setParameter("username", username)
		        .getSingleResult();
		System.err.println("username="+username+"&count="+count);
		if(count>0){
			return true;
		}
		return false;
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
        "from Doctor where LOWER(username) = :username and password = :password")
        .setParameter("username", username.toLowerCase())
        .setParameter("password", password)
        .getSingleResult();
  }

  public MedicalRep loginMr(String username,String password) {
	    return (MedicalRep) entityManager.createQuery(
	        "from MedicalRep where LOWER(username) = :username and password = :password")
	        .setParameter("username", username.toLowerCase())
	        .setParameter("password", password)
	        .getSingleResult();
	  }
  public Doctor getDoctor(String username) {
	    return (Doctor) entityManager.createQuery(
	        "from Doctor where LOWER(username) = :username ")
	        .setParameter("username", username.toLowerCase())
	        .getSingleResult();
	  }
  
  public Admin getAdmin(String username) {
	    return (Admin) entityManager.createQuery(
	        "from Admin where LOWER(username) = :username ")
	        .setParameter("username", username.toLowerCase())
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
	        "from MedicalRep where LOWER(username) = :username ")
	        .setParameter("username", username.toLowerCase())
	        .getSingleResult();
	  }
	  

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;


public String passwordReset(String username, String newPassword, boolean isDoctor) {
	if(isDoctor){
		Doctor doctor= (Doctor) entityManager.createQuery(
		        "from Doctor where LOWER(username) = :username")
		        .setParameter("username", username.toLowerCase())
		        .getSingleResult();
		doctor.setPassword(newPassword);
		if(entityManager.merge(doctor)!=null){
			if(doctor.getLastName() != null){
				return doctor.getFirstName()+" "+doctor.getLastName();	
			}
			return doctor.getFirstName();
		}
	}else{
		MedicalRep medicalRep = (MedicalRep) entityManager.createQuery(
		        "from MedicalRep where LOWER(username) = :username")
		        .setParameter("username", username.toLowerCase())
		        .getSingleResult();
		medicalRep.setPassword(newPassword);
		if(entityManager.merge(medicalRep)!=null){
			if(medicalRep.getLastName() != null){
				return medicalRep.getFirstName()+" "+medicalRep.getLastName();	
			}
			return medicalRep.getFirstName();
		}
	}
	return null;
}

	public boolean sendEmail(String toEmail, String subject,String content) {
		System.out.println("toEmail="+toEmail+";subject="+subject+";content="+content);
		String sendgrid_apikey = env.getProperty("sendgrid_apikey");
		SendGrid sendgrid = new SendGrid(sendgrid_apikey);
		Email from = new Email("doccloset@docloset.com");
		Email to = new Email(toEmail);
		Content msgContent = new Content("text/plain", content);
		Mail mail = new Mail(from, subject, to, msgContent);
		Request request = new Request();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		try {
			request.setBody(mail.build());
			Response response = sendgrid.api(request);
			System.out.println(response.getStatusCode());
			if(response!=null && response.getStatusCode()>=200 && response.getStatusCode()<300){
				return true;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
		return false;
	}
	
	/* Admin Registration **/
	 public void registerAdmin(Admin admin) {
		  System.out.println(admin);
		  Long count = (Long) entityManager.createQuery(
			        "SELECT  COUNT (*) from Admin")
			        .getSingleResult();
		  if(count > 0){
			  admin.setSuperadmin(false);
			  admin.setStatus(false);

		  }else{
			  admin.setSuperadmin(true);
			  admin.setStatus(true);
		  }
		System.out.println("count="+count);
		entityManager.persist(admin);
		
		    return;
		  }
	 
	 /* Admin Login **/
	 public Admin loginAdmin(String username,String password) {
		    return (Admin) entityManager.createQuery(
		        "from Admin where LOWER(username) = :username and password = :password")
		        .setParameter("username", username.toLowerCase())
		        .setParameter("password", password)
		        .getSingleResult();
		  }
	 
	 
} // class UserDao
