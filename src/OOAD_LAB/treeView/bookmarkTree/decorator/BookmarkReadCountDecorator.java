package OOAD_LAB.treeView.bookmarkTree.decorator;

import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.bookmark.MarkInfo;

public class BookmarkReadCountDecorator implements ILabelProvider{
    private ILabelProvider labelProvider;

    public BookmarkReadCountDecorator(ILabelProvider labelProvider) {
        this.labelProvider = labelProvider;
    }

    @Override
    public String getLabel(Object o) {
        if (o instanceof Bookmark) {
            return labelProvider.getLabel(o);
        }
        else {
            //add the read count of the mark
            MarkInfo markInfo = (MarkInfo) o;
            if(markInfo.getReadCount()==0){
                return labelProvider.getLabel(o);
            }
            else{
                return labelProvider.getLabel(o)+"["+markInfo.getReadCount()+"]";
            }
        }
    }

    @Override
    public Integer getSomeInfo(Object o) {
        return labelProvider.getSomeInfo(o);
    }
}
