package pl.rozkocha.szymon.jdbc_sample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUsersDAO implements IDAO<User> {
	private SessionFactory factory;
	
	HibernateUsersDAO(String cfg) {
		Configuration configuration = new Configuration();
    	configuration.configure(App.class.getClassLoader().getResource(cfg));
    	factory = configuration.buildSessionFactory();
	}
	
	@Override
	public List<User> get() {
		Session session = factory.openSession();
		
    	List<User> users = (List<User>)session.createQuery("from User").list();

    	session.close();
		
		return users;
	}
	
	public User getById(int id) {
		Session session = factory.openSession();
		
		User user = session.find(User.class, id);
		
		session.close();
		
		return user;
	}

	@Override
	public void add(User beam) {
		Session session = factory.openSession();
		
		session.save(beam);
		
		session.close();
	}

	@Override
	public void update(User beam) {
		Session session = factory.openSession();
		
		session.update(beam);
		
		session.close();
	}

	@Override
	public void delete(User beam) {
		Session session = factory.openSession();
		
		session.delete(beam);
		
		session.close();
	}

}
