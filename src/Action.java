import java.awt.event.KeyEvent;

public class Action {
	
	public Action()
	{
	}
	
	public static void move(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case(KeyEvent.VK_UP):
			{
				Robot.setY(Robot.getY() - Robot.getSpeed());
				break;
			}
			case(KeyEvent.VK_DOWN):
			{
				Robot.setY(Robot.getY() + Robot.getSpeed());
				break;
			}
			case(KeyEvent.VK_LEFT):
			{
				Robot.setX(Robot.getX() - Robot.getSpeed());
				break;
			}
			case(KeyEvent.VK_RIGHT):
			{
				Robot.setX(Robot.getX() + Robot.getSpeed());
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
