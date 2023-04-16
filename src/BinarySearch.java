import java.security.DrbgParameters.NextBytes;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner14;

public class BinarySearch {

	/**
	 * Search a sorted list of strings using binary search. Return a list of
	 * the indices of the strings checked during the search in the order they
	 * are checked. If the target string is not found, append -1 to the end of
	 * the list. Otherwise, the last element is the index of the target.
	 *
	 * @param strings  the list to be searched
	 * @param target  the string to be searched for
	 * @param fromIdx  the index of the first string in the range of strings to
	 *                 be searched (inclusive)
	 * @param toIdx  the index of the last string in the range of strings to be
	 *               searched (inclusive)
	 * @return a list of the indices of the strings checked during the search.
	 *         If the target is not in the list, the last element is -1.
	 */
	public static List<Integer> binarySearch(List<String> strings,
		String target, int fromIdx, int toIdx) {
		List<Integer> index = new ArrayList<Integer>();
		if(fromIdx > toIdx){
			index.add(-1);
			return index;
		}

		int midIdx = (fromIdx + toIdx) / 2;
		index.add(midIdx);
		int comp = strings.get(midIdx).compareTo(target);

		if(comp == 0)
			return index;
		else if(comp > 0)
			index.addAll(binarySearch(strings, target, fromIdx, midIdx - 1));
		else
			index.addAll(binarySearch(strings, target, midIdx + 1, toIdx));
		return index;
		}

	}
