package hibernate;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

// This class does the 4 basic operations with the database: Create, Read, Update, Delete

public class HibernateCRUD {

	public static void main(String[] args) {
		/* From what I found, this part is necessary 
		 * to create a configuration and a session factory.
		 * This is a happy path to start using Hibernate.
		 */
		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		// Starting a new session
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Creating a couple of records
		Contact contact1 = new Contact("Frodo", "baggins.f@gmail.com", "Shire", "43233421");
		session.persist(contact1);

		Contact contact2 = new Contact("Legolas", "legolas@aol.com", "Mirkwood", "95987449");
		Serializable id = session.save(contact2);
		System.out.println("created id: " + id);

		// Reading a record with an id of 1
		Contact contact3 = (Contact) session.get(Contact.class, new Integer(1));
		// A nasty path to read from a database:
		//System.out.println("Contact3's name: " + contact3.getName());		
		// A happy path:
		if (contact3 == null) {
			System.out.println("No contact with an id of 1");
		} else {
			System.out.println("Contact3's name: " + contact3.getName());
		}

		// Update an email and a phone number for a record
		Contact contact4 = (Contact) session.load(Contact.class, new Integer(2));
		contact5.setEmail("legolas@gmail.com");
		contact5.setTelephone("3058201443");
		session.update(contact4);

		// A nasty path to deleting a record
		try {
			session.delete(contact5);
		} catch (Exception e) {
			System.out.println("No record to delete!");
		}
		// A happy path for it
		Contact contact5 = new Contact();
		session.delete(contact5);

		// Commit the transaction and close the session
		session.getTransaction().commit();
		session.close();

	}

}
