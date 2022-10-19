package OOAD_LAB.treeView.bookmarkTree.decorator;

import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.bookmark.MarkInfo;

public class BookmarkLabelProvider implements ILabelProvider{

    @Override
    public String getLabel(Object o) {
        if (o instanceof Bookmark) {
            Bookmark bookmark = (Bookmark) o;
            return bookmark.getTitle();
        }
        else {
            MarkInfo markInfo = (MarkInfo) o;
            return "\""+markInfo.getName()+"\"";
        }
    }

    @Override
    public Integer getSomeInfo(Object o) {
        if (o instanceof Bookmark) {
            Bookmark bookmark = (Bookmark) o;
            return bookmark.getLevel();
        }
        else {
            MarkInfo markInfo = (MarkInfo) o;
            return markInfo.getLevel();
        }
    }

}
