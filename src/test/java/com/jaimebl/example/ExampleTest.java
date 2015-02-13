package com.jaimebl.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jaime on 12/02/2015.
 */
@Test
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class ExampleTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ApplicationContext _appContext;

    //OBJ TO XML
    public void marshal(){
        CustomerName customerName = new CustomerName();
        customerName.setId(100);
        customerName.setFullName("mkyong");

        Address address = new Address();
        address.setStreet("road");
        address.setAddressType("tipo1");

        customerName.setShippingAddress(address);

        try {
            //Explicitly creating moxy JAXBContext rather than jaxb.properties approach
            //JAXBContext jaxbContext = JAXBContextFactory.createContext(new Class[]{Customer.class}, null);
            JAXBContext jaxbContext = JAXBContext.newInstance(CustomerName.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customerName, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void unmarshal(){
        try {

            //File file = new File("C:\\file.xml");
            Resource resource = _appContext.getResource("classpath:input/file.xml");

            File file = resource.getFile();
            JAXBContext jaxbContext = JAXBContext.newInstance(CustomerName.class);

            Unmarshaller jaxbUnmarshaller = null;
            try {
                jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            CustomerName customerName = (CustomerName) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customerName);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


