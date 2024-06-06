/* Complete this class to implement a fully functional sparse table. Read the comments to determine what each aspect of the class is supposed to do.
You must add any additional features (methods, references) which may aid you in your
task BUT you are not allowed to remove or change the names or properties of any of the features you were given.

Note: you are NOT allowed to use any 2D or 3D arrays to simulate the sparse table functionality. Doing so will result in a mark of zero.

Importing Java's built in data structures will result in a mark of zero. Only the use of native 1-dimensional is are allowed. */

public class Calendar
{

	Item[] monthArray=new Item[12]; //create array of size 12

	Item[] dayArray=new Item[31]; //create array of size 31//because it's a string array it has buffer at end so  have to make one more space there else out f bounds

	int Monthnumber;//keeps global variable of month number

	public Calendar()
	{
		for(int x=0; x<12; x++)
		{
			 monthArray[x]= new Item(); //populate them all to null. 
		}

		for(int i=0; i<31; i++)
		{										 	
			dayArray[i]=new Item();				 			
		}
	}//end of calander constructer that populates the arrays with empty items

	
	
	/*Insertion*/

	public void addItem(int day, String month, String description, String duration, int priority)
	{
		
		Item Node=new Item(day, month, description, duration, priority);//create the node and call the constructor
		int indexOfMonth=StringtoIntmonth(month);//get the index of the month
		Item colPrev=null;


		if(monthArray[indexOfMonth].down == null)//if the first element is null.. (if the list is empty)
			{
				monthArray[indexOfMonth].down=Node;
				Node.down=null;
				DayHelperfunction(Node);
				
				//break;
			}

			else//else if the list is not empty (has elements inside.. either one or more)
				{
					Item colCurr=monthArray[indexOfMonth].down;//set current to point to first element in month array
					if( Node.getDay() < colCurr.getDay() )//if the inserting node's day is smaller than the very first element, add it before it
					{
						monthArray[indexOfMonth].down=Node;
						Node.down=colCurr;
						DayHelperfunction(Node);
						return;
						//break;
					}

					else if( Node.getDay() >= colCurr.getDay() )//else if the node's day is bigger than or equal to the first element
						{
							if( Node.getDay() == colCurr.getDay() && colCurr==monthArray[indexOfMonth].down )//if the node's day is equal to the very first element. it must meet both conditions
							{
									/*now that the day is equal, you need to chech the priorities*/

									if( Node.getPriority() > colCurr.getPriority() )//if it's the first element and the priority is bigger, it needs to replace the first element
									{
										monthArray[indexOfMonth].down=Node;
										Node.down=colCurr.down;
										Node.back=colCurr;
										

										Item dayPrev=null;
										Item dayCurr=dayArray[Node.getnewDay()].right;
										

											while( dayCurr !=null && Node.getMonth() != dayCurr.getMonth() )//traverse to find the exact same month
											{
												dayPrev=dayCurr;
												dayCurr=dayCurr.right;
											}
												if( dayPrev != null)
												{
													dayPrev.right=Node;
													Node.right=dayCurr.right;
													//dayCurr.right=null;
												return;
												}
												
																//link this manually without calling helper 	
								
										//break;
									}//end of the statement that says the node's day and priority are the exact same

									else if( Node.getPriority() <= colCurr.getPriority())//else if it's still the same day but the priority of the node is less than or equal to the current priority
										{
											Item diagPrev=null;//these pointers are for traversing the back array
											Item diagCurr=colCurr;

											while( diagCurr !=null && Node.getPriority() <= diagCurr.getPriority() ) //traverse through the back link list
											{
												diagPrev=diagCurr;
												diagCurr=diagCurr.back;
											}//end of traversing

											if( diagPrev.back !=null ) //if there are back elements and current it not at the end. (so insert in middle somewhere)
											{
												diagPrev.back=Node;
												Node.back=diagCurr;
											

												return;
												//break;
											}//end of adding in back array somewhere in middle

											else//else if the previous.back pointer does equal null. so either no element there or it's the last element in the list
											{
												diagPrev.back=Node;
												Node.back=null;
												
												return;
												//break;
											} //end of adding node in beginning or end position when it's the first node
										}//end of statement for node has same day at very beginning but less or equal priority
							}//end of statement that says the node's day is equal to the first index

							else if(colCurr!=null &&  Node.getDay() > colCurr.getDay() )//else if it's not equal to the first node but actually greater than the first node
							{
								while(colCurr!=null && Node.getDay() > colCurr.getDay() )//used to traverse the list
								{
									colPrev=colCurr;
									colCurr=colCurr.down;
								}//end of traversing the list

								if(  colCurr!=null && Node.getDay() < colCurr.getDay()  )//if adding somewhere in the middle, hence curr!= null
									{
										colPrev.down=Node;
										Node.down=colCurr;
										DayHelperfunction(Node);
										//break; 
										return;
									}//end of adding in the middle

									else if( colCurr == null && Node.getDay() > colPrev.getDay() )// if adding at the very end. current will be null and the node will be bigger than the previous one
										{
											colPrev.down=Node;
											Node.down=null;
											DayHelperfunction(Node);
											//break
										}//end of adding to the very end

										else if( Node.getDay() == colCurr.getDay() && colCurr!=monthArray[indexOfMonth].down )//if you are traversing and you find that it is now equal to one node in the middle
											{																			    	//(so current!=first node in array,  add it)
												Item diagPrev=null;//these are global to everything inside this else if
												Item diagCurr=colCurr; //these pointers are used to traverse the back linked list

												if( Node.getPriority() > colCurr.getPriority() )//if the priority of the node is bigger, add it to the front and take current to it's back
													{
														colPrev.down=Node;
														Node.down=colCurr.down;
														Node.back=colCurr;
														Item dayPrev=null;
														Item dayCurr=dayArray[Node.getnewDay()].right;

															while( dayCurr != null && Node.getMonth() != dayCurr.getMonth() )//traverse to find the exact same month
																{
																	dayPrev=dayCurr;
																	dayCurr=dayCurr.right;
																}
																if(dayPrev != null)
																{
																	dayPrev.right=Node;
																	Node.right=dayCurr.right;
																	dayCurr.right=null;				//link this manually without calling helper function
																	return;
																}
															
														//break;
													}//end of if you found it in the middle and has bigger priority

												else if( Node.getPriority() <= diagCurr.getPriority() )//if found somewhere so check if priority is less than or equal to node priority
												{
													while( diagCurr != null && Node.getPriority() <= diagCurr.getPriority() )//to traverse
														{
															diagPrev=diagCurr;
															diagCurr=diagCurr.back;
														}//end of traversing

														if( diagPrev.back != null )
															{		
																diagPrev.back=Node;
																Node.back=diagCurr;
																return;
																
																//break;
															}//end of if it's added somewhere in the middle of the back array

															else if( diagPrev.back == null )//if either first one or last one in lisy of bacl
																{
																	diagPrev.back=Node;
																	Node.back=null;
																	return;
																	//break;
																}//end of adding to front or back of back limnked list
													}//end of adding in if found and less than or equal to
											}//end of if they are equal in the middle and you have done priority checks																				  
							}//end of statement checking if it's bigger than the first node
						}//end of statement that node is bigger than or equal to first element		
				}//the end of the else statement for list is not empty
	} //end of insert

