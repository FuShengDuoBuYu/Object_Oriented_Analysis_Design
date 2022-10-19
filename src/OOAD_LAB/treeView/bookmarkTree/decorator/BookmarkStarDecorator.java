package OOAD_LAB.treeView.bookmarkTree.decorator;

import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.bookmark.MarkInfo;

public class BookmarkStarDecorator implements ILabelProvider{
    private ILabelProvider labelProvider;

    public BookmarkStarDecorator(ILabelProvider labelProvider) {
        this.labelProvider = labelProvider;
    }

    @Override
    public String getLabel(Object o) {
        if (o instanceof Bookmark) {
            return labelProvider.getLabel(o);
        }
        else {
            //add the * of the mark
            MarkInfo markInfo = (MarkInfo) o;
            if(markInfo.getReadCount()==0){
                return labelProvider.getLabel(o);
            }
            else{
                //add a * after the first "
                String label = labelProvider.getLabel(o);
                int index = label.indexOf("\"");
                return label.substring(0,index+1)+"*"+label.substring(index+1);
            }
        }
    }

    @Override
    public Integer getSomeInfo(Object o) {
        return labelProvider.getSomeInfo(o);
    }
}
