package FileSystem;

import FileSystem.controller.FileSystem;

public class FileSystemClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileSystem fs = new FileSystem();

		fs.mkdir("/a/b");
		fs.addFile("/a/b/file1.txt", "Hello World!");

		fs.addFile("/a/b/file2.txt", "This is another test file.");
		fs.mkdir("/a/b/c");
		fs.addFile("/a/b/c/nested.txt", "Nested content inside folder C.");

		fs.mkdir("/d");
		fs.addFile("/d/log.txt", "System logs here...");

		System.out.println("File System Hierarchy:\n");
		fs.getDetails("/");
		
		System.out.println("\nAfter deleting /a/b/file1.txt:\n");
        fs.delete("/a/b/file1.txt");
        fs.getDetails("/");
	}

}
