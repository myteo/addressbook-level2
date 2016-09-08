package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    @Test
    public void names_areEqual() throws IllegalValueException {
	Name personOne = new Name("John Doe");
	Name personTwo = new Name("John Doe");
	assertEquals(true, personOne.isSimilar(personTwo));
    }

}
