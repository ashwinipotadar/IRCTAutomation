package persistent.MavenFirstPrj;

import org.omg.CORBA.OBJ_ADAPTER;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SecondTestNGClass {
  @Test
  public void f() {
	  System.out.println("First test class");
  }
 
  @Test(dataProvider="Data")
  public void second(String movie , String movieAct, String movieActress ) {
	  System.out.println("Second test class");
	  System.out.println("Movie details !  " +movie+","+movieAct+","+movieActress);
  }
 @DataProvider(name="Data")
 public Object[][] movieData ()
 {
	 Object[][] movielist= new Object[2][3];
	 movielist[0][0]="Titanic";
	 movielist[0][1]="De";
	 movielist[0][2]="Kate";
	 movielist[1][0]="Top";
	 movielist[1][1]="De1";
	 movielist[1][2]="Kate1";
	 
	return movielist;
	 
 }
}
