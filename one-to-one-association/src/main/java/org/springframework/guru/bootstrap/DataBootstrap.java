package org.springframework.guru.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.guru.domain.Address;
import org.springframework.guru.domain.Person;
import org.springframework.guru.repository.AddressRepository;
import org.springframework.guru.repository.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DataBootstrap implements CommandLineRunner {

    private PersonRepository personRepository;
    private AddressRepository addressRepository;

    @Autowired
    public DataBootstrap(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    @Transactional
     public void run(String... args) throws Exception {
        Person person = Person.builder()
                .name("Martin")
                .email("martin.page@example.com")
                .password("1234abcd")
                .build();

        Address address = Address.builder()
                .street("Lake victoria")
                .city("Berlin")
                .state("Berlin")
                .country("Germany")
                .zipCode("10115")
                .build();

        address.setPerson(person);
        person.setAddress(address);
        addressRepository.save(address);
        personRepository.save(person);
    }
}
