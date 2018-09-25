package MicrowaveOven.main;

public class CancelButton {
	
	private boolean isPressed;
	
	public CancelButton(){
		isPressed = false;
	}
	public void Pressed(){
		isPressed = true;
	}
	public void notPressed(){
		isPressed = false;
	}
	public boolean isPressed(){
		return isPressed;
	}
}
