
public class Periodical extends Item{

	private int issueNumber;
	
	public Periodical(String str, int num) {
		super(str);
		issueNumber = num;
	}
	
	public void setIssueNumber(int num) {
		issueNumber = num;
	}
	
	public int getIssueNumber() {
		return issueNumber;
	}

	@Override
	public String print() {
		return "Name: " + getName() + '\n' +
				"Issue Number: " + getIssueNumber();
	}

	@Override
	public int compareTo(Item o) throws ClassCastException{
		if(!(o instanceof Periodical)){
			throw new ClassCastException("Cannot cast object to Periodical");
		}
		Periodical p = (Periodical)o;
		
		return issueNumber - p.getIssueNumber();
		
	}
	
	@Override
	public String info() {
		return getName() +  " - " + issueNumber;
	}

}
