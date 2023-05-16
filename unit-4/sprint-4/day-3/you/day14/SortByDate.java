package com.assignment.day14;

import java.util.Comparator;

public class SortByDate implements Comparator<Entry> {

	@Override
	public int compare (Entry entry1, Entry entry2) {
		
		return entry1.getDate().compareTo(entry2.getDate());
	}
}
