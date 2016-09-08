package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    @Test
    public void names_areEqual() throws IllegalValueException {
	Name personOne = new Name("John Doe");
	Name personTwo = new Name("John Doe");
	assertTrue(personOne.isSimilar(personTwo));
    }
    
    @Test
    public void otherName_isNull() throws IllegalValueException {
	Name personOne = new Name("John Doe");
	assertFalse(personOne.isSimilar(null));
    }
    
    @Test
    public void names_areDifferentCase() throws IllegalValueException {
	Name personOne = new Name("John Doe");
	Name personTwo = new Name("jOHN DOE");
	assertTrue(personOne.isSimilar(personTwo));
    }

    @Test
    public void names_inDifferentOrder() throws IllegalValueException {
	Name personOne = new Name("Doe John Kim");
	Name personTwo = new Name("John Kim Doe");
	assertTrue(personOne.isSimilar(personTwo));
    }
    
    @Test
    public void otherName_isSubset() throws IllegalValueException {
	Name personOne = new Name("Abraham Lincoln");
	Name personTwo = new Name("Abra");
	assertTrue(personOne.isSimilar(personTwo));
    }
    
    @Test
    public void otherName_isSuperset() throws IllegalValueException {
	Name personOne = new Name("Abra");
	Name personTwo = new Name("Abraham Lincoln");
	assertTrue(personOne.isSimilar(personTwo));
    }
}
