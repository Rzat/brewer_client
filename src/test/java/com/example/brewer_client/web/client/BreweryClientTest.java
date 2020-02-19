package com.example.brewer_client.web.client;

import com.example.brewer_client.web.model.BeerDto;
import com.example.brewer_client.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;


    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Testing").build();
        URI uri = breweryClient.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Testing Update").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeer() {
        //given
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Testing").build();
        URI uri = breweryClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Testing").build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        //given
        breweryClient.deleteCustomer(UUID.randomUUID());
    }

}