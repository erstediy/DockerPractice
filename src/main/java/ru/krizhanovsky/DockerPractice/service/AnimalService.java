package ru.krizhanovsky.DockerPractice.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ru.krizhanovsky.DockerPractice.entity.Animal;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnimalService {
    private final SessionFactory sessionFactory;

    public AnimalService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Animal> getAll(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Animal", Animal.class).getResultList();
    }

    @Transactional
    public void addAnimal(Animal animal){
        Session session = sessionFactory.getCurrentSession();
        session.save(animal);
    }

    @Transactional
    public Animal getAnimalById(Long id){
        Session session = sessionFactory.getCurrentSession();
        //return (Animal) session.createNativeQuery("select * from Animal where id =" + id).getSingleResult();
        return session.get(Animal.class,id);
    }
}
