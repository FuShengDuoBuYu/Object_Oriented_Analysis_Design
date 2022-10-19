package OOAD_LAB;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.bookmark.MarkInfo;
import OOAD_LAB.bookmark.OperationParentNode;
import javafx.util.Pair;

public class Model {

    private Bookmark bookmark;

    public Model(Bookmark bookmark) {
        this.bookmark = bookmark;
    }

    //add OOAD_LAB.command
    public Map<OperationParentNode, ?> addCommand(String command[]) {
        //find the OOAD_LAB.bookmark place,to do something
        ArrayList<Bookmark> parentBookmarks = bookmark.findBookmarkByTitle(command[3]);
        if(parentBookmarks.size() == 0) {
            System.out.println("No such title");
            return new LinkedHashMap<>();
        }
        //we only need the first one,make the parentBookmark to be the first one
        parentBookmarks = new ArrayList<>(parentBookmarks.subList(0, 1));
        //add subtitle
        if (command[0].contains("title")) {
            Map<OperationParentNode, Bookmark> addTitleRecord = new LinkedHashMap<>();
            for (Bookmark parentBookmark : parentBookmarks) {
                Bookmark bookmark = new Bookmark(command[1], parentBookmark.getLevel() + 1, new ArrayList<>(), new ArrayList<Bookmark>());
                parentBookmark.addSubBookmark(bookmark);
                addTitleRecord.put(new OperationParentNode(parentBookmark.getLevel(), parentBookmark.getTitle()),bookmark);
            }
            return addTitleRecord;
        }
        //add OOAD_LAB.bookmark
        else {
            Map<OperationParentNode, MarkInfo> addBookmarkRecord = new LinkedHashMap<>();
            for (Bookmark parentBookmark : parentBookmarks) {
                String key = command[1].split("@")[0].substring(0,command[1].split("@")[0].length()-1);
                String value = command[1].split("@")[1].substring(1,command[1].split("@")[1].length());
                List<Pair<String,MarkInfo>>  marks = parentBookmark.getMarks();
                MarkInfo markInfo = new MarkInfo(key, value,0,false,parentBookmark.getLevel()+1);
                marks.add(new Pair<>(key,markInfo));
                addBookmarkRecord.put(new OperationParentNode(parentBookmark.getLevel(), parentBookmark.getTitle()),markInfo);
                parentBookmark.setMarks(marks);
            }
            return addBookmarkRecord;
        }
    }

    //delete OOAD_LAB.command
    public Map<OperationParentNode, ?> deleteCommand(String deleteCommand[]) {
        //we need to record the delete info to redo

        //delete title
        if (deleteCommand[0].contains("title")) {
            Map<OperationParentNode, Bookmark> res = bookmark.deleteBookmarkByTitle(deleteCommand[1]);
            return res;
        }
        //delete OOAD_LAB.bookmark
        else {
            ArrayList<Bookmark> parentBookmarks = bookmark.findBookmarkByMarkKey(deleteCommand[1]);
            Map<OperationParentNode, MarkInfo> res = new LinkedHashMap<>();
            for (Bookmark parentBookmark : parentBookmarks) {
//                Map<String, MarkInfo> marks = parentBookmark.getMarks();
                List<Pair<String,MarkInfo>> marks = parentBookmark.getMarks();
//                MarkInfo markInfo = marks.remove(deleteCommand[1]);
                ArrayList<Integer> deleteIndex = new ArrayList<>();
                for(Pair<String,MarkInfo> mark:marks){
                    if(mark.getKey().equals(deleteCommand[1])){
//                        marks.remove(mark);
//                        res.put(new OperationParentNode(parentBookmark.getLevel(), parentBookmark.getTitle()),mark.getValue());
                        deleteIndex.add(marks.indexOf(mark));
                    }
                }
                //remove and record
                for(Integer index:deleteIndex){
                    res.put(new OperationParentNode(parentBookmark.getLevel(), parentBookmark.getTitle()),marks.get(index).getValue());
                    marks.remove(index.intValue());
                }
                parentBookmark.setMarks(marks);
            }
            return res;
        }
    }

    //write the OOAD_LAB.bookmark to file
    public void saveBookmarkToFile(String fileName) {
        FileIOUtil.writeToFile(bookmark.toString(), System.getProperty("user.dir") +"\\"+ fileName);
    }

