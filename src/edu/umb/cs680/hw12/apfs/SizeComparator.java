package edu.umb.cs680.hw12.apfs;
import edu.umb.cs680.hw12.fs.*;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDateTime;

public class SizeComparator implements Comparator<ApfsElement>
{
	public int compare(ApfsElement apfs1, ApfsElement apfs2) {
		return apfs2.getSize() - apfs1.getSize();
	}
}



