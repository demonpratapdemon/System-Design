package FileSystem.controller;

import java.util.ArrayList;
import java.util.List;

import FileSystem.composite_system.Directory;
import FileSystem.composite_system.File;
import FileSystem.composite_system.FileSystemEntity;

public class FileSystem {

	private Directory root;

	public FileSystem() {
		this.root = new Directory("/");
	}

	private Directory traverseToParentDir(String path) {
		String[] parts = path.split("/");
		Directory curr = root;

		for (int i = 1; i < parts.length - 1; i++) {
			FileSystemEntity next = curr.getEntity(parts[i]);
			if (next == null || !next.isDirectory())
				throw new RuntimeException("Invalid path: " + path);
			curr = (Directory) next;
		}

		return curr;
	}

	private FileSystemEntity traverseToEntity(String path) {
		if (path.equals("/"))
			return root;

		String[] parts = path.split("/");
		Directory curr = root;

		for (int i = 1; i < parts.length; i++) {
			FileSystemEntity next = curr.getEntity(parts[i]);
			if (next == null)
				throw new RuntimeException("Invalid path: " + path);
			if (i == parts.length - 1)
				return next;
			if (!next.isDirectory())
				throw new RuntimeException("Invalid intermediate path: " + path);
			curr = (Directory) next;
		}

		return curr;
	}

	public void mkdir(String path) {
		String[] parts = path.split("/");
		Directory curr = root;

		for (int i = 1; i < parts.length; i++) {
			curr.getChild().putIfAbsent(parts[i], new Directory(parts[i]));
			curr = (Directory) curr.getEntity(parts[i]);
		}
	}

	public void addFile(String path, String content) {
		String[] parts = path.split("/");
		Directory parent = traverseToParentDir(path);
		String fileName = parts[parts.length - 1];
		File file = new File(fileName);
		file.write(content);
		parent.addEntity(file);
	}

	public String readFile(String path) {
		File file = (File) traverseToEntity(path);
		return file.read();
	}

	public List<String> list(String path) {
		FileSystemEntity entity = traverseToEntity(path);
		if (entity.isDirectory()) {
			return ((Directory) entity).list();
		}
		return List.of(entity.getName());
	}

	public void delete(String path) {
		if (path.equals("/"))
			throw new RuntimeException("Cannot delete root directory");

		Directory parent = traverseToParentDir(path);
		String name = path.substring(path.lastIndexOf("/") + 1);
		if (!parent.getChild().containsKey(name))
			throw new RuntimeException("Entity Not Found: " + path);
		parent.removeEntity(name);
	}

	public void move(String srcPath, String destPath) {
		if (srcPath.equals("/") || destPath.equals("/"))
			throw new RuntimeException("Cannot move root");

		Directory srcParent = traverseToParentDir(srcPath);
		Directory destParent = traverseToParentDir(destPath);

		String srcName = srcPath.substring(srcPath.lastIndexOf("/") + 1);
		String destName = destPath.substring(destPath.lastIndexOf("/") + 1);

		FileSystemEntity entity = srcParent.getEntity(srcName);
		if (entity == null)
			throw new RuntimeException("Source not found: " + srcPath);

		if (!srcName.equals(destName))
			entity.setName(destName);

		destParent.addEntity(entity);
		srcParent.removeEntity(srcName);
	}

	public void getDetails(String path) {
		FileSystemEntity entity = traverseToEntity(path);
		printEntity(entity, 0);
	}

	private void printEntity(FileSystemEntity entity, int depth) {
		// TODO Auto-generated method stub
		String indent = "  ".repeat(depth);
		if (entity.isDirectory()) {
			System.out.println(indent + "[DIR] " + entity.getName());
			Directory dir = (Directory) entity;
			for (String name : dir.list()) {
				printEntity(dir.getEntity(name), depth + 1);
			}
		} else {
			File file = (File) entity;
			String preview = file.read();
			if (preview.length() > 30)
				preview = preview.substring(0, 30) + "...";
			System.out.println(indent + "- " + file.getName() + " [FILE] Content: \"" + preview + "\"");
		}
	}
}
