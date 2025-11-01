package FileSystem.composite_system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory extends FileSystemEntity {
	private Map<String, FileSystemEntity> child;

	public Directory(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.child = new HashMap<String, FileSystemEntity>();
	}

	public Map<String, FileSystemEntity> getChild() {
		return child;
	}

	public void addEntity(FileSystemEntity entity) {
		this.child.put(entity.getName(), entity);
	}
	
	public void removeEntity(String name) {
		this.child.remove(name);
	}
	
	public FileSystemEntity getEntity(String name) {
		return this.child.get(name);
	}
	
	public List<String> list() {
		List<String> res = new ArrayList<String>(this.child.keySet());
		Collections.sort(res);
		return res;
	}

	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		return true;
	}

}
