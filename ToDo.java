
public class ToDo
{
	/*Use this class to test your implementation.  This file will be overwritten for marking purposes.*/
	
	public static void main(String[] args)
	{
		Calendar test= new Calendar();

/*
		test.addItem(3,"feb","Cos 212","01:44",5 );
		test.addItem(2,"feb","Cos 212","01:44",5 );
	

*/
		test.addItem(3,"feb","Cos 212","01:44",9 );
		//test.addItem(3,"feb","Cos 212","01:44",10 );
		test.addItem(3,"jun","Cos 212","01:44",9 );
		test.addItem(3,"oct","Cos 212","01:44",8 );
		test.addItem(3,"mar","Cos 212","01:44",9 );
		test.addItem(3,"nov","Cos 212","01:44",9 );
		test.addItem(3,"dec","Cos 212","01:44",10 );
		test.addItem(3,"JAn","Cos 212","01:44",9 );
		test.addItem(3,"Apr","Cos 212","01:44",12 );
		test.addItem(3,"sep","Cos 212","01:44",9 );
		test.addItem(3,"May","Cos 212","01:44",12 );
		test.addItem(3,"Jul","Cos 212","01:44",12 );

		//test.addItem(3,"sep","Cos 212","01:44", 19);
		
/*
		test.addItem(3,"jan","Cos 212","01:44",3 );
		
		test.addItem(3,"jan","Cos 212","01:44",12 );
		
		test.addItem(3,"aug","Cos 212","01:44",5 );
		test.addItem(3,"may","Cos 212","01:44",5 );
		test.addItem(3,"jul","Cos 212","01:44",5 );
		
		test.addItem(3,"apr","Cos 212","01:44",2 );
		
	test.addItem(3,"jan","Cos 212","01:44",11 );
		test.addItem(3,"apr","Cos 212","01:44",5 );	
		test.addItem(3,"Sep","Cos 212","01:44",7 );	
	//	test.deletePriorityItem(3, "jan", 5);
		//test.deletePriorityItem(3, "jun", 9);

	/*	
test.addItem(3,"jan","Cos 212","01:44",5 );
test.addItem(3,"apr","Cos 212","01:44",9 );
test.addItem(3,"apr","Cos 212","01:44",10 );
*/


	
		
		test.addItem(1,"jan","Cos 212","01:44",9 );
		test.addItem(1,"jan","Cos 212","01:44",15 );
		//test.addItem(1,"jan","Cos 212","01:44",20 );
		test.addItem(5,"jan","Cos 212","01:44",9 );
	//	test.addItem(5,"jan","Cos 212","01:44",10);
		test.addItem(20,"jan","Cos 212","01:44",5 );
		test.addItem(7,"jan","Cos 212","01:44",5 );
		test.addItem(16,"jan","Cos 212","01:44",5 );
		test.addItem(30,"jan","Cos 212","01:44",5 );
		test.addItem(31,"jan","Cos 212","01:44",5 );
	//	test.addItem(8,"apr","Cos 212","01:44",8 );
	//	test.addItem(31,"apr","Cos 212","01:44",10);
		

		/*
		test.addItem(1,"feb","Cos 212","01:44",5 );
		test.addItem(8,"feb","Cos 212","01:44",5 );
		test.addItem(20,"feb","Cos 212","01:44",5 );

		test.addItem(7,"feb","Cos 212","01:44",5 );
		test.addItem(22,"feb","Cos 212","01:44",5 );
		test.addItem(30,"feb","Cos 212","01:44",5 );
		test.addItem(31,"feb","Cos 212","01:44",8 );
		test.addItem(31,"dec","Cos 212","01:44",7 );
		test.addItem(31,"mar","Cos 212","01:44",9 );
		test.addItem(31,"aug","Cos 212","01:44",9 );
		test.addItem(31,"jun","Cos 212","01:44",0 );
		test.addItem(31,"jan","Cos 212","01:44",20);

		test.addItem(1,"dec","Cos 212","01:44",10);
		

		//test.addItem(16,"feb","Cos 212","01:44",5 );
		



		
		*/
		
		System.out.println("");
	
		Item curr=test.monthArray[0].down;

		System.out.println("January items going down");

		while(curr != null)
		{
			
		System.out.println("the day is " + curr.getDay() + " the month is " + curr.getMonth() + " desc is " + curr.getDescription() + " time is " + curr.getDuration() + " priority is " + curr.getPriority());
		
			curr=curr.down;
		}
		System.out.println("");
	



		Item current=test.dayArray[2].right;

		System.out.println("days items going accross");

		while(current != null)
		{
		
		System.out.println("the day is " + current.getDay() + " the month is " + current.getMonth() + " desc is " + current.getDescription() + " time is " + current.getDuration() + " priority is " + current.getPriority());
		
			current=current.right;
		}
		
		
	}
}
