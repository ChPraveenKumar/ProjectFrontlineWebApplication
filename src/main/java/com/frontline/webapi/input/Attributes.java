package com.frontline.webapi.input;

public class Attributes {
	public String additionalProp1;
    public String additionalProp2;
    public String additionalProp3;
	public String getAdditionalProp1() {
		return additionalProp1;
	}
	public void setAdditionalProp1(String additionalProp1) {
		this.additionalProp1 = additionalProp1;
	}
	public String getAdditionalProp2() {
		return additionalProp2;
	}
	public void setAdditionalProp2(String additionalProp2) {
		this.additionalProp2 = additionalProp2;
	}
	public String getAdditionalProp3() {
		return additionalProp3;
	}
	public void setAdditionalProp3(String additionalProp3) {
		this.additionalProp3 = additionalProp3;
	}
	@Override
	public String toString() {
		return "Attributes [additionalProp1=" + additionalProp1 + ", additionalProp2=" + additionalProp2
				+ ", additionalProp3=" + additionalProp3 + "]";
	}
    
}
