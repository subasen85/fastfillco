package com.nurds.fastfillco.model;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

/*public boolean sendEmail(String toEmail, String subject,String content) {
System.out.println("toEmail="+toEmail+";subject="+subject+";content="+content);
SendGrid sendgrid = new SendGrid(env.getProperty("sendgrid_apikey"));
Email from = new Email("physician@fastfillco.com");
Email to = new Email(toEmail);
Content msgContent = new Content("text/plain", content);
Mail mail = new Mail(from, subject, to, msgContent);
Request request = new Request();
request.setMethod(Method.POST);
request.setEndpoint("mail/send");
try {
	request.setBody(mail.build());
	Response response = sendgrid.api(request);
	if(response!=null && response.getStatusCode()==200){
		return true;
	}
} catch (IOException e1) {
	e1.printStackTrace();
	return false;
}
return false;
<dependency>
    <groupId>com.sendgrid</groupId>
    <artifactId>sendgrid-java</artifactId>
    <version>4.0.1</version>
</dependency>
}*/

public boolean sendEmail(String toEmail, String subject,String content) {
	System.out.println("toEmail="+toEmail+";subject="+subject+";content="+content);
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
	final String username = "gmailusername@gmail.com";
	final String password = "gmailpassword";
	Session session = Session.getInstance(props,
	  new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	  });

	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(toEmail));
		message.setSubject(subject);
		message.setText(content);

		Transport.send(message);
		System.out.println("Email send successfully");
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
  
} // class UserDao
