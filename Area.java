package triangle;

public class Area {

	public String getArea(double firstSide,double secondSide,double thirdSide)
	{
		double average=(double)((firstSide+secondSide+thirdSide)*1.0)/2;
		System.out.println(average);
		if(average<=firstSide || average<=secondSide || average<=thirdSide )
		{
			return "Not a valid triangle please enter valid triangle sides";
		}
		else
			{
			double area=Math.sqrt((average*(average-firstSide)*(average-secondSide)*(average-thirdSide)));
			return "Triangle Area = "+Double.toString(area);

			}
	}
	
}
