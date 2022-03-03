public class Disc implements Comparable<Disc>{
	
	private int size;
	
	public Disc(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

	@Override
	public int compareTo(Disc other) {
		return size - other.size;
	}
	
	public String toString() {
		return "disc size:" + size;
	}
	
	

}