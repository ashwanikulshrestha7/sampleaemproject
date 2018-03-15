package sampleProject.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.sling.api.resource.Resource;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;

public class ChildPages extends WCMUsePojo {

	private List<Page> childPages;

	@Override
	public void activate() throws Exception {
		childPages=new LinkedList<Page>();
		Resource childResource = getResource().getChild("/content/we-retail");
		Page page=childResource.adaptTo(Page.class);
		for (Iterator<Page> iterator = page.listChildren(); iterator.hasNext();) {
			Page c_page = iterator.next();
			childPages.add(c_page);
			System.out.println(c_page.getName());
			
			
		}
		
	}

	public List<Page> getChildPages() {
		return childPages;
	}
					

}
