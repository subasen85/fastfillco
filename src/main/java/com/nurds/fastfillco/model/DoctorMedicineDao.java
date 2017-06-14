package com.nurds.fastfillco.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nurds.fastfillco.DoctorMedicineRequest;

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
public class DoctorMedicineDao {
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * Save the user in the database.
   */
  public void create(DoctorMedicine medicine) {
   entityManager.persist(medicine);
    return;
  }
  
  public void createMrMedicine(MrMedicine medicine) {
	   entityManager.persist(medicine);
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
  
  public void delete(MrMedicine user) {
	    if (entityManager.contains(user))
	      entityManager.remove(user);
	    else
	      entityManager.remove(entityManager.merge(user));
	    return;
	  }
  
  public void delete(DoctorMedicine user) {
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
  public List<Doctor> getAll() {
    return entityManager.createQuery("from Doctor").getResultList();
  }
  
  public List<String> getAllClasses() {
	   return entityManager.createQuery("select DISTINCT name from MasterClass").getResultList();
	  }
  
  public List<String> getAllNames() {
	   return entityManager.createQuery("select DISTINCT name from MasterMedication").getResultList();
	  }
  
  public List<String> getAllSubClasses() {
	   return entityManager.createQuery("select DISTINCT name from MasterSubClass").getResultList();
	  }
  
  public void insertClass(MasterClass mClass) {
	   entityManager.persist(mClass);
	  }
  
  public void insertSubClass(MasterSubClass subClass) {
	   entityManager.persist(subClass);
	  }
  
  /**
   * Return the user having the passed email.
   */
  public List<DoctorMedicine> getMedicineDetails(String userName,long id,String user) {
    return entityManager.createQuery(
        "from DoctorMedicine where doctor.username = :username and location.id = :id and mr.username= :user")
        .setParameter("username", userName)
        .setParameter("id", id)
        .setParameter("user", user)
        .getResultList();
  }
  
  public List<DoctorMedicine> getMedicineDetails(String userName,long id) {
	    return entityManager.createQuery(
	        "from DoctorMedicine where doctor.username = :username and location.id = :id")
	        .setParameter("username", userName)
	        .setParameter("id", id)
	        .getResultList();
	  }
  
  
  
  public List<MrMedicine> getMrMedicineDetails(String userName) {
	    return entityManager.createQuery(
	        "from MrMedicine where mr.username = :username")
	        .setParameter("username", userName)
	        .getResultList();
	  }
  
  public List<MrMedicine> getMrMedicineDetail(String name) {
	    return entityManager.createQuery(
	        "from MrMedicine where medicineName = :name")
	        .setParameter("username", name)
	        .getResultList();
	  }
  
  public MrMedicine getMrMedicineDetail(long id) {
	    return (MrMedicine) entityManager.createQuery(
	        "from MrMedicine where id = :id")
	        .setParameter("id", id)
	        .getSingleResult();
	  }
  
  
  
  public List<MrMedicine> getallMrMedicineDetails() {
	    return entityManager.createQuery(
	        "from MrMedicine")
	        .getResultList();
	  }
  
  public void updateMedicineDetails(DoctorMedicine medicine) {
	  	DoctorMedicine med = getMedicineDetail(medicine.getId());
	  	if(medicine.getNumOfBoxes()!=null)
	  	med.setNumOfBoxes(medicine.getNumOfBoxes());
	  	if(medicine.getNumVoucher()!=null)
		  	med.setNumVoucher(medicine.getNumVoucher());
	  	if(medicine.getNumOfBoxes()!=null)
		  	med.setNumCoupons(medicine.getNumCoupons());
	    entityManager.merge(med);
	    return;
	  }

  public DoctorMedicine getMedicineDetail(long id) {
	    return (DoctorMedicine) entityManager.createQuery(
	        "from DoctorMedicine where id = :id")
	        .setParameter("id", id)
	        .getSingleResult();
	  }
  
  public MedicalRep getMedicalRep(String id) {
	    return (MedicalRep) entityManager.createQuery(
	        "from MedicalRep where username = :id")
	        .setParameter("id", id)
	        .getSingleResult();
	  }
  
  public int updateLoc(long id,String loc) {
	    return (int) entityManager.createQuery(
	        "update DoctorMedicine set locationSample = :loc where id = :id ")
	        .setParameter("loc",loc)
	        .setParameter("id", id).executeUpdate();
	  }


  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;


	public MrMedicine updateMrMedicine(MrMedicine medicine) {
		MrMedicine medicineDb = getMrMedicineDetail(medicine.getId());
		if(medicineDb == null){
			return null;
		}
		if(medicine.getCouponsExpiryDate()!=null){
			medicineDb.setCouponsExpiryDate(medicine.getCouponsExpiryDate());
		}
		if(medicine.getExpiryDate()!=null){
			medicineDb.setExpiryDate(medicine.getExpiryDate());
		}
		if(medicine.getmClass()!=null){
			medicineDb.setmClass(medicine.getmClass());
		}
		if(medicine.getMedicineName()!=null){
			medicineDb.setMedicineName(medicine.getMedicineName());
		}
		if(medicine.getNumPillPerBox()!=null){
			medicineDb.setNumPillPerBox(medicine.getNumPillPerBox());
		}
		if(medicine.getSubClass()!=null){
			medicineDb.setSubClass(medicine.getSubClass());
		}
		if(medicine.getVoucherExpiryDate()!=null){
			medicineDb.setVoucherExpiryDate(medicine.getVoucherExpiryDate());
		}
		if(medicine.getVoucherInsurance()!=null){
			medicineDb.setVoucherInsurance(medicine.getVoucherInsurance());
		}
		if(medicine.getDosage()!=null){
			medicineDb.setDosage(medicine.getDosage());
		}
		if(medicine.getCouponInsurance()!=null){
			medicineDb.setCouponInsurance(medicine.getCouponInsurance());
		}
		if(medicine.getVoucherPrice()!=null){
			medicineDb.setVoucherPrice(medicine.getVoucherPrice());
		}
		medicine = entityManager.merge(medicine);
		return medicine;
	}

	public MrMedicine isMrSourceExist(MrMedicine mrMedicine) {
		Long count = (Long) entityManager.createQuery(
		        "SELECT  COUNT (*) from MrMedicine where medicinename = :medicinename and expirydate = :expirydate and mclass = :mclass and subClass = :subClass")
				.setParameter("medicinename", mrMedicine.getMedicineName())
				.setParameter("expirydate", mrMedicine.getExpiryDate())
				.setParameter("mclass", mrMedicine.getmClass())
				.setParameter("subClass", mrMedicine.getSubClass())
		        .getSingleResult();
		if(count>0){
			MrMedicine mrMedicineDb = (MrMedicine) entityManager.createQuery(
			        "from MrMedicine where medicinename = :medicinename and expirydate = :expirydate and mclass = :mclass and subClass = :subClass")
					.setParameter("medicinename", mrMedicine.getMedicineName())
					.setParameter("expirydate", mrMedicine.getExpiryDate())
					.setParameter("mclass", mrMedicine.getmClass())
					.setParameter("subClass", mrMedicine.getSubClass())
			        .getSingleResult();
			return mrMedicineDb;
		}
		return null;
	}

	public DoctorMedicine isDoctorMedicineExist(MrMedicine mrMedicine, Doctor doctor) {
		Long count = (Long) entityManager.createQuery(
		        "SELECT  COUNT (*) from DoctorMedicine where doctor = :doctor and medicinename = :medicinename and expirydate = :expirydate and mclass = :mclass and subClass = :subClass")
				.setParameter("doctor", doctor)
				.setParameter("medicinename", mrMedicine.getMedicineName())
				.setParameter("expirydate", mrMedicine.getExpiryDate())
				.setParameter("mclass", mrMedicine.getmClass())
				.setParameter("subClass", mrMedicine.getSubClass())
		        .getSingleResult();
		if(count>0){
			DoctorMedicine doctorMedicine = (DoctorMedicine) entityManager.createQuery(
			    "from DoctorMedicine where doctor = :doctor and medicinename = :medicinename and expirydate = :expirydate and mclass = :mclass and subClass = :subClass")
				.setParameter("doctor", doctor)
				.setParameter("medicinename", mrMedicine.getMedicineName())
				.setParameter("expirydate", mrMedicine.getExpiryDate())
				.setParameter("mclass", mrMedicine.getmClass())
				.setParameter("subClass", mrMedicine.getSubClass())
		        .getSingleResult();
			System.out.println("isDoctorMedicineExist");
			return doctorMedicine;
		}
		return null;
	}

  
} // class UserDao
