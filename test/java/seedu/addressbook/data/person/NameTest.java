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

}
