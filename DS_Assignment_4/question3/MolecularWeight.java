package question3;
/**
 * this class find the molecular weight of the organic compound
 * @author Abhishek
 *
 */
public class MolecularWeight {
	/**
	 * this method check that the character is atom or not if true then return atomic weight
	 * @param atom the atom in character form
	 * @return the atomic weight of atom else return -1 or -2 according to character
	 */
	public int getAtomicWeight(Character atom)
	{
		int atomicWeight=-1;
		if(atom=='C')
		{
			atomicWeight=12;
		}
		else if(atom=='H')
		{
			atomicWeight=1;
		}
		else if(atom=='O')
		{
			atomicWeight=16;
		}
		else if(atom=='(')
		{
			atomicWeight=-2;
		}
		return atomicWeight;
	}
	/**
	 * this method find the multiplier  from the organic compound 
	 * @param compound the organic compound
	 * @param index the starting index of multiplier
	 * @return array containing the last index and value
	 */
	public int[] findMultiplier(String compound,int index)
	{
		String str=""+compound.charAt(index);
		int arr[]=new int[2];
		arr[0]=1;
		for(int i=index+1;i<compound.length();i++)
		{
			if(this.getAtomicWeight(compound.charAt(i))==-1)
			{
				arr[0]=arr[0]+1;
				str=str+compound.charAt(i);
			}
			else
			{
				break;
			}
		}
		arr[1]=Integer.parseInt(str);
		return arr;
	}
	/**
	 * this method return whole molecular weight of the compound
	 * @param compound the string of compound
	 * @return the total weight of compound
	 */
	public int getMolecularWeight(String compound)
	{
		int totalWeight=0;
		for(int i=0;i<compound.length();i++)
		{
			int atomicWeight=this.getAtomicWeight(compound.charAt(i));
			int multiplier=1;
			if(atomicWeight==-2)
			{
				int find=-1;
				for(int j=i+1;j<compound.length();j++)
				{
					if(compound.charAt(j)==')')
					{
						find=j;
						break;
					}
				}
				if(find==-1)
				{
					return find;
				}
				else
				{
					int wght=this.getMolecularWeight(compound.substring(i+1,find));
					i=find;
					if(i<compound.length())
					{
					if(this.getAtomicWeight(compound.charAt(find+1))==-1)
					{
						wght=wght*Integer.parseInt(Character.toString(compound.charAt(find+1)));
						i=i+1;
					}
					}
					totalWeight=totalWeight+wght;
				}
			}
			else if(atomicWeight!=-1)
			{

				if(i!=compound.length()-1)
				{
				int nextatomicWeight=this.getAtomicWeight(compound.charAt(i+1));
				if(nextatomicWeight==-1)
				{
					int arr[]=this.findMultiplier(compound,i+1);
					multiplier=arr[1];
					i=i+arr[0];

				}
				}
			}
			 if(atomicWeight==1)
			{
				totalWeight=totalWeight+multiplier;
			}
			else if(atomicWeight==12)
			{
				totalWeight=totalWeight+multiplier*12;
			}
			else if(atomicWeight==16)
			{
				totalWeight=totalWeight+multiplier*16;
			}
			
		}
		return totalWeight;
	}
	public static void main(String []args)
	{
		MolecularWeight molecularWeight=new MolecularWeight();
		String compound="CH3(CH3)2H2O";
		int weight=molecularWeight.getMolecularWeight(compound);
		System.out.println("wight of "+compound +" is = "+weight);
	}

}
