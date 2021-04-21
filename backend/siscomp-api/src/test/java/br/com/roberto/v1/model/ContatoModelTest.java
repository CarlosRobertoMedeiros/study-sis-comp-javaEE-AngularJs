package br.com.roberto.v1.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContatoModelTest {

    private List<String> items;

    @Before
    public void init() throws Exception{
       items = Arrays.asList("John", "James", "Julia", "Jim");
   }

   @Test
   public void testAssetThatExamples(){

       // items list should have James and Jim
       assertThat(items, hasItems("James", "Jim"));

       // Every item in the list should have the character 'J'
       assertThat(items, everyItem(containsString("J")));

       // check all of the matchers
       assertThat("Once", allOf(equalTo("Once"), startsWith("O")));

       // negation of all of the matchers
       assertThat("Once", not(allOf(equalTo("test"), containsString("test"))));


   }


}