    //load the OOAD_LAB.bookmark from file
    public void loadBookmarkFromFile(String fileName) {
        //get current path
        String path = System.getProperty("user.dir");
        //clear the current OOAD_LAB.bookmark info
        bookmark.clearBookMarkInfo();
        Stack<Bookmark> parentBookmarkStack = new Stack<>();
        parentBookmarkStack.push(bookmark);
        ArrayList<String> fileContent = FileIOUtil.readFromFile(path+"\\"+fileName);
        for (String s : fileContent) {
            if (s.equals("") || s.equals(" "))
                continue;
            int level = s.lastIndexOf("#") - s.indexOf("#") + 1;
            //title
            if (s.contains("#")) {
                //pop the current parentBookMark and add the new subBookmark
                if (level <= parentBookmarkStack.peek().getLevel()) {
                    while (level <= parentBookmarkStack.peek().getLevel()) {
                        parentBookmarkStack.pop();
                    }
                    parentBookmarkStack.peek().addSubBookmark(new Bookmark(s.split(" ")[1], level, new ArrayList<>(), new ArrayList<Bookmark>()));
                }
                //add a new subBookmark
                else if (level - parentBookmarkStack.peek().getLevel() == 1) {
                    parentBookmarkStack.peek().addSubBookmark(new Bookmark(s.split(" ")[1], level, new ArrayList<>(), new ArrayList<Bookmark>()));
                }
                //push the current parentBookMark and add the new subBookmark
                else if (level - parentBookmarkStack.peek().getLevel() == 2) {
                    parentBookmarkStack.push(parentBookmarkStack.peek().getLastSubBookmark());
                    parentBookmarkStack.peek().addSubBookmark(new Bookmark(s.split(" ")[1], level, new ArrayList<>(), new ArrayList<Bookmark>()));
                }
            }
            //OOAD_LAB.bookmark
            else {
                String key = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
                String value = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
                List<Pair<String,MarkInfo>> marks = parentBookmarkStack.peek().getLastSubBookmark().getMarks();
                marks.add(new Pair<>(key,new MarkInfo(key, value, 0, false,parentBookmarkStack.peek().getLastSubBookmark().getLevel()+1)));
                parentBookmarkStack.peek().getLastSubBookmark().setMarks(marks);
            }
        }
    }

    //read some OOAD_LAB.bookmark
    public void readBookmark(String bookmarkName, Bookmark bookmark) {
        //find the OOAD_LAB.bookmark self
        bookmark.readBookmark(bookmarkName);
        //children
        for (Bookmark childBookmark : bookmark.getSubBookmark()) {
            readBookmark(bookmarkName, childBookmark);
        }
    }

    //recover from delete title undo
    public void undoFromDeleteTitle(OperationParentNode node, Bookmark b) {
        Bookmark parentBookmark = bookmark.findBookmarkByNode(node);
        parentBookmark.addSubBookmark(b,node.getIndex());
    }

    //recover from delete OOAD_LAB.bookmark undo
    public void undoFromDeleteMark(OperationParentNode node, MarkInfo markInfo) {
        Bookmark parentBookmark = bookmark.findBookmarkByNode(node);
        List<Pair<String,MarkInfo>> marks = parentBookmark.getMarks();

        marks.add(new Pair<>(markInfo.getName(),markInfo));

        parentBookmark.setMarks(marks);
    }

    //recover from add title undo
    public void undoFromAddTitle(OperationParentNode node, Bookmark b) {
        Bookmark parentBookmark = bookmark.findBookmarkByNode(node);
        List<Bookmark> subBookmarks = parentBookmark.getSubBookmark();
        for (int i = 0; i < subBookmarks.size(); i++) {
            if (subBookmarks.get(i).getTitle().equals(b.getTitle())) {
                subBookmarks.remove(i);
                break;
            }
        }
    }

    //recover from add OOAD_LAB.bookmark undo
    public void undoFromAddMark(OperationParentNode node, MarkInfo markInfo) {
        Bookmark parentBookmark = bookmark.findBookmarkByNode(node);
        List<Pair<String,MarkInfo>> marks = parentBookmark.getMarks();
        for(Pair<String,MarkInfo> mark:marks){
            if(mark.getKey().equals(markInfo.getName())){
                marks.remove(mark);
                break;
            }
        }
        parentBookmark.setMarks(marks);
    }

    public Bookmark getBookmark() {
        return bookmark;
    }
}
