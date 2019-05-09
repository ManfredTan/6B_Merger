/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {

          int indexL0 = start0;
          int indexL1 = start1;
          ArrayList<String> newList = new ArrayList<String>(nItems);

          while ( (indexL0 < start1) && (indexL1 < 14) ) {
              if ( usersData.get(indexL0).compareTo(usersData.get(indexL1)) < 0 ) { // 0 greater
                  newList.add( usersData.get(indexL0++) );
              } else {
                  newList.add( usersData.get(indexL1++) );
              }
          }

          if (indexL0 < start1) {
              while (indexL0 < indexL1) {
                  newList.add( usersData.get(indexL0++) );
              }
          } else {
              while (indexL1 < 14) {
                  newList.add( usersData.get(indexL1++) );
              }
          }

          usersData = newList;

    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData;
    }


    /**
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}
