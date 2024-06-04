/* You must complete this class such that it can be used as nodes in a 3D sparse table.
Read the comments to determine what each aspect of the class is supposed to do.
You may add any additional features (methods, references) which may aid you in your
task BUT you are not allowed to remove or change the names or properties of any of the features you where given.

Importing Java's built in data structures will result in a mark of 0. */

public class Item
{
	public Item(String desc, String dur, int p )
	{
		description=desc;
		back=null;
		right=null;
		down=null;

			if(p<0)
				{
					priority=0; //have to validate the data and check it. if it.s invalid, set it to 0
				}
			else
				priority=p;

		String hour=dur.substring(0, 2);//get hh value
		String minute=dur.substring(3);//get mm value
		int h=Integer.parseInt(hour);
		int m=Integer.parseInt(minute);

		if( h >=00 && h <24 ) //if the hour is greater than or equal to 00 and the hour is less than 24
		{
			if(m >=00 && m <=59)//if the minutes are greater than or equal to 0 and less than or equal to 59, it's valid
			{
				duration=dur;//set the duration
			}
		}//if it meets every condition except one, namely 24:10 (any minute value when on hour 24 is invalid)

			else if( h == 24 && m == 00 )
				{
					duration=dur;//set the duration
				}
					else
						duration="00:00";

		
	}	
	public Item( )
	{
	//empty constructor
				
	}	

	public Item(int day, String month, String desc, String dur, int p )
	{
		description=desc;
		this.day=day;
		this.month=month;
		back=null;
		right=null;
		down=null;
		newday=day-1;
		
		
			if(p<0)
				{

				priority=0; //have to validate the data and check it. if it.s invalid, set it to 0

				}
			else
				priority=p;


		String hour=dur.substring(0, 2);//get hh value
		String minute=dur.substring(3);//get mm value
		int h=Integer.parseInt(hour);
		int m=Integer.parseInt(minute);

		if(h >=00 && h <24) //if the hour is greater than or equal to 00 and the hour is less than 24, it's valid
		{
			if(m >=00 && m <=59)//if the minutes are greater than or equal to 0 and less than or equal to 59, it's valid
			{
				duration=dur;//set the duration
			}
		}
			else if( h ==24 && m ==00 )
				{
					duration=dur;//set the duration
				}
					else
						duration="00:00";


	}	
	
	public void setDescription(String desc)
	{
		description=desc;
	}	
	
	public void setDuration(String dur)
	{
		duration=dur;
	}	
	
	public void setPriority(int p)
	{
		priority=p;
	}
	
	public String getDescription()
	{
		/* This method returns the description of this Item */
		return description;
	}	

	public String getMonth()
	{
		/* This method returns the description of this Item */
		return month;
	}

	public int getDay()
	{
		/* This method returns the description of this Item */
		return day;
	}
	public int getnewDay()
	{
		/* This method returns the description of this Item */
		return newday;
	}
	
	public String getDuration()
	{
		/* This method returns the duration of this Item */
		return duration;
	}
	
	public int getPriority()
	{
		/* This method returns the duration of this Item */
		return priority;
	}
	
	
	public Item back; // The next Item (back) of this to-do list on the same date
	public Item right; // The next Item (right) of this Item on the same day (1st to 31st).
	public Item down; // The next Item (down) of this Item in the same month.
	
	//Item particulars:
	private String description; // A description for this Item.
	private String duration; // The number of minutes/hours that the Item will take.
	private int priority; // The priority of the Item.
	private String month; //month the item is added in
	private int day; //day item is added in
	private int newday;
	
}






