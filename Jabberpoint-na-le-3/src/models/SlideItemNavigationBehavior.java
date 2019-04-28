package models;

import java.util.Vector;

public class SlideItemNavigationBehavior extends NavigationBehavior {
	public SlideItemNavigationBehavior(Presentation presentation) {
		super(presentation);
	}

	@Override
	public boolean next() {
		Slide slide = super.adaptee.getCurrentSlide();
		
		if (slide == null) {
			return false;
		}
		
		boolean result = true;
		
		Vector<SlideItem> items = slide.getSlideItems();
		SlideItem currentItem = slide.getCurrentItem();
		int nextLevel1Index = 0;
		int start = 0;
		
		if (currentItem != null) {
			start = slide.getCurrentSlideItemNumber() + 1;	
		}		
					
		nextLevel1Index = findNextLevel1Index(items, start + 1, 1);

		if (!result) {
			return false;
		}
		
		for(int j = start; j < nextLevel1Index; j++) {
			result = result && slide.nextItem();
			
			if (!result) {
				break;
			}
		}
		
		if (start == nextLevel1Index) {
			return false;
		}
		else {		
			return result;
		}
	}

	@Override
	public boolean previous() {
		Slide slide = super.adaptee.getCurrentSlide();
		
		if (slide == null) {
			return false;
		}
		
		return slide.previousItem();
	}
	
	private int findNextLevel1Index(Vector<SlideItem> items, int startIndex, int level) {
		for (int i = startIndex, len = items.size(); i < len; i++) {
			SlideItem item = items.elementAt(i);
			
			if (item.getLevel() == 1) {
				return i;
			}
		}
		
		return items.size();
	}
}
