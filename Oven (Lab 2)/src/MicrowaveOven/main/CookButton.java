package MicrowaveOven.main;

public class CookButton {
	
	private boolean isPressed;
	
	public CookButton(){
		isPressed = false;
	}
	public void PressedOn(){
		isPressed = true;
	}
	public void PressedOff(){
		isPressed = false;
	}
	public boolean isPressed(){
		return isPressed;
	}
}
