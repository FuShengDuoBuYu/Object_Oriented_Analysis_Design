package OOAD_LAB.treeView.bookmarkTree;

import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.bookmark.MarkInfo;
import OOAD_LAB.treeView.ITreeContentProvider;
import javafx.util.Pair;

public class BookmarkCP implements ITreeContentProvider{

    @Override
    public Object[] getChildren(Object parentElement) {
        //bookmark
        if(parentElement instanceof Bookmark){
            Bookmark currentRoot = (Bookmark) parentElement;
            //get the current root's children,including the sub-bookmarks and the marks
            Object[] children = new Object[currentRoot.getMarks().size()+currentRoot.getSubBookmark().size()];
            int i = 0;
            for(Pair<String,MarkInfo> pair:currentRoot.getMarks()){
                children[i] = pair.getValue();
                i++;
            }
            for (Bookmark bookmark : currentRoot.getSubBookmark()) {
                children[i] = bookmark;
                i++;
            }
            if(children.length==0){
                return null;
            }
            return children;
        }
        //mark has no children
        else{
            return null;
        }

    }

    @Override
    public Object getRoot(Object o) {
        return o;
    }

}

