package org.springframework.guru.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.guru.domain.Address;
import org.springframework.guru.domain.Person;

import javax.transaction.Transactional;

import java.util.Iterator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

@Autowired
PersonRepository personRepository;
@Autowired
AddressRepository addressRepository;
Person person;
Address address;
Long addressId,personId;
    @BeforeEach
    public void setUp(){
            person = Person.builder()
                .name("Martin")
                .email("martin.page@example.com")
                .password("1234abcd")
                .build();

         address = Address.builder()
                .street("Lake victoria")
                .city("Berlin")
                .state("Berlin")
                .country("Germany")
                .zipCode("10115")
                .build();

        address.setPerson(person);
        person.setAddress(address);
        Address savedAddress = addressRepository.save(address);
        Person savedPerson= personRepository.save(person);
        addressId=savedAddress.getId();
        personId=savedPerson.getId();
    }

    @Test
    public void testGetPersonWithAddress(){
         Person person= personRepository.findById(personId).orElse(null);
         assertNotNull(person.getAddress());
         assertEquals("Berlin",person.getAddress().getCity());
         }


    @Test
    public void testGetAddressWithPerson(){
        Address address= addressRepository.findById(addressId).orElse(null);
        assertNotNull(address.getPerson());
        assertEquals("Martin",address.getPerson().getName());
    }

    @Test
    public void testDeleteCascade() {
        personRepository.delete(person);
        Address address = addressRepository.findById(addressId).orElse(null);
        assertNull(address);

    }
}