	/*Deletion*/
	
	public Item deleteItem(int day, String month, String description)
	{
		int indexOfMonth=StringtoIntmonth(month); //get the index of the month they pass in


		if(monthArray[indexOfMonth].down != null)//check if there is something in that month to try search for first
		{	
			Item colPrev=null;
			Item colCurr=monthArray[indexOfMonth].down;
			Item dayPrev=null;
			Item dayCur=dayArray[day - 1].right;


			if(monthArray[indexOfMonth].down.getDay() == day && monthArray[indexOfMonth].down.getDescription() == description )
			{
				
				monthArray[indexOfMonth].down=colCurr.down;
				colCurr.down=null;//done deleting if firtt node and if first elememnt in node
				
				//now delete from ther array
				if(dayArray[day - 1].right.getDescription() == description && dayArray[day-1].right.getDescription() == description)
				{
					dayArray[day - 1].right=dayCur.right; 
					dayCur.right= null;//if first element in node
					return colCurr;
				}
				else if(dayCur.getMonth() != month && dayCur.getDescription() != description )
				{
					while(dayCur.getMonth() != month && dayCur.getDescription() != description)//find it
					{
						dayPrev=dayCur;
						dayCur=dayCur.right;
					}

					if(dayCur.right != null && dayCur.getDescription() == description)//if not on end
					{
						dayPrev.right=dayCur.right;
						dayCur.right=null;//delete
						return dayCur;
					
					}
					else if(dayCur.right == null && dayCur.getDescription() == description)
					{
						dayPrev.right=null;//if on end delete
						dayCur=null;
						return dayCur;
					}
				}
			}
			else if(monthArray[indexOfMonth].down.getDay() != day && monthArray[indexOfMonth].down.getDescription() != description ) //else if not on first node
			{
				while(monthArray[indexOfMonth].down.getDay() != day && monthArray[indexOfMonth].down.getDescription() != description )
				{
					colPrev=colCurr;
					colCurr=colCurr.down;//traverse to find it
				}
				if(colCurr.down != null && colCurr.getDescription() == description)
					{
						colPrev.down=colCurr.down;
						colPrev.down=null;//if not on end
						return colCurr;
					
					}
					else if(colCurr.down == null && colCurr.getDescription() == description)
					{
						colCurr.right=null;//if on end
						colPrev=null;
						return colCurr;
					}//dont
					if(dayArray[day-1].getMonth()==month && dayArray[day-1].getDescription() == description)
					{
						dayArray[day - 1].right=dayCur.right; 
						dayCur.right= null;//if first element in node
					}
					 if(dayCur.getMonth() != month && dayCur.getDescription() != description )
					{
						while(dayCur.getMonth() != month && dayCur.getDescription() != description)
						{
							dayPrev=dayCur;
							dayCur=dayCur.right;
						}

						if(dayCur.right != null && dayCur.getDescription() == description)
						{
							dayPrev.right=dayCur.right;
							dayCur.right=null;//in mioddle
							return dayCur;
						}
						else if(dayCur.right == null && dayCur.getDescription() == description)
						{
							dayPrev.right=null;//in end
							dayCur=null;
							return dayCur;
						}
					}
					
			}
				   
		}
		return null;
	}

	
	
