public class StringPair {
	private String first;
	private String second;
	
	public StringPair(String first, String second) {
		super();
		this.first = first;
		this.second = second;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "StringPair [first=" + first + ", second=" + second + "]";
	}
	
	public boolean equals(Object x) {
		StringPair other = (StringPair)x;
		return this.first.equals(other.first) &&
				this.second.equals(other.second);
	}	
}







