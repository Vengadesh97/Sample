package org.calendar;



import java.time.YearMonth;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;



public class ViewMonthClick {
	
	// Daily , Week , Bi-Weekly
		public void reptitionTextVerify1(String day1,String year1,String month1,String repeat1,String nameVerify,String meetName,String monthTime,String meetingAgen,String meetingLink,String PhoneNum,String Docum,String TM,String EntityFirm,String EntityMemb,String Individual) throws InterruptedException
		{

	/*		int dateOneLoc;
			//int day = 3; int year = 2023; int month = 8,repeat=1;
			int monthDayCount;
			
			int day =Integer.parseInt(day1);
			int year =Integer.parseInt(year1);
			int month =Integer.parseInt(month1);
			int cmonth = month;
			int rpt =Integer.parseInt(repeat1);
			int repeatCount[]= {1,7,14,0,0};
			int repeat;
			
			
			
			if(rpt<3) //Daily, Weekly, BiWeek
			{
				repeat = repeatCount[rpt];
				int week = 0, vCount=0;
				for (int j=0; j<2; j++)
				{
					int i,timeLabelCount = 0;
					//Finding total days of the month provided
					YearMonth ym = YearMonth.of(year,month);
					monthDayCount = ym.lengthOfMonth();
				    System.out.println("Month : "+month+"\tmonthDayCount : "+monthDayCount); 
				    
					// Day one count
					// dateOneLoc--> Cell Location of day 1 of current month
					dateOneLoc = findDateOneLoc(listOfallDateName);
					Thread.sleep(2000);
					int monthStart = dateOneLoc;
					monthStart = (j==0) ? (dateOneLoc+day-1) : monthStart+week;
					
				//	System.out.println("Week : "+week+" MonthStart : "+monthStart);
					
					for(i=0; i<(dateOneLoc+monthDayCount);i++)
					{
						if(i==monthStart)
						{
							String[] oneCell = allCells.get(i).getText().split("[\\r\\n]+");
							//r --> split with enter
						//	System.out.println("Date "+oneCell[0]);
				
							int flag = 0;
							for(int k = 0; k<oneCell.length;k++)
							{
								String a = oneCell[k];
								//System.out.println("a : "+a+" nameVerify : "+nameVerify);
								//11:30 AM Legal Case 5 - Case filling
								if(a.equals(nameVerify))
								{
									//System.out.println("Matched :  "+a);
									flag = 1;
									if(vCount<3)
									{
									//	System.out.println("Matched :  "+a+" vCount : "+vCount+"k: "+k+"TimeLoc : "+(timeLabelCount+k-1));
										Thread.sleep(2000);
										WebElement clickOnMeeting = allmeetingLabelText.get(timeLabelCount+k-1);
										JavascriptExecutor executor = (JavascriptExecutor) driver;
										executor.executeScript("arguments[0].click();", clickOnMeeting);
										Thread.sleep(2000);
										scrollUp();
										Thread.sleep(2000);
										assertMeetingName(meetName);
										assertMonthandTime1(oneCell[0],String.valueOf(month),String.valueOf(year),monthTime);
										assertMeetingAgenda(meetingAgen);
										assertMeetingLink(meetingLink);
									    assertPhoneNumber(PhoneNum);
										assertDocuments(Docum);
										assertTeamMember(TM);
										assertEntityandIndividual(EntityFirm);
										assertEntityandIndividual(EntityMemb);
										assertEntityandIndividual(Individual);
										Thread.sleep(2000);
										driver.navigate().back();
										Thread.sleep(4000);
										for(int z = cmonth;z<month;z++)
										{
											rightArrow.click();
											Thread.sleep(4000);
										}
										
									}
								
								}
							}
							if(flag==0)
							{
								System.out.println("flag is  "+flag);
								//assertion fail
								assertFalse(true);
							}
							
							
							if((i+repeat)<(dateOneLoc+monthDayCount))
							{
								monthStart = i + repeat;
							//	System.out.println("i = "+i+" repeat = "+ monthStart);
							}
							else
							{
								week = i+repeat-(dateOneLoc+monthDayCount);
							}
							vCount++;	
							
						}
						
						String[] cellOne = allCells.get(i).getText().split("[\\r\\n]+");
				//		System.out.println("x = "+i+"Data : " + allCells.get(i).getText() + "Length : "+ cellOne.length);
						timeLabelCount =timeLabelCount + (cellOne.length-1);
				//		System.out.println("Cell : "+i+"Length : "+ cellOne.length + "Total Count : "+timeLabelCount);
							
					}
					
				//	System.out.println("week : "+week);
					rightArrow.click();
					month = month +1;
					Thread.sleep(5000);
					if(month==13)
					{
						year++;
						month = 1;
					}
				}	
			}
			else // Month, year	
			{
				
			}
		
		}
	
	*/
	
		}
	
	
	
	
	
	

}
