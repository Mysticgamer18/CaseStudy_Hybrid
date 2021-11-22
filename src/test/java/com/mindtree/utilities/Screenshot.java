package com.mindtree.utilities;

import java.io.File;
import java.io.IOException;
import com.mindtree.reusablecomponent.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot extends Base {
	
	
	public static String getScreenshot(String result) throws IOException {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.dir")+"\\Screenshots\\"+System.currentTimeMillis()+result+".png";
		
		FileUtils.copyFile(src,new File(path));
		return path;
	}

}
