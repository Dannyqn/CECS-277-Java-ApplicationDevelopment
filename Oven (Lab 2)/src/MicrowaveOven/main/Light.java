package MicrowaveOven.main;

public class Light {
	
	private boolean isOn;
	
	public Light(){
		isOn = false;
	}
	public void On(){
		System.out.println("Light is ON.");
		isOn = true;
	}
	public void Off(){
		System.out.println("Light is OFF.");
		isOn = false;
	}
	public boolean isOn(){
		return isOn;
	}
}
