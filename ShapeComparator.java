package assignment_9;

import java.util.Comparator;


class ShapeComparator implements Comparator<IShape>
{
	/**
	 * compare the objects of shape on the basis of defined rule and sort the List of objects
	 */
	public int compare(IShape shape1,IShape shape2)
	{
		if(shape1.getArea()>shape2.getArea())
		{
			return 1;
		}
		else if(shape1.getArea()<shape2.getArea())
		{
			return -1;
		}
		else
		{
			if(shape1.getPerimeter()>shape2.getPerimeter())
			{
				return 1;
			}
			else if(shape1.getPerimeter()<shape2.getPerimeter())
			{
				return -1;
			}
			else
			{
				if(((shape1.getTimeStamp()).compareTo(shape2.getTimeStamp()))!=0)
				{
					return ((shape1.getTimeStamp()).compareTo(shape2.getTimeStamp()));
				}
				else
				{
				if(shape1.originDistance()>shape2.originDistance())
				{
					return 1;
				}
				else if(shape1.originDistance()<shape2.originDistance())
				{
					return -1;
				}
				else
				{
					return 0;
				}
				}
			}
		}

	}
}


