package MicrowaveOven.main;

import java.util.Scanner;

public class Oven {
	
	private Beeper beeper;
	private Door door;
	private Light light;
	private MyTimer mytimer;
	private PowerTube powertube;
	
	public Oven(){
		beeper = new Beeper();
		door = new Door();
		light = new Light();
		powertube = new PowerTube();
		mytimer = new MyTimer(this);
	}
	public void TimerExpired(){
		powertube.Off();
		light.Off();
    		for (int i = 0; i < 3; ++i)
    		{
    			beeper.beep();
    		}
    }
	public void pressedCookButton(){
		if(door.isOpen())
		{
			beeper.beep();
		}
		else if(mytimer.isRunning())
		{
			beeper.beep();
			mytimer.AddExtraMinute();
		}
		else
		{
			beeper.beep();
			light.On();
			powertube.On();
			mytimer.Add1Minute();
		}
	}
	public void pressedCancelButton(){
		if(mytimer.isRunning())
		{
			beeper.beep();
			light.Off();
			mytimer.Cancel();
			powertube.Off();
			System.out.println("Cooking canceled by pressing Cancel.");
		}
		else
		{
			beeper.beep();
		}
	}
	public void openedDoor(){
		if(door.isOpen())
		{
			door.Close();
		}
		else if(mytimer.isRunning())
		{
			beeper.beep();
			light.Off();
			powertube.Off();
			mytimer.Cancel();
			door.Open();
		}
		else
		{
			beeper.beep();
			door.Open();
		}
	}
	public void go()
	{
		Scanner scan = new Scanner(System.in);
		try{
			char character = ' ';
			while(character != 'q'){
				System.out.println("Enter 'p' to cook, 'c' to cancel, "
						+ "'d' to open and close the door, and 'q' to"
						+ " quit: ");
				character = scan.next().charAt(0);
				switch(character){
				case 'p':
					pressedCookButton();
					break;
				case 'c':
					pressedCancelButton();
					break;
				case 'd': 
					openedDoor();
					break;
				case 'q':
					if(mytimer.isRunning()){
					mytimer.Cancel();
					}
					System.out.println("Quitting...");
					break;
				default:
					System.out.println("Invalid Command.");
				}
			}
		}finally{
			scan.close();
		}
	}
	public static void main(String[] args){
		Oven test = new Oven();
		test.go();
	}
}
