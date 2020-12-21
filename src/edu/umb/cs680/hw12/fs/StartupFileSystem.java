package edu.umb.cs680.hw12.fs;
import edu.umb.cs680.hw12.apfs.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StartupFileSystem {
	public static void main(String[] args)
	{
        APFS apfs = new APFS("new apfs", 1024);
        apfs.initFileSystem("new apfs", 1024);

        ApfsDirectory root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), null); 
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), null);
        ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, LocalDateTime.now(), null);
        ApfsDirectory code = new ApfsDirectory(home, "code", 0, LocalDateTime.now(), null);
        
        ApfsFile a = new ApfsFile(null, "a.txt", 8, LocalDateTime.now(), null);
        ApfsFile b = new ApfsFile(null, "b.txt", 16, LocalDateTime.now(), null);
        ApfsFile c = new ApfsFile(null, "c.txt", 32, LocalDateTime.now(), null);
        ApfsFile d = new ApfsFile(null, "d.txt", 64, LocalDateTime.now(), null);
        ApfsFile e = new ApfsFile(null, "e.txt", 128, LocalDateTime.now(), null);
        ApfsFile f = new ApfsFile(null, "f.txt", 256, LocalDateTime.now(), null);

        ApfsLink x = new ApfsLink(home, "linkToApplications", 0, LocalDateTime.now(), applications);
        ApfsLink y = new ApfsLink(code, "linkToFileB", 0, LocalDateTime.now(), b); 

        apfs.appendRootDir(root);
        root.appendChild(applications);
        root.appendChild(home);
        home.appendChild(code);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(x);
        code.appendChild(e);
        code.appendChild(f);
        code.appendChild(y);

        System.out.println("-------- A to Z --------\n");
        System.out.println("-- SubDirectories --");
        for (ApfsDirectory subDirectory: root.getSubDirectories(new AlphabeticalComparator())) {
                        System.out.println(subDirectory + "\n");
        }
        System.out.println("-- Files --");
        for (ApfsFile file: home.getFiles(new AlphabeticalComparator())) {
			System.out.println(file + "\n");
        }
        System.out.println("-- Links --");
        for (ApfsLink link: home.getLinks(new AlphabeticalComparator())) {
			System.out.println(link + "\n");
        }

        System.out.println("-------- Z to A --------\n");
        System.out.println("-- SubDirectories --");
        for (ApfsDirectory subDirectory: root.getSubDirectories(new ReverseAlphabeticalComparator())) {
			System.out.println(subDirectory + "\n");
        }
        System.out.println("-- Files --");
        for (ApfsFile file: home.getFiles(new ReverseAlphabeticalComparator())) {
			System.out.println(file + "\n");
        }
        System.out.println("-- Links --");
        for (ApfsLink link: home.getLinks(new ReverseAlphabeticalComparator())) {
			System.out.println(link + "\n");
        }
        
        System.out.println("-------- File Size --------\n");
        System.out.println("-- Files --");
        for (ApfsFile file: home.getFiles(new SizeComparator())) {
                System.out.println(file + "\n");
        }
        System.out.println("-------- Reverse File Size --------\n");
        System.out.println("-- Files --");
        for (ApfsFile file: home.getFiles(new ReverseSizeComparator())) {
                System.out.println(file + "\n");
        }        
        System.out.println("-- Links --");
        for (ApfsLink link: home.getLinks(new ReverseSizeComparator())) {
                System.out.println(link + "\n");
        }
}
}




