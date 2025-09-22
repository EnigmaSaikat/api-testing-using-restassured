package POJOClasses;

import java.util.List;

public class Courses {
	private List<WebAutomation> webAutomation;
	private List<ApiAutomation> api;
	private List<MobileAutomation> mobile;
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWeb(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<ApiAutomation> getApi() {
		return api;
	}
	public void setApi(List<ApiAutomation> api) {
		this.api = api;
	}
	public List<MobileAutomation> getMobile() {
		return mobile;
	}
	public void setMobile(List<MobileAutomation> mobile) {
		this.mobile = mobile;
	}
	
	
}
