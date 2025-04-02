package org.example.fileSystem;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        System.out.println("Testing FileSystemItem composite");
        var file1 = new File("file1");
        var file2 = new File("file2");
        var file3 = new File("file3");
        var file4 = new File("file4");

        var sf1 = new Folder("sf1", List.of(file1));
        var sf2 = new Folder("sf2", List.of(file2, sf1));
        var folder = new Folder("folder", List.of(sf2, file3, file4));

        folder.print("");

        System.out.println("----------------------");
        System.out.println("Using FileSystemItem in real dir");

        var dir = System.getProperty("user.dir");
        var fileSystemFromDisk = createComposeFromFile(new java.io.File(dir + java.io.File.separator + "src"));
        fileSystemFromDisk.print(">");
    }

    public static FileSystemItem createComposeFromFile(java.io.File file){
        if(!file.isDirectory()) return new File(file.getName());

        var children = new ArrayList<FileSystemItem>();
        var files = Arrays.stream(Optional.of(file.listFiles()).orElse(new java.io.File[0])).toList();
        files.forEach(f -> children.add(createComposeFromFile(f)));

        return new Folder(file.getName(), children);
    }
}
