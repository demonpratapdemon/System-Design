package FileSystem.composite_system;

public class File extends FileSystemEntity {
	private StringBuilder content;

	public File(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.content = new StringBuilder();
	}

	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		return false;
	}

	public String read() {
		return content.toString();
	}
	
	public void write(String data) {
		this.content.append(data);
	}

}
