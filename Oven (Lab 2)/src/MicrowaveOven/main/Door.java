package MicrowaveOven.main;

public class Door {
	
	private boolean isOpen;
	
	public Door(){
		isOpen = false;
	}
	public void Open(){
		System.out.println("Door is open.");
		isOpen = true;
	}
	public void Close(){
		System.out.println("Door is closed.");
		isOpen = false;
	}
	public boolean isOpen(){
		return isOpen;
	}
}
