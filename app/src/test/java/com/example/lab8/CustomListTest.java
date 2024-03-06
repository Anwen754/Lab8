package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void hasCityTest(){
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));

        City testCity = new City("Edmonton", "AB");

        assertFalse(list.hasCity(testCity));
    }

    @Test
    public void removeCityTest(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        City testCity = new City("Edmonton", "AB");

        list.deleteCity(city);
        assertFalse(list.hasCity(city));

        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(testCity);
        });
    }

    @Test
    public void countCitiesTest(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        City testCity = new City("Edmonton", "AB");
        list.addCity(testCity);

        assertEquals(list.getCount(), 2);
    }
}
