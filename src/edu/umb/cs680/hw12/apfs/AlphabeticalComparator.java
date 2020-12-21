package edu.umb.cs680.hw12.apfs;
import edu.umb.cs680.hw12.fs.*;
import java.util.Collections;
import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement>
{
	public int compare(ApfsElement apfs1, ApfsElement apfs2) {
		return apfs1.getName().compareTo(apfs2.getName());
	}
}


