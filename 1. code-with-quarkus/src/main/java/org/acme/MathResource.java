package org.acme;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/math")
public class MathResource {

    @Inject
    MathService mathService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String math() {
        return "Math operations: \n" +
                "\t/sum?firstNumber={x}&secondNumber={y} \n" +
                "\t/sub?firstNumber={x}&secondNumber={y} \n" +
                "\t/mult?firstNumber={x}&secondNumber={y} \n" +
                "\t/div?firstNumber={x}&secondNumber={y} \n";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/sum")
    public String sum(@QueryParam("firstNumber") Integer firstNumber, @QueryParam("secondNumber") Integer secondNumber) {
        return "The sum of " + firstNumber + " and " + secondNumber + " is " + mathService.sum(firstNumber, secondNumber);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/sub")
    public String sub(@QueryParam("firstNumber") Integer firstNumber, @QueryParam("secondNumber") Integer secondNumber) {
        return "The subtraction of " + firstNumber + " and " + secondNumber + " is " + mathService.sub(firstNumber, secondNumber);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/mult")
    public String mult(@QueryParam("firstNumber") Integer firstNumber, @QueryParam("secondNumber") Integer secondNumber) {
        return "The multiplication of " + firstNumber + " and " + secondNumber + " is " + mathService.mult(firstNumber, secondNumber);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/div")
    public String div(@QueryParam("firstNumber") Integer firstNumber, @QueryParam("secondNumber") Integer secondNumber) {
        try {
            return "The division of " + firstNumber + " and " + secondNumber + " is " + mathService.div(firstNumber, secondNumber);
        } catch (NumberFormatException ex) {
            throw new BadRequestException("The second number must not be zero!");
        }

    }

}