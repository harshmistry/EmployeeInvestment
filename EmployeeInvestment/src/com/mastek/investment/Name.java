package com.mastek.investment;

public class Name {

	private String fName;
	private String mName;
	private String lName;
	
	public Name() {
		// TODO Auto-generated constructor stub
	}

	public Name(String fName, String fMame, String fLame) {
		super();
		this.fName = fName;
		this.mName = fMame;
		this.lName = fLame;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		return fName+" "+mName+" "+lName;
	}
	
}
