package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void utils_isAnyNull_returnsTrue() {
	Object[] objArr = {"Hello", "Goodbye", null};
	assertEquals(true, Utils.isAnyNull(objArr));
    }
    
    @Test
    public void utils_isAnyNull_returnsFalse(){
	Object[] objArr = {"Hello", "Goodbye", "Hello again"};
	assertEquals(false, Utils.isAnyNull(objArr));
    }
    
    @Test
    public void utils_elementsAreUnique_returnsTrue(){
	ArrayList<String> objList = new ArrayList<String>();
	objList.add("Hello");
	objList.add("Goodbye");
	objList.add("Hello again");
	assertEquals(true, Utils.elementsAreUnique(objList));
    }
    
    @Test
    public void utils_elementsAreUnique_returnsFalse(){
	ArrayList<String> objList = new ArrayList<String>();
	objList.add("Hello");
	objList.add("Goodbye");
	objList.add("Hello again");
	objList.add("Hello again");
	assertEquals(false, Utils.elementsAreUnique(objList));
    }

}
