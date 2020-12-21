package edu.umb.cs680.hw12.apfs;
import edu.umb.cs680.hw12.fs.*;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDateTime;

public class ReverseSizeComparator implements Comparator<ApfsElement>
{
	public int compare(ApfsElement apfs1, ApfsElement apfs2) {
		return apfs1.getSize() - apfs2.getSize();
	}
}



