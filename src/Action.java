import java.awt.event.KeyEvent;

public class Action {
	
	public Action()
	{
	}
	
	public static void move(KeyEvent e)
	{
		//System.out.println(e);
		
		switch(e.getKeyCode())
		{
			case(KeyEvent.VK_UP):
			{
				Robot.setSpeedY(Robot.getSpeedY() - 3 * Robot.getSpeed());
				break;
			}
			case(KeyEvent.VK_DOWN):
			{
				Robot.setSpeedY(Robot.getSpeedY() + Robot.getSpeed());
				break;
			}
			case(KeyEvent.VK_LEFT):
			{
				Robot.setSpeedX(Robot.getSpeedX() - Robot.getSpeed());
				System.out.println(e);
				break;
				
			}
			case(KeyEvent.VK_RIGHT):
			{
				Robot.setSpeedX(Robot.getSpeedX() + Robot.getSpeed());
				break;
			}
			case(KeyEvent.VK_W):
			{
				//shoot up
				break;
			}
		}
	}
	
}
