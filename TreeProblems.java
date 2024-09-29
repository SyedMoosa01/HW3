/*
 * *** YOUR NAME GOES HERE / YOUR SECTION NUMBER ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

import java.util.*;

public class TreeProblems {

  /**
   * Method different()
   *
   * Given two TreeSets of integers, return a TreeSet containing all elements 
   * that are NOT in both sets. In other words, return a TreeSet of all the
   * elements that are in one set but not the other.
   */
  
  public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {
    if (setA == null || setB == null) {
      throw new IllegalArgumentException("Input sets cannot be null");
    }

    Set<Integer> resultSet = new TreeSet<>(setA);
    resultSet.removeAll(setB); // Elements in setA but not in setB

    for (Integer value : setB) {
      if (!setA.contains(value)) {
        resultSet.add(value); // Add elements in setB but not in setA
      }
    }

    return resultSet; // Return the combined set of unique elements
  }


  /**
   * Method removeEven()
   *
   * Given a treeMap with the key as an integer, and the value as a String,
   * remove all <key, value> pairs where the key is even. 
   */

  public static void removeEven(Map<Integer, String> treeMap) {
// Use an iterator to safely remove entries while iterating
    Iterator<Map.Entry<Integer, String>> iterator = treeMap.entrySet().iterator();

    while (iterator.hasNext()) {
      Map.Entry<Integer, String> entry = iterator.next();
      if (entry.getKey() % 2 == 0) {
        iterator.remove(); // Remove the entry if the key is even
      }
    }
  }


  /**
   * Method treesEqual()
   *
   * Given two treeMaps, each with the key as an integer, and the value as a String,
   * return a boolean value indicating if the two trees are equal or not.
   */

  public boolean treesEqual(Map<Integer, String> tree1,Map<Integer, String> tree2 ) {

    // Check for null maps
    if (tree1 == null || tree2 == null) {
      return false; // Consider null maps as not equal
    }


    //check if the sizes are the same
    if (tree1.size() != tree2.size()) {
      return false; // Not equal if sizes differ
    }

    // Compare the entries of both maps
    for (Map.Entry<Integer, String> entry : tree1.entrySet()) {
      // Check if the key exists in tree2 and the values are the same
      if (!tree2.containsKey(entry.getKey()) ||
              !tree2.get(entry.getKey()).equals(entry.getValue())) {
        return false; // If key or value doesn't match, they're not equal
      }
    }

    return true; // Trees are equal if all checks pass
  }

} // end treeProblems class
