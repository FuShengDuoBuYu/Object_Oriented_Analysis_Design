package OOAD_LAB.treeView.bookmarkTree;

import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.treeView.INameProvider;
import OOAD_LAB.treeView.bookmarkTree.decorator.BookmarkLabelProvider;
import OOAD_LAB.treeView.bookmarkTree.decorator.BookmarkReadCountDecorator;
import OOAD_LAB.treeView.bookmarkTree.decorator.BookmarkStarDecorator;
import OOAD_LAB.treeView.bookmarkTree.decorator.ILabelProvider;

import java.util.ArrayList;

public class BookmarkNP implements INameProvider {

    @Override
    public String getName(Object o) {
        ILabelProvider labelProvider = new BookmarkStarDecorator((new BookmarkLabelProvider()));
        return labelProvider.getLabel(o)+" "+labelProvider.getSomeInfo(o);
    }

}
