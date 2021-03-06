import java.util.ArrayList;

public class Patient {
	private int pID;
	private String fName;
	private String lName;
	private int height;//in inches
	private int weight;//in lbs
	private ArrayList<String> symptoms;
	private ArrayList<String> ills;
	private String insurance;//company name
	
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}
	public ArrayList<String> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(ArrayList<String> s)
	{
		symptoms = s;
	}
	public ArrayList<String> getIlls() {
		return ills;
	}
	public String getInsurance() {
		return insurance;
	}
	
	public Patient(int id, String fN, String lN, int hei, int wei, String insur)
	{
		pID = id;
		fName = fN;
		lName = lN;
		height = hei;
		weight = wei;
		insurance = insur;
	}
	
	public boolean addSymptom(String symp)
	{
		boolean has = false;
		for(int i = 0; i < symptoms.size(); i++)
		{
			if(symptoms.get(i) == symp)
			{
				//patient already has this symptom
				has = true;
			}
		}
		if(!has)
		{
			//if the patient does not have that symptom
			symptoms.add(symp);
		}
		return has;
	}
	
	public boolean addIllness(String ill)
	{
		boolean has = false;
		for(int i = 0; i < ills.size(); i++)
		{
			if(ills.get(i) == ill)
			{
				has = true;
			}
		}
		if(!has)
		{
			symptoms.add(ill);
		}
		return has;
	}
}
