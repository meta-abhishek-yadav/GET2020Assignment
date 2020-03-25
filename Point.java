package assignment_9;

/**
 * Point class hold the origin points and return the origin value 
 * @author Abhishek
 *
 */
class Point
{
	private int xOrigin,yOrigin;
	public Point(int xOrigin,int yOrigin)
	{
		this.xOrigin=xOrigin;
		this.yOrigin=yOrigin;
	}
	/**
	 * @return xCoordinate of origin
	 */
	public int getXOrigin()
	{
		return xOrigin;
	}
	/**
	 * @return yCoordinate of origin
	 */
	public int getYOrigin()
	{
		return yOrigin;
	}
}