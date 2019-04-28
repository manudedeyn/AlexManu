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
					
		nextLevel1Index = findNextLevelIndex(items, start + 1, 1);

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
		
		boolean result = true;
		
		Vector<SlideItem> items = slide.getSlideItems();
		SlideItem currentItem = slide.getCurrentItem();
		
		int startIndex = 0;
		int previousLevel1Index = 0;
		
		if (currentItem != null) {
			startIndex = slide.getCurrentSlideItemNumber() + 1;	
		}	
					
		previousLevel1Index = findPreviousLevelIndex(items, startIndex - 1, 1);

		if (!result) {
			return false;
		}
		
		for(int j = startIndex; j > previousLevel1Index; j--) {
			result = result && slide.previousItem();
			
			if (!result) {
				break;
			}
		} 
		
		if (startIndex == previousLevel1Index) {
			return false;
		}
		else {		
			return result;
		}
		

	}
	
	private int findNextLevelIndex(Vector<SlideItem> items, int startIndex, int level) {
		for (int i = startIndex, len = items.size(); i < len; i++) {
			SlideItem item = items.elementAt(i);
			
			if (item.getLevel() == level) {
				return i;
			}
		}
		
		return items.size();
	}
	
	private int findPreviousLevelIndex(Vector<SlideItem> items, int startIndex, int level) {
		for (int i = startIndex; i >= 0; i--) {
			SlideItem item = items.elementAt(i);
			
			if (item.getLevel() == level) {
				return i;
			}
		}
		
		return items.size();
	}
}
