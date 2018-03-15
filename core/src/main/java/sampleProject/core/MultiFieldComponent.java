package sampleProject.core;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.adobe.cq.sightly.WCMUsePojo;


public class MultiFieldComponent extends WCMUsePojo {
	
	private List<TouchMultiBean> multifielditems = new ArrayList<TouchMultiBean>();

	public List<TouchMultiBean> getMultifielditems() {
		return multifielditems;
	}

	@Override
	public void activate() throws Exception {
		
		try
	    {
	      String[] itemsProps = (String[])getProperties().get("optionsList", String[].class);
	      if (itemsProps == null) {
	        System.out.println("PROPS IS NULL");
	      }
	      if (itemsProps != null) {
	        for (int i = 0; i < itemsProps.length; i++)
	        {
	        	
	      
			JSONObject jObj = new JSONObject(itemsProps[i]);
	          TouchMultiBean menuItem = new TouchMultiBean();
	          
	          String title = jObj.getString("Value");
	          
	          String text = jObj.getString("txt");
	          String image = jObj.getString("image");
	          
	          menuItem.setTitle(title);
	          menuItem.setText(text);
	          menuItem.setImage(image);
	          this.multifielditems.add(menuItem);
	          
	          System.out.println("TEXT IS " + text);
	        }
	      }
	    }
	    catch (Exception e)
	    {
	      
	    }
		
	}
	
	
	
	
	



}
