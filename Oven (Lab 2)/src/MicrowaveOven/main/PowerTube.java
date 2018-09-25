package MicrowaveOven.main;

public class PowerTube {
	
	private boolean isOn;
	
	public PowerTube(){
		isOn = false;
	}
	public void On(){
		System.out.println("Power tube is ON");
		isOn = true;
	}
	public void Off(){
		System.out.println("Power tube is OFF");
		isOn = false;
	}
	public boolean isOn(){
		return isOn;
	}
}
