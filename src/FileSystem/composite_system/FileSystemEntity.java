package FileSystem.composite_system;

public abstract class FileSystemEntity {
	protected String name;

	public FileSystemEntity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract boolean isDirectory();
}
