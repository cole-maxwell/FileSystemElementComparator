package edu.umb.cs680.hw12.fs;
import edu.umb.cs680.hw12.apfs.*;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

abstract public class FileSystem
{
	private String name;
	private int capacity;
	private int id;
	private LinkedList<FSElement> rootDirs = new LinkedList<FSElement>();

	public FileSystem (String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public FSElement initFileSystem(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		FSElement root = createDeafultRoot();
		if (root.isDirectory() && capacity >= root.getSize()) {
			setRoot(root);
			this.id = root.hashCode();
			return root;
		} else {
			System.out.println("no room left in the file system to create new file system instance");
			return null;
		}
	}
	abstract public FSElement createDeafultRoot();

	private void setRoot(FSElement root) {
		rootDirs.add(root);
	}
	public int getUsed() {
		return 0;
	}
	public int getCapacity() {
		return this.capacity;
	}
	public String getName() {
		return this.name;
	}
	public int getId() {
		return this.id;
	}
}

