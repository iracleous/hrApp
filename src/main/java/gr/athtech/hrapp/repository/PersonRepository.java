package gr.athtech.hrapp.repository;

import gr.athtech.hrapp.model.Person;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class PersonRepository {

    static List<Person> persons= new ArrayList<>();

     public Person createPerson(Person person){
        persons.add (person);
        return person;
    }

    public Person readPerson(int personId){
        return persons.get(personId);
    }

    public List<Person> readPerson( ){
        return persons ;
    }
    public Person updatePerson(int personId, Person person ){
      Person personB = readPerson( personId);
        personB.setEmail(person.getEmail());
        return person;
    }

    public boolean deletePerson(int personId  ){
       persons.remove(personId);
        return true;
    }

}
