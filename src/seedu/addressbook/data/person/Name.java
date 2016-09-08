package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException
     *             if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
	name = name.trim();
	if (!isValidName(name)) {
	    throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
	}
	this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
	return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
	return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
	return fullName;
    }

    @Override
    public boolean equals(Object other) {
	return other == this // short circuit if same object
		|| (other instanceof Name // instanceof handles nulls
			&& this.fullName.equals(((Name) other).fullName)); // state
									   // check
    }

    @Override
    public int hashCode() {
	return fullName.hashCode();
    }

    public boolean isSimilar(Name other) {
	if (other == null) {
	    return false;
	} else if (this.fullName.equals(other.fullName)) {
	    return true;
	} else if (this.fullName.equalsIgnoreCase(other.fullName)) {
	    return true;
	} else if (this.fullName.contains(other.fullName) || other.fullName.contains(this.fullName)) {
	    return true;
	} else {
	    boolean isSimilar = false;
	    String[] splitWordsThis = this.fullName.split(" ");
	    String[] splitWordsOther = other.fullName.split(" ");
	    List<String> wordListThis = Arrays.asList(splitWordsThis);
	    List<String> wordListOther = Arrays.asList(splitWordsOther);
	    wordListThis.sort(null);
	    wordListOther.sort(null);
	    if (wordListThis.size() == wordListOther.size()) {
		isSimilar = true;
		for (int i = 0; i < wordListThis.size(); i++) {
		    if (!(wordListThis.get(i).equals(wordListOther.get(i))))
			isSimilar = false;
		}
	    }
	    return isSimilar;
	}
    }
}
