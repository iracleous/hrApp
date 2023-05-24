package gr.athtech.hrapp.resource;

import gr.athtech.hrapp.model.Person;
import gr.athtech.hrapp.repository.PersonRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/f1")
public class HelloResource {

   @Inject
   private  PersonRepository personRepository;

    @Path("hello")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @Path("person")
    @GET
    @Produces("application/json")
    public List<Person> getPerson() {
        return personRepository.readPerson();
    }

    @Path("person/{personId}")
    @GET
    @Produces("application/json")
    public Person getPerson(@PathParam("personId") int personId) {
        return personRepository.readPerson(personId);
    }


    @Path("person")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Person postPerson(Person person) {
        return personRepository.createPerson(person);
    }

    @Path("person/{personId}")
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Person putPerson(@PathParam("personId") int personId,Person person ) {
       return personRepository.updatePerson(personId,person );
    }

    @Path("person/{personId}")
    @DELETE
    @Produces("application/json")
    public boolean deletePerson(@PathParam("personId") int personId) {

        return personRepository.deletePerson(personId);
    }


}