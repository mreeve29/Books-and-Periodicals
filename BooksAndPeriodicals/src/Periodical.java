
public class Periodical extends Item{

	//class object
	private int issueNumber;
	
	//constructor
	public Periodical(String str, int num) {
		super(str);
		issueNumber = num;
	}
	
	//issue number setter
	public void setIssueNumber(int num) {
		issueNumber = num;
	}
	
	//issue number getter
	public int getIssueNumber() {
		return issueNumber;
	}

	//print all info
	@Override
	public String print() {
		return "Name: " + getName() + '\n' +
				"Issue Number: " + getIssueNumber();
	}

	//compares periodicals to each other by issue number
	@Override
	public int compareTo(Item o) throws ClassCastException{
		if(!(o instanceof Periodical)){
			throw new ClassCastException("Cannot cast object to Periodical");
		}
		Periodical p = (Periodical)o;
		
		return p.getIssueNumber() - issueNumber;
		
	}
	
	//print basic info
	@Override
	public String info() {
		return getName() +  " - " + issueNumber;
	}

}