	public void deletePriorityItem(int day, String month, int priority)
	{
		int indexOfMonth=StringtoIntmonth(month); //get the index of the month they pass in


		if(monthArray[indexOfMonth].down != null)//check if there is something in that month to try search for first
		{	
			Item colPrev=null;
			Item colCurr=monthArray[indexOfMonth].down;
			Item dayPrev=null;
			Item dayCur=dayArray[day - 1].right;


			if(monthArray[indexOfMonth].down.getDay() == day && monthArray[indexOfMonth].down.getPriority() == priority )
			{
				
				monthArray[indexOfMonth].down=colCurr.down;
				colCurr.down=null;//done deleting if firtt node and if first elememnt in node
				
				//now delete from ther array
				if(dayArray[day - 1].right.getMonth() == month && dayArray[day-1].right.getPriority() == priority)
				{
					dayArray[day - 1].right=dayCur.right; 
					dayCur.right= null;//if first element in node
				}
				else if(dayCur.getMonth() != month && dayCur.getPriority() != priority )
				{
					while(dayCur.getMonth() != month && dayCur.getPriority() != priority)//find it
					{
						dayPrev=dayCur;
						dayCur=dayCur.right;
					}

					if(dayCur.right != null && dayCur.getPriority() == priority)//if not on end
					{
						dayPrev.right=dayCur.right;
						dayCur.right=null;//delete
					
					}
					else if(dayCur.right == null && dayCur.getPriority() == priority)
					{
						dayPrev.right=null;//if on end delete
						dayCur=null;
					}
				}
			}
			else if(monthArray[indexOfMonth].down.getDay() != day && monthArray[indexOfMonth].down.getPriority() != priority ) //else if not on first node
			{
				while(monthArray[indexOfMonth].down.getDay() != day && monthArray[indexOfMonth].down.getPriority() != priority )
				{
					colPrev=colCurr;
					colCurr=colCurr.down;//traverse to find it
				}
				if(colCurr.down != null && colCurr.getPriority() == priority)
					{
						colPrev.down=colCurr.down;
						colPrev.down=null;//if not on end
					
					}
					else if(colCurr.down == null && colCurr.getPriority() == priority)
					{
						colCurr.right=null;//if on end
						colPrev=null;
					}//dont
					if(dayArray[day-1].getMonth()==month && dayArray[day-1].getPriority() == priority)
					{
						dayArray[day - 1].right=dayCur.right; 
						dayCur.right= null;//if first element in node
					}
					 if(dayCur.getMonth() != month && dayCur.getPriority() != priority )
					{
						while(dayCur.getMonth() != month && dayCur.getPriority() != priority)
						{
							dayPrev=dayCur;
							dayCur=dayCur.right;
						}

						if(dayCur.right != null && dayCur.getPriority() == priority)
						{
							dayPrev.right=dayCur.right;
							dayCur.right=null;//in mioddle
						
						}
						else if(dayCur.right == null && dayCur.getPriority() == priority)
						{
							dayPrev.right=null;//in end
							dayCur=null;
						}
				   }
			}
	}	}

	
	public void deleteItems(int day, String month)
	{
		int indexOfMonth=StringtoIntmonth(month); //get the index of the month they pass in


		if(monthArray[indexOfMonth].down != null)//check if there is something in that month to try search for first
		{	
			Item colPrev=null;
			Item colCurr=monthArray[indexOfMonth].down;

			if(monthArray[indexOfMonth].down.getDay() == day)
			{
				monthArray[indexOfMonth].down=colCurr.down;
				colCurr.down=null;
			}
			else if(colCurr.getDay() != day )
			{
				while(colCurr.getDay() != day)
				{
					colPrev=colCurr;
					colCurr=colCurr.down;
				}

				if(colCurr.down != null)
				{
					colPrev.down=colCurr.down;
					colCurr.down=null;
				}
				else
				{
					colPrev=null;
					colCurr=null;
				}
			}
			else 
			return;

		}
	}
	
	/*Clearing Methods*/
	public void clearMonth(String month)/*All items for the given month should be deleted. If the month has no Items, simply do nothing.*/
	{
										
		
		int indexOfMonth=StringtoIntmonth(month); //get the index of the month they pass in
		if(monthArray[indexOfMonth].down == null)
		{
			return;
		}

		else
			{	
				Item current=monthArray[indexOfMonth].down;
				Item previous=current;
				while(previous.down != null)
				{
					previous=previous.down;
				}
				current.down=previous.down;
				monthArray[indexOfMonth].down=null;

				 //remove the items in that month //can you do this by just making it null
			}

	}
	
	public void clearDay(int day)/*All items for the given day should be deleted.	If the day has no Items, simply do nothing.*/
	{
		if(dayArray[day-1].right == null)//has to be day-1. if they pass in 4, needs to v e at index 3
		{
			return;
		}

		else
			{	
				Item current=dayArray[day-1].right;
				Item previous=current;
				while(previous.right != null)
				{
					previous=previous.right;
				}
				current.right=previous.right;
				dayArray[day-1].right=null;
			}
	}
	
	public void clearYear()
	{
		for(int i=0; i<12; i++)
		{
			monthArray[i].down=null; //can you do this. will it work? i dont see why not
		}

		for(int k=0; k<30; k++)
		{
			dayArray[k].right=null;
		}
	}
	
	
	/*Query methods*/
	public Item getItem(int day, String month)/*Return the head Item of the day and month. If no such Item exists, return null*/
	{
		
		int indexOfMonth=StringtoIntmonth(month);

		Item colcurr=monthArray[indexOfMonth].down; //keep track of traversing..
							
		if(monthArray[indexOfMonth].down != null)//if there is a list
		{
			while(colcurr.getDay() != day )
			{
				colcurr=colcurr.down; // do this until you find the item on that specific day
			}

			if(colcurr.getDay() == day)
			{
				return colcurr;
			}
		
			else
				return null;
		}
		else
			return null;
	}
	
	public Item getMonthItem(String month)/*Return the head Item for the month passed as a parameter. If no such Item exists, return null*/
	{
		int indexOfMonth=StringtoIntmonth(month);

		if( monthArray[indexOfMonth].down != null )
		{
			return monthArray[indexOfMonth].down; //has to be .down because with my kogic in the prac, down is the first item in array not stored in actual element
		}

		else
			return null;
	}
	
	public Item getDayItem(int day)/*Return the head Item for the day passed as a parameter. If no such Item exists, return null*/
	{


		if(dayArray[day-1].right != null)
		{
			return dayArray[day].right; //has to be .down because with my kogic in the prac, down is the first item in array not stored in actual element
		}
		
		
		return null;
	}	

	
	public int StringtoIntmonth(String month) //used to covert the string month and assign it to a number
	{

		
		switch (month.toLowerCase()){

			case "jan": Monthnumber=0;
			break;

			case "feb": Monthnumber=1;
			break;

			case "mar": Monthnumber=2;
			break;

			case "apr": Monthnumber=3;
			break;

			case "may": Monthnumber=4;
			break;

			case "jun": Monthnumber=5;
			break;

			case "jul": Monthnumber=6;
			break;

			case "aug": Monthnumber=7;
			break;

			case "sep": Monthnumber=8;
			break;

			case "oct": Monthnumber=9;
			break;

			case "nov": Monthnumber=10;
			break;

			case "dec": Monthnumber=11;
			break;
		}

		return Monthnumber;
				
	}





	public void DayHelperfunction(Item node)				
	{ 														
		Item dayprevious=null;
		Item daycurrent=dayArray[node.getnewDay()].right; 
																	
		if( dayArray[node.getnewDay()].right == null )		
			{	
				dayArray[node.getnewDay()].right=node;
				node.right=null;
				return;
			}
			else
				{
					if( StringtoIntmonth(node.getMonth()) > StringtoIntmonth(daycurrent.getMonth()) ) 
					{	
						while( daycurrent !=null && StringtoIntmonth(node.getMonth()) > StringtoIntmonth(daycurrent.getMonth()) )
						{
							dayprevious=daycurrent;
							daycurrent=daycurrent.right;
						}
							if(dayprevious.right!=null)
							{	dayprevious.right=node;
								node.right=daycurrent;
								return;
							}
							else
							{
								dayprevious.right=node;
								node.right=daycurrent;
								return;
							}
					}
						else if( StringtoIntmonth(node.getMonth()) < StringtoIntmonth(daycurrent.getMonth()))
							{
								dayArray[node.getnewDay()].right=node;
								node.right=daycurrent;
								return;
							}			
			}
	}

}
